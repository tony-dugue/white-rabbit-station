package com.tonydugue.white_rabbit_station.features.auth.domain;

import com.tonydugue.white_rabbit_station.features.user.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Token {

  @Id
  @GeneratedValue
  private Integer id;

  private String token;

  private LocalDateTime createdAt;
  private LocalDateTime expiresAt;
  private LocalDateTime validatedAt;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;
}