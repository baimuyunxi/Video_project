package com.example.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录过滤器实现
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFiter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest requestOver = (HttpServletRequest) request;
        HttpServletResponse responseOver = (HttpServletResponse) response;
        log.info("拦截到请求:{}", requestOver.getRequestURI());
        chain.doFilter(requestOver, responseOver);
    }
}
