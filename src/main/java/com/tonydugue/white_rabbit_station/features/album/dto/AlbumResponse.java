package com.tonydugue.white_rabbit_station.features.album.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumResponse {
  private Integer id;
  private String name;
  private LocalDate releaseDate;
  private String studio;
  private String description;
  private String owner;
  private byte[] albumCover;
  private String type;
}