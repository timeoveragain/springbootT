package com.sd.hz.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
//@WebFilter(urlPatterns = "/*",filterName = "testFilter")
//@Order(1)  控制顺序无效
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("TestFilter 过滤请求的URL="+request.getRequestURI());
        filterChain.doFilter(request,response);
        System.out.println("TestFilter..end");
    }

    @Override
    public void destroy() {

    }
}
