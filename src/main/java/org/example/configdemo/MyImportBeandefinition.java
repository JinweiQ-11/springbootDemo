package org.example.configdemo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/5/22 15:51
 * @description：
 * @modified By：
 * @version: $
 */
public class MyImportBeandefinition implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Cache.class);
        registry.registerBeanDefinition("cache",rootBeanDefinition);

    }
}
