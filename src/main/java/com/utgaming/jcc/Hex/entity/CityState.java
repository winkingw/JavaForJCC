package com.utgaming.jcc.Hex.entity;

import com.utgaming.jcc.CardSystem.entity.Equipments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityState {
    private Long id;

    private String name;

    private Enum triggerTime;

    private Equipments equipment;
}
