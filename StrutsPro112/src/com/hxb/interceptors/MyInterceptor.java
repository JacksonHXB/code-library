package com.hxb.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@SuppressWarnings("all")
public class MyInterceptor extends MethodFilterInterceptor{
	/*��������������*/
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("������������");
		return invocation.invoke();
	}
}






































