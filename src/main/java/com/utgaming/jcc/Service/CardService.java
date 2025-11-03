package com.utgaming.jcc.Service;

import com.utgaming.jcc.staticData.Common.Result;

public interface CardService {
    Result<boolean> checkPlayerCoins(Long playerId);

    public boolean checkEmptySlot(Long playerId) ;

    public Object drawCard(Long playerId) ;

    public Object refreshCardPool(Long playerId) ;

    public Object sellCard(Long playerId, Long cardId) ;
}
