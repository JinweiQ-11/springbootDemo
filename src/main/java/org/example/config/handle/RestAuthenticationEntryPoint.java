package org.example.config.handle;


import com.alibaba.fastjson.JSON;
import org.example.config.Response;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token无效时返回
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        Response responseBody = new Response();
//        responseBody.setStatus("100");
//        responseBody.setMsg("票据过期!");
//        response.getWriter().write(JSON.toJSONString(responseBody));
        Response res = new Response();
        res.setMsg("票据过期,请重新登录");
        request.setAttribute("msg","票据过期,请重新登录"); // 方式一 通过request回写数据
//        response.setHeader("msg","票据不合法!");
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
