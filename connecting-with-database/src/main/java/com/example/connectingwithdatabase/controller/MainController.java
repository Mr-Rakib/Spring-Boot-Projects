package com.example.connectingwithdatabase.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "")
public class MainController {
    @GetMapping(value = "")
    public String sayHello(){
        return "hello";
    }

    @GetMapping(value = "/Hi")
    public String sayHi(String name){
        return "Hi";
    }

    @GetMapping(value = "/Hi/{name}")
    public String sayHiName(@PathVariable String name){
        return "Hi "+name;
    }
}
