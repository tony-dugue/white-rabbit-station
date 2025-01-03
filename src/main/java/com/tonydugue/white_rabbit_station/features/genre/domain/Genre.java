package com.tonydugue.white_rabbit_station.features.genre.domain;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.features.band.domain.Band;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Genre extends BaseEntity {

  @Column(nullable = false)
  private String name;

  @ManyToMany
  @JoinTable(name = "genre_band", joinColumns = @JoinColumn(name = "genre_id"), inverseJoinColumns = @JoinColumn(name = "band_id"))
  private Set<Band> bands;

  @ManyToMany
  @JoinTable(name = "genre_album", joinColumns = @JoinColumn(name = "genre_id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
  private Set<Album> albums;
}