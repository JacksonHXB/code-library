package com.hxb.interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("all")
public class PermissionInterceptor extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("------- �ѽ��������� ---------");
		String user = (String)ActionContext.getContext().getSession().get("user");
		if(user != null){
			return invocation.invoke();//ͨ����������
		}
		return "fail";
	}
}






































