package com.utgaming.jcc.Service;

import com.utgaming.jcc.staticData.Common.Result;

public interface CoinService {
    Integer getBalance(Long userId);

    void gain(Long userId,Integer amount);

    void consume(Long userId, Integer amount);
}
