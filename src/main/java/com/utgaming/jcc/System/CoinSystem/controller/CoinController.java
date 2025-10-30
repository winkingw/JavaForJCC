package com.utgaming.jcc.System.CoinSystem.controller;

import com.utgaming.jcc.System.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coins")
@CrossOrigin(origins = "*")
@Slf4j
@Api("金币交互")
public class CoinController {
    @Autowired
    private RedisTemplate redisTemplate;

    ValueOperations valueOperations = redisTemplate.opsForValue();

    @GetMapping("/balance/{userId}")
    @ApiOperation("查询用户金币余额")
    public Result<Integer> getBalance(@PathVariable Long userId) {
        Integer coins = (Integer) valueOperations.get("userId:coins:" + userId);
        return Result.success(coins);
    }

    @PostMapping("/gain")
    @ApiOperation("增加金币")
    public Result gain(@RequestParam Long userId, @RequestParam Integer amount) {
        valueOperations.increment("userId:coins:" + userId, amount);
        return Result.success();
    }

    @PostMapping("/consume")
    @ApiOperation("消耗金币")
    public Result consume(@RequestParam Long userId, @RequestParam Integer amount) {
        valueOperations.increment("userId:coins:" + userId,-1 * amount);
        return Result.success();
    }
}
