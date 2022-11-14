package org.example.controller;


import org.example.ApplicationContextFactory;
import org.example.factory.Factory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
//  @RequestMapping("/")
  public String getStart(){
    return "hello";
  }
  @RequestMapping("/index")
  public String getIndex(){
    return "index";
  }
    @RequestMapping("/hello")
  public String getStart01(){
      ApplicationContext applicationContext= ApplicationContextFactory.getApplicationContext();
       Factory factory = (Factory) applicationContext.getBean("Factory");
      factory.factoryMode();
    return "hello";
  }

}
