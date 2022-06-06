package org.example.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/5/22 20:40
 * @description：
 * @modified By：
 * @version: $
 */
public class ConditionOnclass implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String className = "org.example.Enabledemo.RedisAutoConfiguration";
        // context.getBeanFactory() 根据容器判断
        try {
            Class<?> aclass = Class.forName(className);
            if (aclass!=null){
                return  true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return  false;
        }

        return true;
        // 判断


    }
}
