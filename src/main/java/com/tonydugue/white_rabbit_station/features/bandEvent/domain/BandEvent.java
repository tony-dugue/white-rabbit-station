package com.tonydugue.white_rabbit_station.features.bandEvent.domain;

import com.tonydugue.white_rabbit_station.features.band.domain.Band;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.Column;
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
public class BandEvent extends BaseEntity {

  @Column(nullable = false)
  private String name;

  private LocalDate eventDate;

  @Column(columnDefinition = "TEXT")
  private String description;

  @ManyToOne
  @JoinColumn(name = "band_id")
  private Band band;
}