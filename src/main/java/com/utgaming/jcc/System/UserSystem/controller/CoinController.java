package com.utgaming.jcc.System.UserSystem.controller;

import com.utgaming.jcc.Service.CoinService;
import com.utgaming.jcc.staticData.Common.Result;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
    private CoinService coinService;

    @GetMapping("/balance/{userId}")
    @ApiOperation("查询用户金币余额")
    public Result<Integer> getBalance(@PathVariable Long userId) {
        return Result.success(coinService.getBalance(userId));
    }

    @PostMapping("/gain")
    @ApiOperation("增加金币")
    public Result gain(@RequestParam Long userId, @RequestParam Integer amount) {
        coinService.gain(userId, amount);
        return Result.success();
    }

    @PostMapping("/consume")
    @ApiOperation("消耗金币")
    public Result consume(@RequestParam Long userId, @RequestParam Integer amount) {
        coinService.consume(userId, amount);
        return Result.success();
    }
}
