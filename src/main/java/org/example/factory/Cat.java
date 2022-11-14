package org.example.factory;

import org.springframework.stereotype.Component;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/8/4 17:28
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class Cat implements AnimalFactory {
    @Override
    public String food() {
        return "吃鱼";
    }
    @Override
    public String animal() {
        return "猫";
    }
}
