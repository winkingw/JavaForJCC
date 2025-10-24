package com.utgaming.jcc.CardSystem.service;


import com.utgaming.jcc.CardSystem.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 卡牌服务类
 */
@Service
public class CardService {
    
    @Autowired
    private CardRepository cardRepository;
    
    @Autowired
    private CardRepository CardRepository;

}
