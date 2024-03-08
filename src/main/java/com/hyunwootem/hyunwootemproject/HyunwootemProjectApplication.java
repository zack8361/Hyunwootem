package com.hyunwootem.hyunwootemproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class HyunwootemProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyunwootemProjectApplication.class, args);
	}
}
