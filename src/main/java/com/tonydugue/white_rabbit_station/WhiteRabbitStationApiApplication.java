package com.tonydugue.white_rabbit_station;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WhiteRabbitStationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiteRabbitStationApiApplication.class, args);
	}

}