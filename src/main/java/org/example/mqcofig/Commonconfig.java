package org.example.mqcofig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/10/10 22:26
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
public class Commonconfig {
    @Value("spring.rabbitmq.addresses")
    String addresses;
}
