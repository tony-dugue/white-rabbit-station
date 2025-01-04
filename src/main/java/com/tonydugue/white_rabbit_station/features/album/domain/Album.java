package com.tonydugue.white_rabbit_station.features.album.domain;

import com.tonydugue.white_rabbit_station.features.genre.domain.Genre;
import com.tonydugue.white_rabbit_station.features.label.domain.Label;
import com.tonydugue.white_rabbit_station.features.track.domain.Track;
import com.tonydugue.white_rabbit_station.features.albumCollection.domain.AlbumCollection;
import com.tonydugue.white_rabbit_station.features.user.domain.User;
import com.tonydugue.white_rabbit_station.shared.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album extends BaseEntity {

  @Column(nullable = false)
  private String name;

  private LocalDate releaseDate;

  private String studio;

  @Column(columnDefinition = "TEXT")
  private String description;

  private String albumCover;

  private String type;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;

  @ManyToMany
  @JoinTable(name = "album_track", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "track_id"))
  private Set<Track> tracks;

  @OneToMany(mappedBy = "album")
  private List<AlbumCollection> albumCollections;

  @ManyToMany(mappedBy = "albums")
  private Set<Genre> genres;

  @ManyToOne
  @JoinColumn(name = "label_id")
  private Label label;
}