package com.sd.hz.config.mvc;

import com.sd.hz.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SrpingMVCConfig extends WebMvcConfigurerAdapter {

    // 自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }



//    //显示声明CommonsMultipartResolver为mutipartResolver
//    @Bean(name = "multipartResolver")
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setDefaultEncoding("UTF-8");
//        //resolveLazily属性启用是为了推迟文件解析，以在在UploadAction中捕获文件大小异常
////        resolver.setResolveLazily(true);
//        resolver.setMaxInMemorySize(40960);
//        //上传文件大小 10M 10*1024*1024
//        resolver.setMaxUploadSize(10 * 1024 * 1024);
//        return resolver;
//    }

//    // 自定义消息转化器的第二种方法
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter converter  = new StringHttpMessageConverter(Charset.forName("UTF-8"));
//        converters.add(converter);
//    }

}
