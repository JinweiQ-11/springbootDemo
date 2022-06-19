package org.example.config.handle;

import com.alibaba.fastjson.JSON;
import org.example.config.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthenticationFailedHandle implements AuthenticationFailureHandler {
    private final static Logger logger = LoggerFactory.getLogger(AuthenticationFailureHandler.class);
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        Response  result = new Response();
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            result.setMsg(e.getMessage());
        } else if (e instanceof LockedException) {
            result.setMsg("账户被锁定，请联系管理员!");
        } else if (e instanceof CredentialsExpiredException) {
            result.setMsg("证书过期，请联系管理员!");
        } else if (e instanceof AccountExpiredException) {
            result.setMsg("账户过期，请联系管理员!");
        } else if (e instanceof DisabledException) {
            result.setMsg("账户被禁用，请联系管理员!");
        } else {
            result.setMsg("登录失败!" + e.getMessage());
        }
        logger.error(JSON.toJSONString(result));
        request.setAttribute("msg",result.getMsg());
        request.getRequestDispatcher("/login.jsp").forward(request,response);

    }
    }
