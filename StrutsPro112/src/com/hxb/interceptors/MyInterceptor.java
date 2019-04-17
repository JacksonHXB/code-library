package com.hxb.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("all")
public class MyInterceptor extends MethodFilterInterceptor{
	/*方法过滤拦截器*/
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("进入拦截器！");
		return invocation.invoke();
	}
}






































