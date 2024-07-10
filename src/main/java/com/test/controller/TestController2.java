package com.test.controller;
import com.test.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json")
public class TestController2 {

    @RequestMapping("/user")
    public User getUser() {
        return new User(1, "测试", "123456");
    }

    @RequestMapping("/list")
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
//        User user1 = new User(1, "测试", "123456");
//        User user2 = new User(2, "测试课", "123456");
//        userList.add(user1);
//        userList.add(user2);
        return userList;
    }

    @RequestMapping("/map")
    public Map<String, Object> getMap() {
        Map<String, Object> map = new HashMap<>(3);
//        User user = new User(1, "测试", "123456");
//        map.put("作者信息", user);
        map.put("博客地址", "https://blog.csdn.net/cuiqwei/article/details/118188540");
        map.put("CSDN地址", null);
        map.put("测试数量", 001);
        return map;
    }

    @PostMapping("/api")
    public Map<String, String> toUpperCase(@RequestParam("input") String str) {
        Map<String, String> map = new HashMap<>();
        map.put("input", str);
        String result = str.toUpperCase();
        map.put("result", result);
        return map;
    }
}
