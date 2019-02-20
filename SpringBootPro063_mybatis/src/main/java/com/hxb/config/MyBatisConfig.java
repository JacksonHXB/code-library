package com.hxb.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.apache.ibatis.session.Configuration;


@org.springframework.context.annotation.Configuration
public class MyBatisConfig {
	/*自定义的驼峰命名规则，用_代替大写*/
	@Bean
	public ConfigurationCustomizer configurationCustomizer(){
		return new ConfigurationCustomizer() {
			@Override
			public void customize(Configuration configuration) {
				//开启驼峰命名法规则
				configuration.setMapUnderscoreToCamelCase(true);
			}
		};
	}
}













































