package com.example.springbootdemo;

import com.example.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondDemoController {

    private Coach myCoach;

    @Autowired
    public void setCoach(@Qualifier("baseballCoach") Coach coach) {
        myCoach = coach;
    }

    @GetMapping("/running")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
