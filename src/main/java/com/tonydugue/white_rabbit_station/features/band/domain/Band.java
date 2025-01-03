package com.tonydugue.white_rabbit_station.features.band.domain;

import com.tonydugue.white_rabbit_station.features.bandArtistHistory.domain.BandArtistHistory;
import com.tonydugue.white_rabbit_station.features.bandEvent.domain.BandEvent;
import com.tonydugue.white_rabbit_station.features.bandLocation.domain.BandLocation;
import com.tonydugue.white_rabbit_station.features.genre.domain.Genre;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Band extends BaseEntity {

  @Column(nullable = false)
  private String name;

  @Column(columnDefinition = "TEXT")
  private String Description;

  private LocalDate formationDate;

  @ManyToMany(mappedBy = "bands")
  private Set<Genre> genres;

  @ManyToOne
  @JoinColumn(name = "bandLocation_id")
  private BandLocation bandLocation;

  @OneToMany(mappedBy = "band")
  private List<BandEvent> bandEvents;

  @OneToMany(mappedBy = "band")
  private List<BandArtistHistory> bandArtistHistories;
}