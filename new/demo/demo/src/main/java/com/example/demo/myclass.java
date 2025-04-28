package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myclass {

    @GetMapping("/home")
    public String sayHello(){
        System.out.println("HEllo system");
        return "HEllo";
    }
}
