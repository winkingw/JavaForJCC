package com.utgaming.jcc.Service.Impl;

import com.utgaming.jcc.Service.HexService;
import com.utgaming.jcc.staticData.Constant.MessageConstant;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HexServiceImpl implements HexService {
    @Autowired
    private RedisTemplate redisTemplate;

    ThreadLocalRandom random = ThreadLocalRandom.current();

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
        return stateId;
    }

    @PostConstruct
    private void initData(){
        initHexData();
        initStateData();
        System.out.println("城邦和海克斯预加载进入redis");
    }

    private void initHexData(){
        //TODO
    }
    private void initStateData(){
        //TODO
    }
}
