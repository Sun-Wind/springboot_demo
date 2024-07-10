package com.test.controller;

import com.test.mapper.UnInterception;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/interceptor")
public class InterceptorController {
    @RequestMapping("/test")
    @UnInterception
    public String test() {
        return "test";
    }
}
