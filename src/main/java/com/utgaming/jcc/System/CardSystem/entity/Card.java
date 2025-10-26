package com.utgaming.jcc.System.CardSystem.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

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
    
    /**
     * 卡牌类型
     */
    private String type;
    
    /**
     * 卡牌稀有度
     */
    private Integer rarity;
    
    /**
     * 卡牌等级
     */
    private Integer level;
    
    /**
     * 攻击力
     */
    private Integer attack;
    
    /**
     * 生命值
     */
    private Integer health;
    
    /**
     * 护甲
     */
    private Integer armor;
    
    /**
     * 魔法抗性
     */
    private Integer magicResist;
    
    /**
     * 暴击率
     */
    private BigDecimal critRate;
    
    /**
     * 暴击伤害
     */
    private BigDecimal critDamage;
    
    /**
     * 移动速度
     */
    private Integer moveSpeed;
    
    /**
     * 攻击速度
     */
    private BigDecimal attackSpeed;

    private Skill skill;
    
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
