package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //设置登录处理操作
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/").setViewName("/index");
        registry.addViewController("/login").setViewName("login");
    }
}
