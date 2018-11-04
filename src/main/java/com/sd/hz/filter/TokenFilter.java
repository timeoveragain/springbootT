package com.sd.hz.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = "/*",filterName = "tokenFilter")
//@Order(6) 控制顺序无效
/**
 * 无法使用@Order来控制过滤器的先后顺序
 * 1、可以通过类名，但要限制类名
 * 2、FilterRegistrationBean类的来设置
 */
public class TokenFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type,X-Requested-With");
        response.setHeader("Access-Control-Max-Age", "3600");

        System.out.println("TokenFilter 过滤请求的URL="+request.getRequestURI());
        filterChain.doFilter(request,response);
        System.out.println("TokenFilter end");
    }

    @Override
    public void destroy() {

    }
}
