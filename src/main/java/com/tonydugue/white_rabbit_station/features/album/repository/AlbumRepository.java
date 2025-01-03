package com.tonydugue.white_rabbit_station.features.album.repository;

import com.tonydugue.white_rabbit_station.features.album.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}