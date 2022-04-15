package org.example.dao;
import org.example.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {
  public List<User> getUserList(Map<String, Object> map);
  public List<User> getUserListByLoginName(Map<String, Object> map);
}
