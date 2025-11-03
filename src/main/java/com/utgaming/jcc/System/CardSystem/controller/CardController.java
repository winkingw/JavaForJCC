package com.utgaming.jcc.System.CardSystem.controller;

import com.utgaming.jcc.Service.Impl.CardServiceImpl;
import com.utgaming.jcc.Service.Impl.UserServiceImpl;
import com.utgaming.jcc.staticData.Common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 卡牌控制器
 */
@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*")
@Slf4j
@Api("牌库系统交互")
public class CardController {
    @Autowired
    private CardServiceImpl cardServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    /**
     * 抽卡功能
     * 1. 检测玩家金币是否足够
     * 2. 检测角色空位是否可用
     * 3. 扣除金币，随机获得角色卡牌
     * 
     * @param playerId 玩家ID
     * @return 抽到的卡牌信息
     */
    @PostMapping("/dCard")
    @ApiOperation("抽卡")
    public Object dCard(@RequestParam Long playerId) {
        try {
            // 1. 检测金币是否足够
            Result<Boolean> hasEnoughCoins = cardServiceImpl.checkPlayerCoins(playerId);
            if (hasEnoughCoins == null || hasEnoughCoins.getData() == null || !hasEnoughCoins.getData()) {
                return Result.error("金币不足，无法抽卡");
            }
            
            // 2. 检测角色空位
            boolean hasEmptySlot = cardServiceImpl.checkEmptySlot(playerId);
            if (!hasEmptySlot) {
                return "角色位已满，无法抽卡";
            }
            
            // 3. 执行抽卡逻辑：扣除金币，获得角色
            return cardServiceImpl.drawCard(playerId);
        } catch (Exception e) {
            log.error("抽卡失败，玩家ID: {}", playerId, e);
            return Result.error("抽卡失败，请稍后重试");
        }
    }
    
    /**
     * 刷新牌库功能
     *
     * 
     * @param playerId 玩家ID
     * @return 刷新结果
     */
    @PostMapping("/refresh")
    @ApiOperation("刷新牌库")
    public Object refreshCardPool(@RequestParam Long playerId) {
        return cardServiceImpl.refreshCardPool(playerId);
    }
    
    /**
     * 卖卡功能
     * 1. 增加玩家金币
     * 2. 从牌库中移除对应卡牌
     * 
     * @param playerId 玩家ID
     * @param cardId 卡牌ID
     * @return 卖卡结果
     */
    @PostMapping("/sellCard")
    @ApiOperation("卖卡")
    public Object sellCard(@RequestParam Long playerId, @RequestParam Long cardId) {
        try {
            // 1. 增加金币
            // 2. 更新牌库（移除卡牌）
            return cardServiceImpl.sellCard(playerId, cardId);
        } catch (Exception e) {
            log.error("卖卡失败，玩家ID: {}, 卡牌ID: {}", playerId, cardId, e);
            return "卖卡失败，请稍后重试";
        }
    }
}
