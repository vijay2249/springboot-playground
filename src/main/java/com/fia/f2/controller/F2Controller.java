package com.fia.f2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("f2")
public class F2Controller {

    @RequestMapping("/welcome")
    @ResponseBody
    public String welcome(){
        return "Welcome to F2 Academy";
    }
}
