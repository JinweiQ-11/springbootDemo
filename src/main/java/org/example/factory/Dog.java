package org.example.factory;

import org.springframework.stereotype.Component;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/8/4 17:29
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class Dog implements AnimalFactory {
    @Override
    public String food() {
        return "吃骨头";
    }
    @Override
    public String animal() {
        return "狗";
    }
}
