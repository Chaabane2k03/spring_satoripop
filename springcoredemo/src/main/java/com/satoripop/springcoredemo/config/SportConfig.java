package com.satoripop.springcoredemo.config;


import com.satoripop.springcoredemo.common.Coach;
import com.satoripop.springcoredemo.common.JudoCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach judoCoach() {
        return new JudoCoach();
    }
}
