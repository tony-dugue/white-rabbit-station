package com.tonydugue.white_rabbit_station.features.album.mapper;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumRequest;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumResponse;
import com.tonydugue.white_rabbit_station.infrastructure.file.FileUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

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

  public AlbumResponse toAlbumResponse(Album album) {
    return AlbumResponse.builder()
            .id(album.getId())
            .name(album.getName())
            .releaseDate(album.getReleaseDate())
            .studio(album.getStudio())
            .description(album.getDescription())
            .owner(album.getOwner().fullName())
            .type(album.getType())
            .albumCover(FileUtils.readFileFromLocation(album.getAlbumCover()))
            .build();
  }
}