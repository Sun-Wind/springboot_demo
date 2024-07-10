package com.test.controller;

import com.test.entity.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/exception")
public class ExceptionController {
    private  static  final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
    @PostMapping("/test")
    public JsonResult test(@RequestParam("name") String name,@RequestParam("pass") String pass){
        logger.info("name:{}",name);
        logger.info("pass:{}",pass);
        return new JsonResult();
    }
}
