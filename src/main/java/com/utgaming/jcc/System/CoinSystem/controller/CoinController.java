package com.utgaming.jcc.System.CoinSystem.controller;

import com.utgaming.jcc.System.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coins")
@CrossOrigin(origins = "*")
@Slf4j
@Api("金币交互")
public class CoinController {
    @GetMapping("/balance/{userId}")
    @ApiOperation("查询用户金币余额（示例数据）")
    public Result<Integer> getBalance(@PathVariable Long userId) {
        return Result.success(10);
    }

    @PostMapping("/gain")
    @ApiOperation("增加金币（示例数据）")
    public Result<Integer> gain(@RequestParam Long userId, @RequestParam Integer amount) {
        return Result.success(amount);
    }

    @PostMapping("/consume")
    @ApiOperation("消耗金币（示例数据）")
    public Result<Integer> consume(@RequestParam Long userId, @RequestParam Integer amount) {
        return Result.success(amount);
    }
}
