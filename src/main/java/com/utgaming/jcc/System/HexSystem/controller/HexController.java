package com.utgaming.jcc.System.HexSystem.controller;

import com.utgaming.jcc.System.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/hex")
@CrossOrigin(origins = "*")
@Slf4j
@Api("海克斯城邦选择")
public class HexController {
    @GetMapping("/list")
    @ApiOperation("查询可选城邦（示例数据）")
    public Result<List<String>> list() {
        return Result.success(Arrays.asList("皮尔特沃夫", "祖安"));
    }

    @PostMapping("/select")
    @ApiOperation("选择城邦（示例数据）")
    public Result<String> select(@RequestParam Long userId, @RequestParam String city) {
        return Result.success(city);
    }
}
