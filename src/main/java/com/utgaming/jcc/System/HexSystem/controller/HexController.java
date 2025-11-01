package com.utgaming.jcc.System.HexSystem.controller;

import com.utgaming.jcc.Service.HexService;
import com.utgaming.jcc.Service.RoundService;
import com.utgaming.jcc.System.common.Result;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hexOrState")
@CrossOrigin(origins = "*")
@Slf4j
@Api("海克斯城邦选择")
public class HexController {
    @Autowired
    private RedisTemplate redisTemplate;
    private HexService hexService;
    private RoundService roundService;

    @GetMapping("/hex/{userId}")
    public Result<Integer> HexChoose(@PathVariable Long userId){
        Integer hexId = hexService.HexChoose(roundService.hexType());

        if(hexId == null)
            return Result.error(MessageConstant.WRONG_ROUND);

        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add(MessageConstant.USER_HEX + userId,hexId);

        Integer HexId = hexId;
        return Result.success(HexId);
    }

    @GetMapping("/state")
    public Result<Integer> StateChoose(){
        Integer stateId = hexService.StateChoose(roundService.roundCheck());
        if(stateId == null)
            return Result.error(MessageConstant.WRONG_ROUND);
        return Result.success(stateId);
    }
}
