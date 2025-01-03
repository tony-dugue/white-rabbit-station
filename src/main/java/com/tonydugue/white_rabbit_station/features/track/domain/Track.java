package com.tonydugue.white_rabbit_station.features.track.domain;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.Duration;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Track extends BaseEntity {

  @Column(nullable = false)
  private String name;

  private Duration duration;

  private String composer;

  private String version;

  @ManyToMany(mappedBy = "tracks")
  private Set<Album> albums;
}