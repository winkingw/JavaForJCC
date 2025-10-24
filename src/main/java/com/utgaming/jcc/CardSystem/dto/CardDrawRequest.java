package com.utgaming.jcc.CardSystem.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 抽卡请求DTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDrawRequest {
    
    /**
     * 抽卡类型 (FREE, PREMIUM, DAILY, EVENT)
     */
    private String drawType;
    
    /**
     * 抽卡次数
     */
    private Integer drawCount;
    
    /**
     * 卡池ID
     */
    private Long cardPoolId;
    
    /**
     * 是否使用保底
     */
    private Boolean useGuarantee;
    
    /**
     * 用户ID
     */
    private Long userId;
}
