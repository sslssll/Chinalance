package com.chinafree;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
public class redisTest {
    public static String LOGIN_TIMES_PREFIX = "LOGIN_TIMES_";
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("name2","a2");


        System.out.println(redisTemplate.hasKey(LOGIN_TIMES_PREFIX + "1831027552@qq.com1"));
//        BoundValueOperations redisWrongTimes = redisTemplate.boundValueOps(LOGIN_TIMES_PREFIX + "1831027552@qq.com");
////        String s = (String) redisWrongTimes.get();
//        System.out.println(redisWrongTimes.get());
    }
}
