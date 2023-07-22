package com.penyo.penyoboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class PenyoBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(PenyoBootApplication.class, args);
    }

}
