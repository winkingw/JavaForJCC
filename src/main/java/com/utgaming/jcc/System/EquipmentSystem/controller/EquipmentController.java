package com.utgaming.jcc.System.EquipmentSystem.controller;

import com.utgaming.jcc.Service.EquipService;
import com.utgaming.jcc.System.EquipmentSystem.entity.Equipments;
import com.utgaming.jcc.staticData.Common.Result;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*")
@Slf4j
@Api("装备系统交互")
public class EquipmentController {
    @Autowired
    private EquipService equipService;

    @GetMapping("/equipments/{userId}")
    public Result<List<Equipments>> getEquipments(@PathVariable String userId) {
        return Result.success(equipService.getEquipments(userId));
    }
}
