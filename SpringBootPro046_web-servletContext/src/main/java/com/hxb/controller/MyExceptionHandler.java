package com.hxb.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hxb.exception.UserNotExistException;

/*自定义的异常处理器*/
@ControllerAdvice
public class MyExceptionHandler {
	
//	/*方式一：自定义的异常JSON串，浏览器客户端返回的都是JSON*/
//	@ResponseBody
//	@ExceptionHandler(UserNotExistException.class)
//	public Map<String, Object> handlerException(Exception e){
//		Map<String, Object> map = new HashMap<>();
//		map.put("code", "自定义-用户不存在");
//		map.put("message", e.getMessage());
//		return map;
//	}
	
	/*方式二：根据用户的是否使用浏览器还是客户端分别发送不同的错误页面或JSON数据*/
	@ExceptionHandler(UserNotExistException.class)
	public String handlerException(Exception e, HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		
		/*传入我们自己自定义的状态码*/
		request.setAttribute("javax.servlet.error.status_code", 500);
		
		map.put("code", "自定义-用户不存在");
		map.put("message", e.getMessage());
		
		request.setAttribute("etc", map);
		//转发到error请求让SpringBoot进行自适应的错误页面提示
		return "forward:/error";
	}
}







































