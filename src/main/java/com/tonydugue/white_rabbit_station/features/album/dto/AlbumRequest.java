package com.tonydugue.white_rabbit_station.features.album.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AlbumRequest(

        Integer id,
        @NotNull(message = "100")
        @NotEmpty(message = "100")
        String name,
        LocalDate releaseDate,
        String studio,
        String description,
        String albumCover,
        String type
  ) {}