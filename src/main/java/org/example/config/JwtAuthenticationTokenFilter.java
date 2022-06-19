package org.example.config;

import org.example.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * jwt校验
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            // 通过浏览器器的cookies 存储
             logger.info(request.getRequestURI());
             Boolean hasToken  = false;
             String authToken = "";
             Cookie[] cookies = request.getCookies();
             for (Cookie cookie:cookies){
                 if (cookie.getName().equals("token") && !StringUtils.isEmpty(cookie.getValue())){
                     hasToken = true;
                     authToken = cookie.getValue();
                 }
             }
//            String authHeader = request.getHeader("Authorization");
            if (hasToken){
                 Map parseToken = JwtUtils.parseToken(authToken);
                 if (parseToken.isEmpty() || parseToken == null || !(Boolean) parseToken.get("isValid")){
                     // 过期了
                     SecurityContextHolder.getContext().setAuthentication(null);
                 }else {
                     String username = (String) parseToken.get("subject");
                     if (!StringUtils.isEmpty(username)) {
                         UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                         if (userDetails != null) {
                             UsernamePasswordAuthenticationToken authentication =
                                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                             authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                             SecurityContextHolder.getContext().setAuthentication(authentication);
                         }
                     }
                 }
            }else {
                // 没有token 调到登录
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        filterChain.doFilter(request, response);
    }
}
