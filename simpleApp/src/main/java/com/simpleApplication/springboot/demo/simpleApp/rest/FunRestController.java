package com.simpleApplication.springboot.demo.simpleApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // calling the properties: @Value for accessing the values of properties in the
    // application properties file
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // specify the endpoint
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    // exposing new nedpoint
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "<h2> Run a hard 5K! </h2>";
    }

    @GetMapping("/fortune")
    public String getFortune() {
        return "<h1>You have a heavy financial portfolio</h1>";
    }

    // endpoint for team info
    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team name: " + teamName;
    }

}
