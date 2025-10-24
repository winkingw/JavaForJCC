package com.utgaming.jcc.CardSystem.repository;

import com.utgaming.jcc.CardSystem.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 卡牌数据访问层
 */
@Mapper
public interface CardRepository {
    
    /**
     * 根据ID查询卡牌
     */
    Card findById(@Param("id") Long id);
    
    /**
     * 查询所有卡牌
     */
    List<Card> findAll();
    
    /**
     * 根据类型查询卡牌
     */
    List<Card> findByType(@Param("type") String type);
    
    /**
     * 根据稀有度查询卡牌
     */
    List<Card> findByRarity(@Param("rarity") String rarity);
    
    /**
     * 根据等级查询卡牌
     */
    List<Card> findByLevel(@Param("level") Integer level);
    
    /**
     * 根据费用查询卡牌
     */
    List<Card> findByCost(@Param("cost") Integer cost);
    
    /**
     * 根据名称模糊查询卡牌
     */
    List<Card> findByNameLike(@Param("name") String name);
    
    /**
     * 查询可用卡牌
     */
    List<Card> findActiveCards();
    
    /**
     * 统计卡牌总数
     */
    Integer countAll();

    
    /**
     * 批量插入卡牌
     */
    Integer batchInsert(@Param("cards") List<Card> cards);
}
