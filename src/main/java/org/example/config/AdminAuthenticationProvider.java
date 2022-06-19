package org.example.config;

import org.example.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;


/**
 * 认证处理器
 */
@Component
public class AdminAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 请求获取用户名和密码
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        User user = (User) userDetailsService.loadUserByUsername(username);
        // 简单验证密码是否相等
        if (password.equals(user.getPassword())){
            return  new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
        }else { // 可根据不同情况抛出不同异常 失败处理器捕获
            throw new BadCredentialsException("密码错误！");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
