package com.utgaming.jcc.CardSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Buff {
    /**
     * 攻击力加成
     */
    private Integer attackBonus;

    /**
     * 生命值加成
     */
    private Integer healthBonus;

    /**
     * 护甲加成
     */
    private Integer armorBonus;

    /**
     * 魔法抗性加成
     */
    private Integer magicResistBonus;

    /**
     * 暴击率加成
     */
    private BigDecimal critRateBonus;

    /**
     * 暴击伤害加成
     */
    private BigDecimal critDamageBonus;

    /**
     * 移动速度加成
     */
    private Integer moveSpeedBonus;

    /**
     * 攻击速度加成
     */
    private BigDecimal attackSpeedBonus;
}
