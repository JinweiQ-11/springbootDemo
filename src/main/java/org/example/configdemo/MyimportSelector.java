package org.example.configdemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/5/22 15:17
 * @description：
 * @modified By：
 * @version: $
 */
public class MyimportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 可根据逻辑 去加载对应的bean
        return new String[] {RedisConfig.class.getName(), DataConfig.class.getName()};
    }
}
