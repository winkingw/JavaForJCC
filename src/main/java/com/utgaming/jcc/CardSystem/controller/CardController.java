package com.utgaming.jcc.CardSystem.controller;

import com.utgaming.jcc.CardSystem.dto.CardDTO;
import com.utgaming.jcc.CardSystem.dto.CardDrawRequest;
import com.utgaming.jcc.CardSystem.dto.CardDrawResponse;
import com.utgaming.jcc.CardSystem.dto.UserCardDTO;
import com.utgaming.jcc.CardSystem.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * 卡牌控制器
 */
@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*")
public class CardController {
    
    @Autowired
    private CardService cardService;
    
    /**
     * 获取所有卡牌
     */
    @GetMapping("/list")
    public ResponseEntity<List<CardDTO>> getAllCards() {
        try {
            List<CardDTO> cards = cardService.getAllCards();
            return ResponseEntity.ok(cards);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 根据ID获取卡牌
     */
    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getCardById(@PathVariable Long id) {
        try {
            CardDTO card = cardService.getCardById(id);
            if (card != null) {
                return ResponseEntity.ok(card);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 根据类型获取卡牌
     */
    @GetMapping("/type/{type}")
    public ResponseEntity<List<CardDTO>> getCardsByType(@PathVariable String type) {
        try {
            List<CardDTO> cards = cardService.getCardsByType(type);
            return ResponseEntity.ok(cards);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 根据稀有度获取卡牌
     */
    @GetMapping("/rarity/{rarity}")
    public ResponseEntity<List<CardDTO>> getCardsByRarity(@PathVariable String rarity) {
        try {
            List<CardDTO> cards = cardService.getCardsByRarity(rarity);
            return ResponseEntity.ok(cards);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 获取用户卡牌
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserCardDTO>> getUserCards(@PathVariable Long userId) {
        try {
            List<UserCardDTO> userCards = cardService.getUserCards(userId);
            return ResponseEntity.ok(userCards);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 抽卡接口
     */
    @PostMapping("/draw")
    public ResponseEntity<CardDrawResponse> drawCard(@RequestBody CardDrawRequest request) {
        try {
            CardDrawResponse response = cardService.drawCard(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * 付费抽卡
     */
    @PostMapping("/draw/premium")
    public ResponseEntity<CardDrawResponse> premiumDraw(@RequestParam Long userId, @RequestParam Integer count) {
        try {
            CardDrawRequest request = new CardDrawRequest();
            request.setUserId(userId);
            request.setDrawType("PREMIUM");
            request.setDrawCount(count);
            
            CardDrawResponse response = cardService.drawCard(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
