package com.utgaming.jcc.System.UserSystem.entity;

import com.utgaming.jcc.System.CardSystem.entity.Card;
import com.utgaming.jcc.System.EquipmentSystem.entity.Equipments;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 用户卡牌实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long userId;

    private String userName;

    private Integer coins;

    private Card card;

    private Equipments equipment;
}
