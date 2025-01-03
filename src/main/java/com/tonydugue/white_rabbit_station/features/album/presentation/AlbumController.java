package com.tonydugue.white_rabbit_station.features.album.presentation;

import com.tonydugue.white_rabbit_station.features.album.application.AlbumService;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("albums")
@RequiredArgsConstructor
@Tag(name = "album")
public class AlbumController {

  private final AlbumService albumService;

  @PostMapping
  public ResponseEntity<Integer> saveAlbum(@Valid @RequestBody AlbumRequest request, Authentication connectedUser) {
    return ResponseEntity.ok(albumService.save(request, connectedUser));
  }
}