package org.example.controller;

import com.alibaba.fastjson.JSONObject;
//import org.example.dao.mybatisplus.OrgDao;
import org.example.entity.Org;
import org.example.entity.User;
import org.example.service.UserService;
import org.hibernate.annotations.Parameter;
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
  // 未写service
//  private OrgDao orgDao;
  private String id;

  @PostMapping("/getUser")
  @ResponseBody
  public List<User> getUser(@RequestBody String inJsonString, HttpServletRequest request)  throws Exception{
    //JSONObject jsonObject = JSONObject.parseObject(inJsonString);
    Map<String, String> jsonMap1 = JSONObject.parseObject(inJsonString, Map.class);
    List<User> userList = new ArrayList<>();
    userList = userService.getUserList(jsonMap1);
    return userList;
  }

//  @RequestMapping(value = "/getOrg",method = RequestMethod.GET)
//  @ResponseBody
//  public List<Org> getOrg (@RequestParam("id") String id) {
//    List <Org> orgList = (List<Org>) orgDao.selectById(id);
//    return orgList;
//  }

}
