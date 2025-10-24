package com.utgaming.jcc.CardSystem.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 技能实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private Long id;

    private String name;
    
    /**
     * 技能类型 (ACTIVE, PASSIVE, ULTIMATE)
     */
    private String type;
    
    /**
     * 技能等级
     */
    private Integer level;

    private String description;

    private String effect;

    private Integer damage;

    private Integer healing;

    private Integer cooldown;
    
    /**
     * 技能消耗
     */
    private Integer cost;

    private Integer range;

    private Integer duration;

    private String imageUrl;

    private String iconUrl;

    private Boolean isActive;

    private BigDecimal makeCoin;
}
