package com.utgaming.jcc.CardSystem.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 用户卡牌DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCardDTO {
    
    /**
     * 用户卡牌ID
     */
    private Long id;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 卡牌信息
     */
    private CardDTO card;
    
    /**
     * 卡牌数量
     */
    private Integer quantity;
    
    /**
     * 卡牌等级
     */
    private Integer level;
    
    /**
     * 是否已解锁
     */
    private Boolean isUnlocked;
    
    /**
     * 获得时间
     */
    private LocalDateTime obtainTime;
    
    /**
     * 最后使用时间
     */
    private LocalDateTime lastUsedTime;
}
