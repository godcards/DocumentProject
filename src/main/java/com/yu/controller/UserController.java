package com.yu.controller;

import com.yu.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//@RestController
@Controller
public class UserController {

    @Autowired
    UserService userService;
//前后端分离
//    @PostMapping("/")
//    public Map<String, Object> login(@RequestParam("userName") String userName, @RequestParam("password")String password, Model model, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Map<String, Object> map = new HashMap<>();
//        Subject utils = SecurityUtils.getSubject();
//        session.setAttribute("name", userName);
//        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
//        //执行登陆方法
//        try {
//            utils.login(token);
//            map.put("code", "200");
//        } catch (UnknownAccountException uae) {
//            map.put("code", "401");
//        } catch (IncorrectCredentialsException ice) {
//            map.put("code", "402");
//        }
//        return map;
//    }
    @PostMapping("/login")
    public String login(@RequestParam("userName") String userName, @RequestParam("password")String password, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Subject utils = SecurityUtils.getSubject();
        session.setAttribute("name", userName);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        //执行登陆方法
        try {
            utils.login(token);
            return "redirect:/FileDown";
        } catch (UnknownAccountException | IncorrectCredentialsException uae) {
            return "/login";
        }
    }

}
