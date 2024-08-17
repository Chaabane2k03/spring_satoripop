package com.satoripop.springcoredemo.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;




@Component
@Lazy
public class TennisCoach implements Coach {

   TennisCoach(){
       System.out.println("TennisCoach");
   }

    @Override
    public String getDailyWorkout() {
        return "Pracice Serves";
    }
}
