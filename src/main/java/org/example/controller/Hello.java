package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
  @RequestMapping("/")
  public String getStart(){
    return "hello";
  }
}
