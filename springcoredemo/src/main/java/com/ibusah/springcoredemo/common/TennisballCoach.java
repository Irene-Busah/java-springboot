package com.ibusah.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Perform 30 push-ups daily";
    }

}
