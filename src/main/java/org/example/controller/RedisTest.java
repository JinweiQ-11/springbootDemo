package org.example.controller;

import org.example.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/11/14 22:13
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test(){
        redisTemplate.opsForValue().set("num","123");
        System.out.println(redisTemplate.opsForValue().get("num"));
    }
}
