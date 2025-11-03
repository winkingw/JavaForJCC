package com.utgaming.jcc.Service.Impl;

import com.utgaming.jcc.Service.CoinService;
import com.utgaming.jcc.staticData.Common.Result;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class CoinServiceImpl implements CoinService {
    @Autowired
    private RedisTemplate redisTemplate;

    ValueOperations valueOperations = redisTemplate.opsForValue();

    public Integer getBalance(Long userId){
        Integer coins = (Integer) valueOperations.get(MessageConstant.USER_COIN + userId);
        return coins;
    }

    public void gain(Long userId,Integer amount){
        valueOperations.increment(MessageConstant.USER_COIN + userId, amount);
        return;
    }

    public void consume(Long userId,Integer amount){
        valueOperations.increment(MessageConstant.USER_COIN + userId,-1 * amount);
    }
}
