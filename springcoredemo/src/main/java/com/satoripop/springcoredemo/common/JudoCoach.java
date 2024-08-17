package com.satoripop.springcoredemo.common;


import org.springframework.context.annotation.Configuration;


public class JudoCoach implements Coach {

    public JudoCoach() {
        System.out.println("JudoCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Uchimata ! ";
    }
}
