package org.example.annotation;
import org.example.Enabledemo.RedisAutoConfiguration;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(value = {RedisAutoConfiguration.class})
public @interface EnableRedisAutoConfiguration {
}
