package com.template.demos;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.template.demos.config.AuthorizationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan({"com.template.demos.admin.dao"})
public class DemoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public AuthorizationInterceptor getAuthorizationInterceptor(){
		return new AuthorizationInterceptor();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//     /api/**
		registry.addInterceptor(getAuthorizationInterceptor()).addPathPatterns("/api/**").excludePathPatterns("/api/**/login")
				.excludePathPatterns("/swagger**").excludePathPatterns("/admin").excludePathPatterns("/index").excludePathPatterns("/login")
				.addPathPatterns("/admin");
	}
	/**
	 * mybatis-plus分页插件
	 */

	@Bean

	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}
}
