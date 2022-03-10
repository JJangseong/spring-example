package com.example.configserverexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerExampleApplication.class, args);
    }

}
