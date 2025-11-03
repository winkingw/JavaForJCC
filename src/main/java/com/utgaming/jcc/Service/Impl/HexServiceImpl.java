package com.utgaming.jcc.Service.Impl;

import com.utgaming.jcc.Service.HexService;
import com.utgaming.jcc.Service.RoundService;
import com.utgaming.jcc.staticData.Common.Result;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HexServiceImpl implements HexService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RoundService roundService;

    ThreadLocalRandom random = ThreadLocalRandom.current();


    ListOperations listOperations = redisTemplate.opsForList();
    String hexType = "staticData:hexType";

    public Integer hexType() {
        List<Integer> hexRange = listOperations.range(hexType, 0, -1);
        String currentRound = roundService.roundCheck();
        switch (currentRound) {
            case MessageConstant.HEX_ROUND_1 -> {
                return hexRange.get(1);
            }
            case MessageConstant.HEX_ROUND_2 -> {
                return hexRange.get(2);
            }
            case MessageConstant.HEX_ROUND_3 -> {
                return hexRange.get(3);
            }
            default -> {
                return null;
            }
        }
    }

    public Integer HexChoose(Integer type) {
        String searchHex = "static:hex:all_ids:" + type;
        SetOperations setOperations = redisTemplate.opsForSet();
        Set<Integer> showedIds = setOperations.distinctRandomMembers(searchHex,6);
        //给客户端传showedIds，返回一个id TODO hex刷新
        Integer randomId = showedIds.stream().skip(random
                .nextInt(showedIds.size())).findFirst()
                .orElseThrow(()->new RuntimeException("海克斯为空"));
        return randomId;
    }

    public Integer StateChoose(String s) {
        if(s != MessageConstant.STATE_ROUND)
            return null;
        ListOperations stateListOperations = redisTemplate.opsForList();
        List<Integer> stateList = stateListOperations.range(MessageConstant.STATE,0,-1);
        Integer stateId = stateList.get(random.nextInt(stateList.size()));
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set(MessageConstant.GAMESTATE,stateId);
        return stateId;
    }

    @PostConstruct
    private void initData(){
        initHexData();
        initStateData();
        System.out.println("城邦和海克斯预加载进入redis");
    }

    @PostConstruct
    public Result initHex(){
        ThreadLocalRandom random = ThreadLocalRandom.current();

        for(int i = 0; i < 3; i++){
            listOperations.rightPush(hexType, random.nextInt(3));
        }
        return Result.success();
    }

    @PostConstruct
    private void initHexData(){
        //TODO
    }

    @PostConstruct
    private void initStateData(){
        //TODO
    }
}
