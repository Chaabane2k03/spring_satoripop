package com.satoripop.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class FitnessCoach implements Coach {


    FitnessCoach(){
        System.out.println("FitnessCoach : Usain Bolt");
    }
    @Override
    public String getDailyWorkout() {
        return "Do one hour walking in the street and then drink water !!!";
    }
}
