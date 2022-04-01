package com.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/FileDown")
    public String file(){
       return "FileDown";
    }

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }
}
