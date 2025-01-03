package com.tonydugue.white_rabbit_station.features.albumCollection.domain;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import com.tonydugue.white_rabbit_station.features.user.domain.User;
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

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AlbumCollection extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "album_id")
  private Album album;

  private LocalDate PurchaseDate;

  @Column(precision = 10, scale = 2)
  private BigDecimal Price;

  private String StoreName;

  @Column(columnDefinition = "TEXT")
  private String Description;
}