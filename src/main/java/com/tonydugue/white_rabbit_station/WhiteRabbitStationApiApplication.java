package com.tonydugue.white_rabbit_station;

import com.tonydugue.white_rabbit_station.features.auth.domain.Role;
import com.tonydugue.white_rabbit_station.features.auth.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef =  "auditorAware")
@EnableAsync
public class WhiteRabbitStationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiteRabbitStationApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RoleRepository roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}
}