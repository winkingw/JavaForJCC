package com.utgaming.jcc.CardSystem.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * 抽卡响应DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDrawResponse {
    
    /**
     * 是否成功
     */
    private Boolean success;
    
    /**
     * 消息
     */
    private String message;
    
    /**
     * 抽到的卡牌列表
     */
    private List<CardDTO> cards;
    
    /**
     * 消耗的资源
     */
    private Integer cost;
    
    /**
     * 剩余资源
     */
    private Integer remainingResource;
    
    /**
     * 是否触发保底
     */
    private Boolean isGuarantee;
    
    /**
     * 抽卡记录ID
     */
    private Long drawRecordId;
}
