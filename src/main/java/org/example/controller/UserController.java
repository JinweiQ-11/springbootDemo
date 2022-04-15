package org.example.controller;

import com.alibaba.fastjson.JSONObject;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
  @Autowired
  private UserService userService;
  @PostMapping("/getUser")
  @ResponseBody
  public List<User> getUser(@RequestBody String inJsonString, HttpServletRequest request)  throws Exception{
    //JSONObject jsonObject = JSONObject.parseObject(inJsonString);
    Map<String, String> jsonMap1 = JSONObject.parseObject(inJsonString, Map.class);
    List<User> userList = new ArrayList<>();
    userList = userService.getUserList(jsonMap1);
    return userList;
  }
}
