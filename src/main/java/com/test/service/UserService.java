package com.test.service;

import com.test.entity.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import com.test.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import com.test.entity.User;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ApplicationContext applicationContext;

    @Transactional
    public void isertUser(User user){
        userMapper.insert(user);
        throw new RuntimeException();
    }

    public User getuser(){
        return new User(6,"测试","123456");
    }

    public User getuser2(){
        User user = new User(6,"ceshi","123456");
        MyEvent event = new MyEvent(this,user);
//        System.out.println("77777");
        applicationContext.publishEvent(event);
        return user;
    }

    public Set<String> getRoles(String username){
        Integer id = userMapper.getRoles(username);
        Set<String> roles = new HashSet<String>();
        String id_str = Integer.toString(id);
        roles.add(id_str);
        return roles;
    }

    public Set<String> getPermissions(String username){
        Integer id = userMapper.getRoles(username);
        Set<String> permis = new HashSet<>();
        String perm_str = userMapper.getPermissions(id);
        permis.add(perm_str);
        return permis;
    }

    public User getByUsername2(String username){
        User user = userMapper.getuserByUsername(username);
        return user;
    }

}
