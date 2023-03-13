package com.example.filter;

import com.alibaba.fastjson.JSON;
import com.example.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

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

    // 路径匹配器 支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest requestOver = (HttpServletRequest) request;
        HttpServletResponse responseOver = (HttpServletResponse) response;

        // 1. 获取本次请求的URI
        String requestURI = requestOver.getRequestURI();
        String[] urls = new String[]{   //  不需要请求的路径
                "/employee/login",
                "/employee/logout",
                "/static/backend/**",
                "/static/front/**"
        };
        log.info("拦截到请求:{}", requestURI);

        //  2. 判断本次请求是否需要处理
        boolean check = check(urls, requestURI);

        //  3. 不需要处理直接放行
        if (check) {
            log.info("本次请求{}不需要处理", requestURI);
            chain.doFilter(requestOver, responseOver);
            return;
        }

        //  4. 判断登录状态 如果登录 放行
        if (requestOver.getSession().getAttribute("employee") != null) {
            log.info("用户已登录，id为:{}", requestOver.getSession().getAttribute("employee"));
            chain.doFilter(requestOver, responseOver);
            return;
        }

        //  5. 未登录 返回为登录结果  ----输出流响应数据
        log.info("用户未登录");
        responseOver.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

//        log.info("拦截到请求:{}", requestOver.getRequestURI());
//        chain.doFilter(requestOver, responseOver);
    }

    /**
     * 路径匹配 检查本次请求是否需要放行
     *
     * @param urls
     * @param requsetURI
     * @return
     */
    public boolean check(String[] urls, String requsetURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requsetURI);
            if (match)
                return true;
        }
        return false;
    }

}
