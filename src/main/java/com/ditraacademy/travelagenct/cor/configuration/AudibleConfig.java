package com.ditraacademy.travelagenct.cor.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "AuditorAware")
public class AudibleConfig {

    @Bean
    public AuditorAware<String> AuditorAware() {
        return () -> Optional.ofNullable("haithem");
    }
}
