package com.ibusah.springcoredemo.rest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibusah.springcoredemo.common.Coach;

@RestController
public class DemoRestController {
    private final Coach myCoach;

    // ============== construstor injection ===============
    public DemoRestController(Coach theCoach) {
        myCoach = theCoach;
    }

    // ============== setter injection: used for optional dependencies ===========
    // @Autowired
    // public void setCoach(@Qualifier("baseballCoach") Coach theCoach) {
    /**
     * The @Qualifier identifies when interface implementation spring need to call
     * since we have
     * multiple implementations like TennisballCoach, Baseball Coach, etc. It can be
     * used in both
     * constructor injection and setter injection
     * 
     * 
     */
    // myCoach = theCoach;
    // }

    @GetMapping("/daily-workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
