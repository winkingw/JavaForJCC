package com.utgaming.jcc.System.UserSystem.controller;

import com.utgaming.jcc.System.CardSystem.entity.Card;
import com.utgaming.jcc.System.EquipmentSystem.entity.Equipments;
import com.utgaming.jcc.System.UserSystem.entity.UserCard;
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

    @GetMapping("/{userId}")
    @ApiOperation("查询用户基础信息（示例数据）")
    public Result<Map<String, Object>> getUserBase(@PathVariable Long userId) {
        Map<String, Object> info = new HashMap<>();
        info.put("userId", userId);
        info.put("nickname", "召唤师" + userId);
        info.put("level", 1);
        return Result.success(info);
    }

    @GetMapping("/{userId}/cards")
    @ApiOperation("查询用户拥有的角色卡（示例数据）")
    public Result<List<UserCard>> getUserCards(@PathVariable Long userId) {
        List<UserCard> list = new ArrayList<>();
        list.add(mockUserCard(userId, 101L, "金克丝", "枪手", null));
        list.add(mockUserCard(userId, 102L, "蔚", "斗士", null));
        return Result.success(list);
    }

    @GetMapping("/{userId}/inventory")
    @ApiOperation("查询用户背包（示例统计）")
    public Result<Map<String, Object>> getInventory(@PathVariable Long userId) {
        Map<String, Object> inv = new HashMap<>();
        inv.put("coins", 10);
        inv.put("relics", 0);
        inv.put("equipmentCount", 0);
        return Result.success(inv);
    }

    private UserCard mockUserCard(Long userId, Long cardId, String name, String job, Equipments eq) {
        Card c = new Card();
        c.setId(cardId);
        c.setName(name);
        c.setDescription(job);
        UserCard uc = new UserCard();
        uc.setUserId(userId);
        uc.setCard(c);
        uc.setEquipment(eq);
        return uc;
    }
}
