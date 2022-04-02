package com.yu.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

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

    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping({"/","/index"})
    public String main(HttpSession session, Model model){
        final Object name = session.getAttribute("name");
        model.addAttribute("userName",name);
        return  "index";
    }
}
