package com.yu.controller;

import com.yu.pojo.User;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        String nick = userService.SelectNickName(userName);
        session.setAttribute("name",nick);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        //执行登陆方法
        try {
            utils.login(token);
            return "redirect:/";
        } catch (UnknownAccountException | IncorrectCredentialsException uae) {
            model.addAttribute("error","账号或密码错误");
            return "/login";
        }
    }
    //注册
    @PostMapping("/register")
    public String UpdateUser(Model model,String userName,String password,String passwordT,String nickName){
        if (!password.equals(passwordT)){
            model.addAttribute("pls","与上面密码不相等");
        }else {
            User user=new User();
            if(nickName.equals("")) {
                user.setNickName(userName);
            }else {
                user.setNickName(nickName);
            }
            if(!userName.equals("")&&password.equals("")){
                user.setUserName(userName);
                user.setPassword(password);
                int i = userService.InsertUser(user);
                return "redirect:login";
            }else {
                model.addAttribute("p","账号密码不能为空");
            }
        }
        return null;
    }
}
