package org.example.configdemo;

import jdk.internal.instrumentation.InstrumentationMethod;
import org.example.annotation.EnableRedisAutoConfiguration;
import org.example.condition.ConditionOnclass;
import org.example.condition.myContionditon;
import org.example.entity.Org;
import org.example.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/5/22 15:24
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@EnableRedisAutoConfiguration
@Import(value = {LoggerTest.class,MyimportSelector.class,MyImportBeandefinition.class})
public class JavaConfig {
    public static void main(String[] args){

        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        for (String name : ac.getBeanDefinitionNames()){
            System.out.println(name);
        }
        System.out.println(ac.getBean(Org.class));
    }
//    @Bean
//    @Conditional(myContionditon.class) // 控制是否加载 根据方法返回值
//    @Conditional(ConditionOnclass.class)
//    public Org  getOrg(){
//        return new Org();
//    }
}
