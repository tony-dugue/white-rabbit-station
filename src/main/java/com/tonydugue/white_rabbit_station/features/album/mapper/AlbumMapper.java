package com.tonydugue.white_rabbit_station.features.album.mapper;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumRequest;
import org.springframework.stereotype.Service;

@Service
public class AlbumMapper {
  public Album toAlbum(AlbumRequest request) {
    return Album.builder()
            .id(request.id())
            .name(request.name())
            .releaseDate(request.releaseDate())
            .studio(request.studio())
            .description(request.description())
            .type(request.type())
            .build();
  }
}