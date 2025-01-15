package com.example.datamigration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulingConfig {

    @Value("${scheduling.migration}")
    private String cronExpression;

    @Bean
    public String schedulingCron() {
        return cronExpression;
    }
}
