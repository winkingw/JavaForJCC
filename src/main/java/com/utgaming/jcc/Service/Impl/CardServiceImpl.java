package com.utgaming.jcc.Service.Impl;


import com.utgaming.jcc.Service.CardService;
import com.utgaming.jcc.System.common.Result;
import org.springframework.stereotype.Service;

/**
 * 卡牌服务类
 */
@Service
public class CardServiceImpl implements CardService {

    Result<boolean> checkPlayerCoins(Long playerId) {
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
