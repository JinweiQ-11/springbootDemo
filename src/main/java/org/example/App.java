package org.example;

import org.example.aop.AopLog;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@MapperScan("org.example.dao")
@ServletComponentScan
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        // 配置文件的形式
        //ApplicationContext ac = new ClassPathXmlApplicationContext("context.xml");
        ConfigurableApplicationContext ca = SpringApplication.run(App.class, args);
        AopLog aopLog = ca.getBean(AopLog.class);
        // 基于注解形式
    }
}
