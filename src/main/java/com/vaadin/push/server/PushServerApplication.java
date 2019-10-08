package com.vaadin.push.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PushServerApplication {
    
    @Value("${device.token}")
    private String token;

    @Value("${message}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(PushServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(NotificationService notificationService)
            throws Exception {
        return args -> {
            notificationService.sendNotification(this.token, this.message);
            System.exit(0);
        };
    }

}
