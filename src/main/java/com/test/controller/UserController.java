package com.test.controller;

import com.test.entity.User;
import com.test.mapper.UnInterception;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")

public class UserController {
    @RequestMapping("/admin")
    @UnInterception
    public String admin(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/student")
    @UnInterception
    public String student(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("teacher")
    @UnInterception
    public String teacher(HttpServletRequest request) {
        return "success";
    }

    @RequestMapping("login")
    @UnInterception
    public String login(User user, HttpServletRequest request) {
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            request.getSession().setAttribute("user", user);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error","用户名或密码错误");
            return "login";
        }

    }
}
