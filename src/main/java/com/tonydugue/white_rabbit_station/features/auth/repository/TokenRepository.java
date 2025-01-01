package com.tonydugue.white_rabbit_station.features.auth.repository;

import com.tonydugue.white_rabbit_station.features.auth.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

  Optional<Token> findByToken(String token);
}