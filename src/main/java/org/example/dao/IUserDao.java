package org.example.dao;
//import com.baomidou.mybatisplus.extension.service.IService;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.User;

import javax.imageio.spi.IIOServiceProvider;
import java.util.List;
import java.util.Map;

public interface IUserDao {
  public List<User> getUserList(Map<String, Object> map);
  public List<User> getUserListByLoginName(Map<String, Object> map);
  public User getUserbyName(String name);
}


