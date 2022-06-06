package org.example.Enabledemo;

import org.example.configdemo.JavaConfig;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/5/22 16:46
 * @description：
 * @modified By：
 * @version: $
 */
public class RedsiApp {
    public static void main(String[] args){
//        Config config = new Config();
//        // 建造者模式
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setTimeout(5000);
//        RedissonClient redissonClient = Redisson.create(config);
//        System.out.println(redissonClient.getKeys().count());
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        RedissonClient redissonClient = ac.getBean(RedissonClient.class);
        System.out.println(redissonClient);
    }
}
