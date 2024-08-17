package com.satoripop.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach{


    BasketBallCoach(){
        System.out.println("BasketBallCoach : Micheal Jordan");
    }
    @Override
    public String getDailyWorkout() {
        return "Practice 3 points shoots";
    }
}
