package com.tonydugue.white_rabbit_station.features.auth.repository;

import com.tonydugue.white_rabbit_station.features.auth.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findByName(String role);
}