package com.utgaming.jcc.System.CardSystem.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 卡牌实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    
    /**
     * 卡牌ID
     */
    private Long id;
    
    /**
     * 卡牌名称
     */
    private String name;

    private CardAttribute attribute;
    
    /**
     * 卡牌描述
     */
    private String description;
    
    /**
     * 卡牌图片URL
     */
    private String imageUrl;
    
    /**
     * 卡牌费用
     */
    private Integer cost;
}
