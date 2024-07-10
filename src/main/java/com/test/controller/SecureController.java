package com.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.test.mapper.UnInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 需要登录后携带JWT才能访问
 */
@Slf4j
@RestController
public class SecureController
{

    /**
     * 查询 用户信息，登录后携带JWT才能访问
     */

    @RequestMapping("/secure/getUserInfo")
    @UnInterception
    public JSONObject login(HttpServletRequest request) {
//        final String token = request.getHeader("authorization");
//        System.out.println("token:" + token);
        Integer id = (Integer) request.getAttribute("id");
        System.out.println(id);
        String userName = request.getAttribute("userName").toString();
        String password = request.getAttribute("password").toString();
        HttpServletResponse response = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
        assert response != null;
        response.setCharacterEncoding("UTF-8");

        JSONObject test = new JSONObject();
        test.put("id",id);
        test.put("userName",userName);
        test.put("password",password);
        System.out.println("当前用户信息id=" + id + ", userName=" + userName + ", password=" + password);

        return test;
    }
}