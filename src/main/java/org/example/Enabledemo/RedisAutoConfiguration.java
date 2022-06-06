package org.example.Enabledemo;

import org.example.annotation.EnableRedisAutoConfiguration;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/5/22 16:56
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class RedisAutoConfiguration {
    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        // 建造者模式
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setTimeout(5000);
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }
}
