package com.tonydugue.white_rabbit_station.features.album.application;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumRequest;
import com.tonydugue.white_rabbit_station.features.album.mapper.AlbumMapper;
import com.tonydugue.white_rabbit_station.features.album.repository.AlbumRepository;
import com.tonydugue.white_rabbit_station.features.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

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
}