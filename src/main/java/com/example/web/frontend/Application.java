package com.example.web.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@RefreshScope
@SpringBootApplication
@EnableFeignClients
@EnableOAuth2Client
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}