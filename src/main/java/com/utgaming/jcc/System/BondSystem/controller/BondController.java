package com.utgaming.jcc.System.BondSystem.controller;

import com.utgaming.jcc.System.BondSystem.entity.Bond;
import com.utgaming.jcc.System.CardSystem.entity.Buff;
import com.utgaming.jcc.System.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bonds")
@CrossOrigin(origins = "*")
@Slf4j
@Api("羁绊系统交互")
public class BondController {

    @GetMapping("/list")
    @ApiOperation("查询全部可用羁绊（静态示例数据）")
    public Result<List<Bond>> listAllBonds() {
        return Result.success(buildStaticBonds());
    }

    @GetMapping("/detail")
    @ApiOperation("查询指定羁绊详情，通过name精确匹配（静态示例数据）")
    public Result<Bond> getBondDetail(@RequestParam String name) {
        return Result.success(
                buildStaticBonds().stream()
                        .filter(b -> Objects.equals(b.getName(), name))
                        .findFirst()
                        .orElse(null)
        );
    }

    @PostMapping("/evaluate")
    @ApiOperation("根据上场英雄名称列表评估激活的羁绊（静态规则评估）")
    public Result<List<Bond>> evaluateActiveBonds(@RequestBody List<String> heroNames) {
        if (heroNames == null) heroNames = Collections.emptyList();
        Set<String> nameSet = heroNames.stream().filter(Objects::nonNull).collect(Collectors.toSet());

        List<Bond> active = new ArrayList<>();

        // 姐妹花（金克丝 + 蔚）
        if (nameSet.contains("金克丝") && nameSet.contains("蔚")) {
            Bond sisters = baseSistersBond();
            sisters.setLevel(2); // 2人即激活
            active.add(sisters);
        }

        // 双城（希尔科 + 范德尔）
        if (nameSet.contains("希尔科") && nameSet.contains("范德尔")) {
            Bond twinCity = baseTwinCityBond();
            twinCity.setLevel(2);
            active.add(twinCity);
        }

        return Result.success(active);
    }

    private List<Bond> buildStaticBonds() {
        List<Bond> bonds = new ArrayList<>();
        bonds.add(baseSistersBond());
        bonds.add(baseTwinCityBond());
        return bonds;
    }

    private Bond baseSistersBond() {
        Buff buff = new Buff();
        buff.setAttackBonus(20);
        buff.setCritRateBonus(new BigDecimal("0.15"));
        Bond bond = new Bond();
        bond.setId(1L);
        bond.setName("姐妹花");
        bond.setBondIcon("sisters.png");
        bond.setLevel(0);
        bond.setBuff(buff);
        return bond;
    }

    private Bond baseTwinCityBond() {
        Buff buff = new Buff();
        buff.setHealthBonus(200);
        buff.setArmorBonus(20);
        Bond bond = new Bond();
        bond.setId(2L);
        bond.setName("双城");
        bond.setBondIcon("twin-city.png");
        bond.setLevel(0);
        bond.setBuff(buff);
        return bond;
    }
}
