package com.sd.hz;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 注解表明开启servlet的注解 过滤器拦截器监听器
public class SpringbootTApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTApplication.class, args);
	}
}
