package com.hxb.aop03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("ִ�л���֪ͨ��Ŀ�귽��ִ��֮ǰ��");
		
		//ִ��Ŀ�귽��
		Object result =  invocation.proceed();
		
		System.out.println("ִ�л���֪ͨ��Ŀ�귽��ִ��֮��");
		//����֪ͨ�����޸�Ŀ�귽���ķ��ؽ��
		if(result != null){
			result = ((String)result).toUpperCase();
		}
		return result;
	}
}





























