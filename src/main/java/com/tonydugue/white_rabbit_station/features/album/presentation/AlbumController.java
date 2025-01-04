package com.tonydugue.white_rabbit_station.features.album.presentation;

import com.tonydugue.white_rabbit_station.features.album.application.AlbumService;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumRequest;
import com.tonydugue.white_rabbit_station.features.album.dto.AlbumResponse;
import com.tonydugue.white_rabbit_station.shared.common.PageResponse;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

  @GetMapping("{album-id}")
  public ResponseEntity<AlbumResponse> findAlbumById(@PathVariable("album-id") Integer albumId) {
    return ResponseEntity.ok(albumService.findById(albumId));
  }

  @GetMapping
  public ResponseEntity<PageResponse<AlbumResponse>> findAllAlbums(
          @RequestParam(name = "page", defaultValue = "0", required = false) int page,
          @RequestParam(name = "size", defaultValue = "10", required = false) int size,
          Authentication connectedUser
  ) {
    return ResponseEntity.ok(albumService.findAllAlbums(page, size, connectedUser));
  }

  @PostMapping(value = "/cover/{album-id}", consumes = "multipart/form-data")
  public ResponseEntity<?> uploadAlbumCoverPicture(
          @PathVariable("album-id") Integer albumId,
          @Parameter()
          @RequestPart("file") MultipartFile file,
          Authentication connectedUser
  ) {
    albumService.uploadAlbumCoverPicture(file, connectedUser, albumId);
    return ResponseEntity.accepted().build();
  }
}