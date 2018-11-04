package com.sd.hz.config.filter;

import com.sd.hz.filter.TestFilter;
import com.sd.hz.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 方法名不可以是filterRegistrationBean()
 * 过滤器顺序只可以是这种方式实现
 * @Order不可以控制顺序
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean1() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        List<String> urlPatterns = new ArrayList<String>();

        TestFilter testFilter = new TestFilter();
        filterRegistrationBean.setFilter(testFilter);
        urlPatterns.add("/*");
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setName("testFilter");
        filterRegistrationBean.setOrder(2);

        return filterRegistrationBean;
    }

    /**
     * 配置过滤器
     * @return
     */
//    @Bean
//    public FilterRegistrationBean someFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new TestFilter());
//        registration.addUrlPatterns("/*");
////        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("sessionFilter");
//        registration.setOrder(Integer.MAX_VALUE);
//        return registration;
//    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2() {
        FilterRegistrationBean registration = new FilterRegistrationBean(new TokenFilter());
        registration.addUrlPatterns("/*"); //
//        registration.addInitParameter("paramName", "paramValue");
        registration.setName("tokenFilter");
        registration.setOrder(1);
        return registration;
    }

//    @Bean
//    public FilterRegistrationBean authFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new TestFilter());
//        registration.addUrlPatterns("/*"); //
////        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("authFilter");
//        registration.setOrder(0);
//        return registration;
//    }
}
