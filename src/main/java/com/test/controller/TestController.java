package com.test.controller;
//import com.test.service.UserService;
//import com.test.mapper.UserMapper;
import com.test.mapper.UnInterception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.test.entity.User;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
//    @Autowired
//    private UserService userService;

    @RequestMapping("/log")
    @UnInterception
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        // 可以使用占位符打印出一些参数信息
        String str1 = "blog.itcodai.com";
        String str2 = "blog.csdn.net/eson_15";
        logger.info("======测试：{}", str1, str2);

        return "success";
    }

//    @Resource
//    private UserMapper usermapper;
//
//    @RequestMapping("/getUserByName/{name}")
//    public User getUserByName(@PathVariable String name) {
//        return usermapper.getUserByName(name);
//    }
//
//    @PostMapping("/adduser")
//
//    public String addUser(@RequestBody User user) throws Exception {
//        if(null != user){
//            userService.isertUser(user);
//            return "success";
//        }
//        else return "false";
//    }
//
//    @GetMapping("/user")
//    public User getUser(HttpServletRequest request) {
//        ServletContext application = request.getServletContext();
//        return (User) application.getAttribute("user");
//    }
//
//    @RequestMapping ("/publish")
//    public User getuser(){
//        System.out.println("666666");
//        return userService.getuser2();
//    }

}
