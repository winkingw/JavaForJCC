package com.utgaming.jcc.Service.Impl;

import com.utgaming.jcc.Service.EquipService;
import com.utgaming.jcc.System.EquipmentSystem.entity.Equipments;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipServiceImpl implements EquipService {
    @Autowired
    private RedisTemplate redisTemplate;

    public List<Equipments> getEquipments(String userId) {
        return null;
    }
}
