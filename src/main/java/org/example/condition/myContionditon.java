package org.example.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/5/22 20:15
 * @description：
 * @modified By：
 * @version: $
 */
public class myContionditon implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}
