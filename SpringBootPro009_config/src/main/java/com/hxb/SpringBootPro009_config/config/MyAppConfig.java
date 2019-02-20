package com.hxb.SpringBootPro009_config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hxb.SpringBootPro009_config.service.HelloService;

/*@Configuration指明当前类是一个配置类，就是替代之前的Spring配置文件*/
@Configuration
public class MyAppConfig {
	//将方法的返回值添加到容器中，容器中这个组件默认的id就是方法名
	@Bean
	public HelloService helloService2(){
		return new HelloService();
	}
	//类似于<bean id="helloService" class="com.hxb.SpringBootPro009_config.service.HelloService"></bean>	
}




































