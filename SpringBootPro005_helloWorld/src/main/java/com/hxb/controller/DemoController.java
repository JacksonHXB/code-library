package com.hxb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//这个类的所有方法返回的数据直接写给浏览器（如果是对象转为json数据）
//@ResponseBody
//@Controller
@RestController//RestController其实是上面两个注解的合并
public class DemoController {
	
	@RequestMapping("/demo")
	public String demo(){
		return "test";
	}
}
