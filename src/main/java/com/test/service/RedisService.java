package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    public Set<String> getAllKeys() {
        return stringRedisTemplate.keys("*");
    }

    public void setHash(String key, String hashKey, String hashValue) {
        stringRedisTemplate.opsForHash().put(key, hashKey, hashValue);
    }
    public String getHash(String key,String hashKey) {
        return (String) stringRedisTemplate.opsForHash().get(key, hashKey);
    }
}
