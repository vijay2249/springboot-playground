package com.fia.f2.controller;


import com.fia.f2.model.WelcomeBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RequestMapping("f2")
@RestController
public class WelcomeF2Academy {

    @RequestMapping("/welcome")
    public String welcome(){
        return "Welcome to F2 Academy";
    }

    @RequestMapping("/welcome-bean")
    public WelcomeBean welcomeBean(){
        return new WelcomeBean("Welcome to F2 Academy");
    }

    @RequestMapping("/welcome/{name}")
    public WelcomeBean welcomeName(@PathVariable String name){
        return new WelcomeBean("Welcome, " + name);
    }

    @RequestMapping("/welcome/{name}/message/{message}")
    public WelcomeBean welcomeNameMessage(@PathVariable String name, @PathVariable String message){
        return new WelcomeBean("Welcome, " + name + "\nMessage: " + message);
    }
}


/*
code snippet


 */