package com.utgaming.jcc.Service.Impl;

import com.utgaming.jcc.Service.RoundService;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class RoundServiceImpl implements RoundService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void roundStart() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(MessageConstant.ROUND,MessageConstant.STATE_ROUND);
        //initAll
        return;
    }

    public void roundNext() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String nowRound = valueOperations.get(MessageConstant.ROUND).toString();
        HashOperations hashOperations = redisTemplate.opsForHash();
        valueOperations.set(MessageConstant.ROUND,hashOperations.get(MessageConstant.ROUNDSEARCH,nowRound));
        return;
    }

    public void roundEnd() {
        //deleteAllRedis
        return;
    }

    public String roundCheck() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(MessageConstant.ROUND).toString();
    }
}
