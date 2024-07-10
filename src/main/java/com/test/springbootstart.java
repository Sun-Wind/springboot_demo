package com.test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.test.mapper")
//@ServletComponentScan(basePackages = "com.hs.demo.jwt")。
public class springbootstart {
    public static void main(String [] args){
        SpringApplication.run(springbootstart.class,args);
    }
}
