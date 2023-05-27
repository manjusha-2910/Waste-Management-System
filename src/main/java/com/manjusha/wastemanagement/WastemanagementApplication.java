package com.manjusha.wastemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WastemanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(WastemanagementApplication.class, args);
	}

}
