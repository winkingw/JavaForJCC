package com.utgaming.jcc.Service.Impl;

import com.utgaming.jcc.Service.RoundService;
import com.utgaming.jcc.System.common.Result;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RoundServiceImpl implements RoundService {
    @Autowired
    private RedisTemplate redisTemplate;
    ListOperations listOperations = redisTemplate.opsForList();
    String hexType = "staticData:hexType";

    public Integer hexType() {
        List<Integer> hexRange = listOperations.range(hexType, 0, -1);
        String currentRound = roundCheck();
        switch (currentRound) {
            case MessageConstant.HEX_ROUND_1 -> {
                return hexRange.get(1);
            }
            case MessageConstant.HEX_ROUND_2 -> {
                return hexRange.get(2);
            }
            case MessageConstant.HEX_ROUND_3 -> {
                return hexRange.get(3);
            }
            default -> {
                return null;
            }
        }

    }

    public String roundCheck() {
        return null;
    }

    @PostConstruct
    public Result initHex(){
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for(int i = 0; i < 3; i++){
            listOperations.rightPush(hexType, random.nextInt(3));
        }
        return Result.success();
    }
}
