package com.hxb.controller;

import java.util.Arrays;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	/*默认访问首页,可以通过添加SpringMVC的扩展进行实现*/
//	@RequestMapping({"/", "/index.html"})
//	public String index(){
//		return "index";
//	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello(){
		logger.info("已经进入到.hello()中....");
		return "Hello World!";
	}
	
	//查出一些数据，在页面显示
	@RequestMapping("/success")
	public String success(Map<String,Object> map){
		logger.info("跳转成功页面。。。.");
		map.put("hello", "<h1>你好！</h1>");
		map.put("users", Arrays.asList("张三", "李四", "王五"));
		//classpath:/templates/success.html
		return "success";
	}
}



















