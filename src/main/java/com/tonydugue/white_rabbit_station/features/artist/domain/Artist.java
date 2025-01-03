package com.tonydugue.white_rabbit_station.features.artist.domain;

import com.tonydugue.white_rabbit_station.features.bandArtistHistory.domain.BandArtistHistory;
import com.tonydugue.white_rabbit_station.features.instrument.domain.Instrument;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Artist extends BaseEntity {

  private String city;

  @Column(nullable = false)
  private String country;

  @OneToMany(mappedBy = "artist")
  private List<BandArtistHistory> bandArtistHistories;

  @ManyToMany
  @JoinTable(name = "instrument_artist", joinColumns = @JoinColumn(name = "instrument_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
  private Set<Instrument> instruments;
}