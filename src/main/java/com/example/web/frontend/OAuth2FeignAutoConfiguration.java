package com.example.web.frontend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

import feign.RequestInterceptor;

@Configuration
public class OAuth2FeignAutoConfiguration {
    
    @Bean
    RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext) {
        return new EmployeeOAuth2FeignRequestInterceptor(oAuth2ClientContext);
    }
}