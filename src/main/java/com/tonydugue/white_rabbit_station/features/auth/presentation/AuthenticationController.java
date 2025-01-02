package com.tonydugue.white_rabbit_station.features.auth.presentation;

import com.tonydugue.white_rabbit_station.features.auth.application.AuthenticationService;
import com.tonydugue.white_rabbit_station.features.auth.dto.AuthenticationRequest;
import com.tonydugue.white_rabbit_station.features.auth.dto.AuthenticationResponse;
import com.tonydugue.white_rabbit_station.features.auth.dto.RegistrationRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request) throws MessagingException {
    authenticationService.register(request);
    return ResponseEntity.accepted().build();
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest request) {
    return ResponseEntity.ok(authenticationService.authenticate(request));
  }
}