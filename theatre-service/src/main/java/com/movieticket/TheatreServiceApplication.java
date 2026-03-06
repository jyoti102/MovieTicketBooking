package com.movieticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.movieticket")
@EntityScan("com.movieticket.common.entity")
@EnableJpaRepositories("com.movieticket.theatre.repository")
public class TheatreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TheatreServiceApplication.class, args);
    }
}