package com.utgaming.jcc.CardSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bond {
    private Long id;

    private String name;

    private String bondIcon;

    private Integer level;

    private Buff buff;
}
