package com.tonydugue.white_rabbit_station;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class WhiteRabbitStationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiteRabbitStationApiApplication.class, args);
	}

}