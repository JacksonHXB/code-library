package com.hxb.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	
	/*通过注入，可以将Druid数据源的其他配置引入项目中*/
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource druid(){
		return new DruidDataSource();
	}
	
	//配置Druid的监控
	//1,配置一个管理后台的Serlvet
	@Bean
	public ServletRegistrationBean statViewServlet(){
		ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		//配置初始化参数
		Map<String, String> initParams = new HashMap<>();
		initParams.put("loginUsername", "admin");
		initParams.put("loginPassword", "123456");
		initParams.put("allow","127.0.0.1");//默认允许所有的人访问
		initParams.put("deny", "192.168.15.21");
		bean.setInitParameters(initParams);
		return bean;
	}
	//2，配置一个监控的filter
	@Bean
	public FilterRegistrationBean webStatFilter(){
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		//设置初始化参数
		Map<String, String> initParams = new HashMap<>();
		initParams.put("exclusions","*.js,*.css,/druid/*");
		bean.setInitParameters(initParams);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}






























