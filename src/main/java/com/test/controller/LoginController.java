package com.test.controller;

import com.test.config.JwtUtil;
import com.test.entity.User3;
import com.test.mapper.UnInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录Controller
 */
@Slf4j
@RestController
@RequestMapping("/lg")
public class LoginController
{

    static Map<Integer, User3> userMap = new HashMap<>();

    static {

        User3 user1 = new User3(1,"张三","123456");
        userMap.put(1, user1);
        User3 user2 = new User3(2,"李四","123123");
        userMap.put(2, user2);
    }

    /**
     * 模拟用户 登录
     */

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @UnInterception
    public String login(@RequestParam String userName, @RequestParam String password)
    {
        System.out.println("userName: " + userName + ", password: " + password);
        for (User3 dbUser : userMap.values()) {
            if (dbUser.getUserName().equals(userName) && dbUser.getPassword().equals(password)) {
                log.info("登录成功！生成token！");
                String token = JwtUtil.createToken(dbUser);
                return token;
            }
        }
        return "";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}