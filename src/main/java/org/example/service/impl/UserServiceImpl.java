package org.example.service.impl;

import org.example.dao.IUserDao;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl  implements UserService {
  @Autowired
  private IUserDao iUserDao;

  @Override
  public List<User> getUserList(Map user) {
    return iUserDao.getUserList(user);
  }
  @Override
    public User getUserByLoginName(Map user) {
    List<User> userList = iUserDao.getUserListByLoginName(user);
    User userResult = new User();
    if (!userList.isEmpty()) {
      userResult =  userList.get(0);
    }
    return userResult;
  }

  @Override
  public User getUserbyName(String name) {
    return iUserDao.getUserbyName(name);
  }

}
