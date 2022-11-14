package org.example.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/8/4 17:30
 * @description：
 * @modified By：
 * @version: $
 */
@Component("Factory")
public class Factory{
    @Autowired
    private Map<String, AnimalFactory> map;
    public String factoryMode() {
        AnimalFactory animal = map.get("cat");
        return animal.animal() + animal.food();
    }
}
