package com.hxb.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


/*登录控制*/
@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	//@RequestMapping(value="/user/login", method=RequestMethod.POST)下边是restful风格的简写
	@PostMapping(value="/user/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						Map<String,Object> map,
						HttpSession session){
		logger.info("正在登录...");
		
		if(!StringUtils.isEmpty(username) && "123456".equals(password)){
			logger.info("登录成功！");
			//登录成功将用户信息存储session中
			session.setAttribute("loginUser", username);
			//登录成功，防止表单重复提交，可以重定向到主页
			return "redirect:/main.html";
		}else{
			map.put("msg", "用户名或密码错误！");
			return "login";
		}
	}
}










































































