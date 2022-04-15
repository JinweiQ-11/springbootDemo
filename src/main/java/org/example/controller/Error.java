package org.example.controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/error")
public class Error implements ErrorController {
    @Override
    public String getErrorPath() {
        return null;
    }
    @RequestMapping
    public Map<String,Object> handleError(){
        Map<String, Object> map = new HashMap<>();
        map.put("code",404);
        map.put("msg","不存在");
        return map;
    }
    @RequestMapping("ok")
    public Map<String,Object> ok(){
        Map<String, Object> map = new HashMap<>();
        map.put("code",2000);
        map.put("msg","zhengchang");
        return map;
    }
}
