package com.tonydugue.white_rabbit_station.features.album.application;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumRequest;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumResponse;
import com.tonydugue.white_rabbit_station.features.album.mapper.AlbumMapper;
import com.tonydugue.white_rabbit_station.features.album.repository.AlbumRepository;
import com.tonydugue.white_rabbit_station.features.user.domain.User;
import com.tonydugue.white_rabbit_station.shared.common.PageResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

  private final AlbumRepository albumRepository;
  private final AlbumMapper albumMapper;

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
    User user = ((User) connectedUser.getPrincipal());
    Pageable pageable = PageRequest.of(page, size, Sort.by("createdDate").descending());
    Page<Album> releases = albumRepository.findAll(pageable);
    List<AlbumResponse> releasesResponse = releases.stream()
            .map(albumMapper::toAlbumResponse)
            .toList();
    return new PageResponse<>(
            releasesResponse,
            releases.getNumber(),
            releases.getSize(),
            releases.getTotalElements(),
            releases.getTotalPages(),
            releases.isFirst(),
            releases.isLast()
    );
  }
}