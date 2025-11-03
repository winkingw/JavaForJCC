package com.utgaming.jcc.System.RoundSystem.controller;

import com.utgaming.jcc.Service.RoundService;
import com.utgaming.jcc.staticData.Common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/battle")
@CrossOrigin(origins = "*")
@Slf4j
@Api("战斗与回合控制")
public class RoundController {
    @Autowired
    private RoundService roundService;


}
