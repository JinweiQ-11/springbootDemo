package org.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopLogController {
    @GetMapping("/aoptest")
        public String avolid(){
            return "hello Aop";
        }
    }
