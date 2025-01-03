package com.tonydugue.white_rabbit_station.features.bandArtistHistory.domain;

import com.tonydugue.white_rabbit_station.features.artist.domain.Artist;
import com.tonydugue.white_rabbit_station.features.band.domain.Band;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BandArtistHistory extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "band_id")
  private Band band;

  @ManyToOne
  @JoinColumn(name = "artist_id")
  private Artist artist;

  private LocalDate startDate;

  private LocalDate endDate;
}