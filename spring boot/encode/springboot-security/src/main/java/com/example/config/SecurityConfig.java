package com.example.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// AOP: 拦截器
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3").and()
                .withUser("yunxi").password(new BCryptPasswordEncoder().encode("714")).roles("vip1");
    }

    // 请求规则（授权）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限到登录页面
        http.formLogin().loginPage("/toLogin").loginProcessingUrl("/login");

        // 防止网站工具 ： get post
        http.cors().disable(); // 关闭csrf功能

        // 注销功能
        http.logout().logoutSuccessUrl("/login");

        // 开启记住我功能  默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }
}
