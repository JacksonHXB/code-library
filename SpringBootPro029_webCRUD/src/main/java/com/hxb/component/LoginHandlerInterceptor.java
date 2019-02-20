package com.hxb.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*登录检查拦截器*/
public class LoginHandlerInterceptor implements HandlerInterceptor{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
		
	/*目标方法执行之前*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("正在进行登录检查...");
		
		Object user = request.getSession().getAttribute("loginUser");
		
		if(user == null){
			logger.info("无权限，跳转到登录页面");
			//未登录
			request.setAttribute("msg", "没有权限，请先登录！");		
			request.getRequestDispatcher("/").forward(request, response);
			return false;	
		}else{
			return true;
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
