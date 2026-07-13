package com.MovieBookingApplication.MJCinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.MovieBookingApplication.MJCinema")
public class MjCinemaApplication {


	public static void main(String[] args) {
		SpringApplication.run(MjCinemaApplication.class, args);
	}

}
