package com.test.controller;
import com.test.entity.User2;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.entity.JsonResult;

@RestController
@RequestMapping("/swagger")
@Api(value="Swagger2在线接口文档")
public class TestController3 {

    @GetMapping("/get/{id}")
    @ApiOperation(value="根据用户标识获得用户信息")
    public JsonResult<User2>  GetUserInfo(@PathVariable @ApiParam(value="用户唯一标识") Long id){
        User2 user = new User2(id,"测试","123456");
        return new JsonResult(user);
    }
}
