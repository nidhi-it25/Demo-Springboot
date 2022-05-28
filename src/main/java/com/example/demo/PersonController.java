package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {


    @GetMapping("/hello")
    public Person sayHello(){
        return new Person(1,"Nidhi","Patel","nidhi@gmail.com");
    }
}
