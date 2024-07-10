package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.entity.User;
import com.test.mapper.UnInterception;
import com.test.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("redis")
public class Course14ApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(Course14ApplicationTests.class);

    @Resource
    private RedisService redisService;

    @RequestMapping("/test")
    @UnInterception
    public void contextLoads() {
        //测试redis的string类型
        redisService.setString("weichat", "程序员私房菜");
        String weichatValue = redisService.getString("weichat");
        logger.info("我的微信公众号为：{}", weichatValue);
        System.out.println("我的微信公众号为：" + weichatValue);

        // 如果是个实体，我们可以使用json工具转成json字符串，
//        User user = new User(3, "CSDN", "123456");
//        redisService.setString("userInfo", JSON.toJSONString(user));
        String userInfoValue = redisService.getString("userInfo");
        logger.info("用户信息：{}", userInfoValue);
        System.out.println("用户信息：" + userInfoValue);
    }
    @RequestMapping("/hash")
    @UnInterception
    public void hash() {
//        User user = new User(3, "CSDN", "123456");
//        redisService.setHash("user", "name", JSON.toJSONString(user));
        logger.info("用户姓名：{}", redisService.getHash("user","name"));
    }
}