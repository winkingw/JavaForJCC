package com.utgaming.jcc.System.UserSystem.controller;

import com.utgaming.jcc.Service.UserService;
import com.utgaming.jcc.System.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
@Slf4j
@Api("用户系统")
public class UserController {
    private UserService userService;

    @GetMapping("/{userId}")
    @ApiOperation("查询用户id")
    public Result<Map<String, Object>> getUserBase(@PathVariable Long userId) {
        if(!userService.checkUser(userId)){
            return Result.error("用户信息有误");
        }else{
            //TODO
        }
    }
}
