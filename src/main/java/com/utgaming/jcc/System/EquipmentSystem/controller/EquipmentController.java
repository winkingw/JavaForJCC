package com.utgaming.jcc.System.EquipmentSystem.controller;

import com.utgaming.jcc.System.EquipmentSystem.entity.Equipments;
import com.utgaming.jcc.System.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/equipments")
@CrossOrigin(origins = "*")
@Slf4j
@Api("装备系统交互")
public class EquipmentController {
    @GetMapping("/list")
    @ApiOperation("查询装备列表（示例数据）")
    public Result<List<Equipments>> list() {
        return Result.success(Collections.emptyList());
    }

    @GetMapping("/{id}")
    @ApiOperation("查看装备详情（示例数据）")
    public Result<Map<String, Object>> detail(@PathVariable Long id) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("name", "示例装备");
        return Result.success(data);
    }
}
