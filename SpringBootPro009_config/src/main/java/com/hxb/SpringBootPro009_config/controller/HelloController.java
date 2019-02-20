package com.hxb.SpringBootPro009_config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${person.lastName}")		//从配置文件中获取获取值并赋值给name
	private String name;
	
	@RequestMapping("/sayHello")
	public String sayHello(){
		return "hello"+name;
	}
}
