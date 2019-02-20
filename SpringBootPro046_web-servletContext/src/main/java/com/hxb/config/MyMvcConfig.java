package com.hxb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hxb.component.MyLocaleResolver;

/*使用WebMvcConfigurerAdapter来扩展SpringMVC的功能*/
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
//	@Bean
//	public EmbeddedServletContainerCustomizer emBeddedServletContainerCustomizer(){
//		return new EmbeddedServletContainerCustomizer() {
//			//定制嵌入式Servlet容器相关的规则
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				container.setPort(8083);//设置服务器器的访问端口
//				
//			}
//		};
//	}
	
	/*自定义视图映射规则*/
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//super.addViewControllers(registry);
		//浏览器发送/hello请求来到success的页面
		registry.addViewController("/hello").setViewName("success");
	}
	
	//所有的WebMvcConfigurerAdapter组件都会一起起作用
	@Bean//将组件注册在容器中
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
			
			/*注册视图映射*/
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				//防止表单重复提交，使用视图映射
				registry.addViewController("/main.html").setViewName("dashboard");
			}
			
			/*注册拦截器
			 * SpringBoot已经对静态资源进行了映射，所以对静态资源我们不进行处理
			 * */
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				//System.out.println("正在进行拦截器检查！");
				//registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
			}
			
			
		};
		return adapter;
	}
	
	
	/*处理区域信息*/
	@Bean
	public LocaleResolver localeResolver(){
		return new MyLocaleResolver();//将自定义的区域信息解析器返回
	}
}


































