package com.example.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstAPI {

    @GetMapping("/")
    public String firstGetAPI() {
        return "This is my first api";
    }

}
