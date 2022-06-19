package org.example.config;


import com.alibaba.fastjson.JSONObject;
import org.example.config.handle.AuthenticationSuccessHandle;
import org.example.utils.MultiReadHttpServletRequest;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 用户密码校验过滤器
 */
@Component
public class AdminAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
       public AdminAuthenticationProcessingFilter(CusAuthenticationManager authenticationManager, AuthenticationSuccessHandle authenticationSuccessHandle, AuthenticationFailureHandler authenticationFailureHandler) {
            super(new AntPathRequestMatcher("/login", "POST"));
            this.setAuthenticationManager(authenticationManager);
            this.setAuthenticationSuccessHandler(authenticationSuccessHandle);
            this.setAuthenticationFailureHandler(authenticationFailureHandler);
        }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (request.getContentType() == null) {
            throw new AuthenticationServiceException("请求头类型不支持: " + request.getContentType());
        }
        UsernamePasswordAuthenticationToken authRequest;
        try {
            MultiReadHttpServletRequest wrappedRequest = new MultiReadHttpServletRequest(request);
            // 将前端传递的数据转换成jsonBean数据格式 表单数据在请求头
            Map user = JSONObject.parseObject(wrappedRequest.getBodyJsonStrByForm(wrappedRequest), Map.class);
            authRequest = new UsernamePasswordAuthenticationToken(user.get("username"), user.get("password"), null);
            authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
        } catch (Exception e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
