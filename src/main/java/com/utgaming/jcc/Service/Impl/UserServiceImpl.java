package com.utgaming.jcc.Service.Impl;

import com.utgaming.jcc.Service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean checkUser(Long userId) {
        //TODO
        return true;
    }

    @PostConstruct
    private void init(Long userId){
        initCoins(userId);
    }
    private void initCoins(Long userId){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("userId:coins:" + userId,0);
    }
}
