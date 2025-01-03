package com.tonydugue.white_rabbit_station.features.instrument.domain;

import com.tonydugue.white_rabbit_station.features.artist.domain.Artist;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class Instrument extends BaseEntity {

  @Column(nullable = false)
  private String name;

  private String type;

  @ManyToMany(mappedBy = "instruments")
  private Set<Artist> artists;
}