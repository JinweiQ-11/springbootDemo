package org.example;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/8/4 17:33
 * @description：
 * @modified By：
 * @version: $
 */
public class ApplicationContextFactory {
    private volatile static ApplicationContext applicationContext1 = null;
    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext1 = applicationContext;
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext1;
    }
}
