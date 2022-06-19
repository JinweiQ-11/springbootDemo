package org.example.service.impl;

import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired UserServiceImpl userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User user  = null;
        Map param = new HashMap<>();
        param.put("loginName",username);
        User userR = userService.getUserByLoginName(param);
        // 判断用户是否存在
        if (!StringUtils.isEmpty(userR.getUserName().trim())){
            Collection<GrantedAuthority> authorities = new ArrayList<>();
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("admin");
            authorities.add(authority);
            user = new org.springframework.security.core.userdetails.User(userR.getUserName(),userR.getPassword(),true,true,true,true,authorities);
        } else {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        // 返回UserDetails实现类
        return  user;

    }
}
