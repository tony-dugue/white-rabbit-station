package com.tonydugue.white_rabbit_station.features.label.domain;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
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
public class Label extends BaseEntity {

  @Column(nullable = false)
  private String name;

  private String location;

  @Column(columnDefinition = "TEXT")
  private String description;

  @OneToMany(mappedBy = "label")
  private List<Album> albums;
}