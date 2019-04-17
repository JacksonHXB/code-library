package com.hxb.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("all")
public class PermissionInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("------- 已进入拦截器 ---------");
		String user = (String)ActionContext.getContext().getSession().get("user");
		if(user != null){
			return invocation.invoke();//通过此拦截器
		}
		return "fail";
	}
}






































