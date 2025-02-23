package com.concerto.devportal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConcertoDevPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConcertoDevPortalApplication.class, args);
    }

    @Bean
    public CommandLineRunner getCommandLineRunner() {
        return args -> {
            System.out.println("Concerto dev portal started");
        };
    }

}
