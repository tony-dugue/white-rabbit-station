package com.tonydugue.white_rabbit_station.features.user.repository;

import com.tonydugue.white_rabbit_station.features.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);
}