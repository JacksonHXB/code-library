package com.hxb.config;

import java.util.Arrays;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hxb.filter.MyFilter;
import com.hxb.listener.MyListener;
import com.hxb.servlet.MyServlet;

@Configuration
public class MyServerConfig {
	/*注册三大组件*/
	/*注册Servlet组件*/
	@Bean
	public ServletRegistrationBean myServlet(){
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new MyServlet(),"/myServlet");
		registrationBean.setLoadOnStartup(1);//设置启动顺序
		return registrationBean;
	}
	
	
	/*注册Filter组件*/
	@Bean
	public FilterRegistrationBean myFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));//拦截请求
		return registrationBean;
	}
	
	
	/*注册Listener组件*/
	@Bean
	public ServletListenerRegistrationBean<MyListener> myListener(){
		ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());
		return servletListenerRegistrationBean;
	}

	
	/*配置嵌入式的Servlet容器*/
	@Bean
	public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
		return new EmbeddedServletContainerCustomizer() {
			/*定制嵌入式的Servlet容器相关的规则*/
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setPort(8083);
			}
		};
	}
}




































