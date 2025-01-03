package com.tonydugue.white_rabbit_station.features.bandLocation.domain;

import com.tonydugue.white_rabbit_station.features.band.domain.Band;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BandLocation extends BaseEntity {

  private String city;

  @Column(nullable = false)
  private String country;

  @OneToMany(mappedBy = "bandLocation")
  private List<Band> bands;
}