package com.test.controller;
import com.test.mapper.UnInterception;
import com.test.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @GetMapping("/test")
    @UnInterception
    public String test() {
        System.out.println("Controller method call - " + Thread.currentThread().getName());
        asyncService.performAsyncTask();
        asyncService.performAnotherAsyncTask();
        return "success";
    }
}
