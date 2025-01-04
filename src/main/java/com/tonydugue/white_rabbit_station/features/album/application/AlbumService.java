package com.tonydugue.white_rabbit_station.features.album.application;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumRequest;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumResponse;
import com.tonydugue.white_rabbit_station.features.album.mapper.AlbumMapper;
import com.tonydugue.white_rabbit_station.features.album.repository.AlbumRepository;
import com.tonydugue.white_rabbit_station.features.user.domain.User;
import com.tonydugue.white_rabbit_station.infrastructure.file.FileStorageService;
import com.tonydugue.white_rabbit_station.shared.common.PageResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

  private final AlbumRepository albumRepository;
  private final AlbumMapper albumMapper;
  private final FileStorageService fileStorageService;

  public Integer save(AlbumRequest request, Authentication connectedUser) {
    User user = ((User) connectedUser.getPrincipal());
    Album album = albumMapper.toAlbum(request);
    album.setOwner(user);
    return albumRepository.save(album).getId();
  }

  public AlbumResponse findById(Integer albumId) {
    return albumRepository.findById(albumId)
            .map(albumMapper::toAlbumResponse)
            .orElseThrow(() -> new EntityNotFoundException("No album found with ID:: " + albumId));
  }

  public PageResponse<AlbumResponse> findAllAlbums(int page, int size, Authentication connectedUser) {
    Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
    Page<Album> albums = albumRepository.findAll(pageable);
    List<AlbumResponse> albumsResponse = albums.stream()
            .map(albumMapper::toAlbumResponse)
            .toList();
    return new PageResponse<>(
            albumsResponse,
            albums.getNumber(),
            albums.getSize(),
            albums.getTotalElements(),
            albums.getTotalPages(),
            albums.isFirst(),
            albums.isLast()
    );
  }

  public void uploadAlbumCoverPicture(MultipartFile file, Authentication connectedUser, Integer albumId) {
    Album album = albumRepository.findById(albumId)
            .orElseThrow(() -> new EntityNotFoundException("No album found with ID:: " + albumId));

    User user = ((User) connectedUser.getPrincipal());

    var albumCover = fileStorageService.saveFile(file, user.getId());
    album.setAlbumCover(albumCover);
    albumRepository.save(album);
  }
}