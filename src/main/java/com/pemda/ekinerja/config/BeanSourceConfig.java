package com.pemda.ekinerja.config;

import com.pemda.ekinerja.service.EmailService;
import com.pemda.ekinerja.service.implementation.FastEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bagus on 29/08/17.
 */
@Configuration
public class BeanSourceConfig {

    @Bean
    public EmailService emailService() {
        return new FastEmailService();
    }
}
