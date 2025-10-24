package com.utgaming.jcc.CardSystem.entity;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 用户卡牌实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCard {
    private Long userId;

    private Card card;

    private Equipments equipment;


}
