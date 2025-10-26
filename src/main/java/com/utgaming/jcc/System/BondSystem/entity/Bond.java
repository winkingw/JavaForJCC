package com.utgaming.jcc.System.BondSystem.entity;

import com.utgaming.jcc.System.CardSystem.entity.Buff;
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
