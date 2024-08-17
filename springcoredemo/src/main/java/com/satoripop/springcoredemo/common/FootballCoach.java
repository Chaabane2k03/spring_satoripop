package com.satoripop.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootballCoach implements Coach {

    FootballCoach(){
        System.out.println("Football Coach : I am Jose Mourinho");
    }
    @Override
    public String getDailyWorkout() {
        return "Go play 4-3-3 formation as a wing back";
    }

    //Understanding Bean LifeCycle :

    @PostConstruct
    public void subbedIn(){
        System.out.println("Subbed In : Chaabane , Ready to Play");

    }

    @PreDestroy
    public void subbedOut(){
        System.out.println("Subbed Out : Chaabane , 2 Goals and 1 assist");
    }
}
