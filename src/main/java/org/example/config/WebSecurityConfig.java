package org.example.config;

import org.example.config.handle.RestAuthenticationEntryPoint;
import org.example.config.handle.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity//指定为Spring Security配置类
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    private final AuthenticationEntryPoint authenticationEntryPoint;
//    private final AbstractAuthenticationProcessingFilter authenticationProcessingFilter;
//    public WebSecurityConfig(AuthenticationEntryPoint authenticationEntryPoint, AbstractAuthenticationProcessingFilter authenticationProcessingFilter) {
//        this.authenticationEntryPoint = authenticationEntryPoint;
//        this.authenticationProcessingFilter = authenticationProcessingFilter;
//    }
private final AdminAuthenticationProcessingFilter adminAuthenticationProcessingFilter;
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
        @Autowired
        RestfulAccessDeniedHandler accessDeniedHandler;
        @Autowired
        RestAuthenticationEntryPoint authenticationEntryPoint;

    public WebSecurityConfig(AdminAuthenticationProcessingFilter adminAuthenticationProcessingFilter,JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter) {
        this.adminAuthenticationProcessingFilter = adminAuthenticationProcessingFilter;
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //禁用跨站csrf攻击防御，后面的章节会专门讲解
                .formLogin()
                .loginPage("/login.jsp")//用户未登录时，访问任何资源都转跳到该路径，即登录页面
                .loginProcessingUrl("/login")//登录表单form中action的地址，也就是处理认证请求的路径
                .usernameParameter("username")///登录表单form中用户名输入框input的name名，不修改的话默认是username
                .passwordParameter("password")//form中密码输入框input的name名，不修改的话默认是password
                .defaultSuccessUrl("/index")//登录认证成功后默认转跳的路径
                .and()
                .authorizeRequests()
                .antMatchers("/login.html","/login").permitAll()//不需要通过登录验证就可以被访问的资源路径
                .anyRequest().authenticated();

        http.addFilterAt(adminAuthenticationProcessingFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(authenticationEntryPoint);
        //        //
        //http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class); // JWT Filter

        }
    @Override
    public void configure(WebSecurity web) {

        //将项目中静态资源路径开放出来
        web.ignoring().antMatchers("/dist/**", "/css/**", "/pages/**", "/img/**", "/plugins/**");
    }

}
