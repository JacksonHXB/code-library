package com.hxb;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class HelloWorld {
	public static void main(String[] args){
		SpringApplication.run(HelloWorld.class, args);
	}
	
	/*测试视图解析器的自动配置*/
	@Bean
	public ViewResolver myViewResolver(){
		return new MyViewResolver();
	}
	private static class MyViewResolver implements ViewResolver{
		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			return null;
		}
	}
}












































