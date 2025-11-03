package com.utgaming.jcc.Service.Impl;


import com.utgaming.jcc.Service.CardService;
import com.utgaming.jcc.staticData.Common.Result;
import org.springframework.stereotype.Service;

/**
 * 卡牌服务类
 */
@Service
public class CardServiceImpl implements CardService {

    public Result<Boolean> checkPlayerCoins(Long playerId) {
    }

    public boolean checkEmptySlot(Long playerId) {
    }

    public Object drawCard(Long playerId) {
    }

    public Object refreshCardPool(Long playerId) {
    }

    public Object sellCard(Long playerId, Long cardId) {
    }
}
