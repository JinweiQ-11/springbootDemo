package org.example.service;

import org.example.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
  public List<User> getUserList(Map input);
  public User getUserByLoginName(Map user);
  public User getUserbyName(String name);


}
