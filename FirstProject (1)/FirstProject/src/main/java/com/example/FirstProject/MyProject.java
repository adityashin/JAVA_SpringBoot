package com.example.FirstProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyProject {

    //field injection
    @Autowired
    private Dog dog;
//    private Dog dog = new Dog();
    @GetMapping("abc")
    public String mypage(){
        return "Page";
    }

    @GetMapping("dog")
    public String ok(){
        return dog.run();
    }

}
