package com.sj.boot3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sj.boot3.interceptor.BoardInterceptor;
import com.sj.boot3.interceptor.SellerInterceptor;
import com.sj.boot3.interceptor.WriterCheckInterceptor;
import com.sj.boot3.interceptor.AdminInterceptor;

@Configuration
public class InerceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private SellerInterceptor sellerInterceptor;
	
	@Autowired
	private AdminInterceptor adminInterceptor;
	
	@Autowired
	private BoardInterceptor boardInterceptor;
	
	@Autowired
	private WriterCheckInterceptor writerCheckInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 적용할 interceptor를 등록
		registry.addInterceptor(sellerInterceptor)
		//interceptor를 사용할 url
				.addPathPatterns("/product/manage");
		//제외할 url
		//.excludePathPatterns("")
		
		registry.addInterceptor(adminInterceptor)
		.addPathPatterns("/admin/manage");
		
		registry.addInterceptor(boardInterceptor)
		.addPathPatterns("/board/*")
		.excludePathPatterns("/board/list");
		
		registry.addInterceptor(writerCheckInterceptor)
		.addPathPatterns("/board/delete")
		.addPathPatterns("/board/update");

		
	}
}
