package org.example.config.handle;

import org.example.config.Response;
import org.example.utils.JwtUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证成功后调用
 */
@Component("authenticationSuccessHandle")
public class AuthenticationSuccessHandle implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //校验成功  获取token
        Response responseBody = new Response();
        responseBody.setMsg("登录成功!");
        responseBody.setStatus("1");
        User user = (User) authentication.getPrincipal();
        String jwtToken = JwtUtils.getSingleJwtUtils().generateToken(user.getUsername(),3000);
//        responseBody.setToken(jwtToken);
//        response.getWriter().write(JSON.toJSONString(responseBody));
        Cookie cookie = new Cookie("token", jwtToken);
        response.addCookie(cookie);
        response.sendRedirect("index.html");

    }
}
