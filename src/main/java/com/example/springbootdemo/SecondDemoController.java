package com.example.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondDemoController {

    private Coach myCoach;

    @Autowired
    public void setCoach(Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/running")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
