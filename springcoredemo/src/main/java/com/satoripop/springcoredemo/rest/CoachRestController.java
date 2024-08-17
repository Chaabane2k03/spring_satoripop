package com.satoripop.springcoredemo.rest;


import com.satoripop.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachRestController {

    private Coach anotherCoach;
    private Coach myCoach;

    //Constructor Injection :

    /*@Autowired
    public CoachRestController( Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    //Setter Injection
    //Using Qualifiers
    @Autowired
    public void setCoach(
            @Qualifier("judoCoach") Coach anotherCoach,
            @Qualifier("judoCoach") Coach theCoach){
        System.out.println("In Constructor :" + getClass().getSimpleName());
        myCoach = theCoach;
        this.anotherCoach = anotherCoach;
    }


    @GetMapping("/myWorkout")
    public String myWorkout() {
        return this.myCoach.getDailyWorkout() ;
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans : myCoach == anotherCoach  ," + (myCoach == anotherCoach);
    }

}
