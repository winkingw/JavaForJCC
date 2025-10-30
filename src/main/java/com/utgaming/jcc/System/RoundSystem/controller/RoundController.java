package com.utgaming.jcc.System.RoundSystem.controller;

import com.utgaming.jcc.System.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/battle")
@CrossOrigin(origins = "*")
@Slf4j
@Api("战斗与回合控制")
public class RoundController {

    @PostMapping("/start")
    @ApiOperation("开始一回合（示例数据）")
    public Result<String> start(@RequestParam Long userId) {
        return Result.success("round-started");
    }

    @PostMapping("/end")
    @ApiOperation("结束一回合（示例数据）")
    public Result<String> end(@RequestParam Long userId) {
        return Result.success("round-ended");
    }
}
