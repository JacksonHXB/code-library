package com.hxb.di01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
	与@Component注解功能相同，但是意义不同的注解还有三个：
		1）@Repository: 注解在Dao实现类上
		2) @Service: 注解在Service实现类上
		3) @Controller:注解在SpringMVC的处理器上
*/

//表示当前类被spring容器所管理,如果注解只使用一个value属性，value可以不用写
@Component("mySchool")
public class School {
	
	//向Bean中注入属性并赋值
	@Value("清华大学")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
}
