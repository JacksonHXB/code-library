package com.hxb.aop04;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/*����֪ͨ*/
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	//��Ŀ�귽��ִ��֮��
	//returnValue:Ŀ�귽���ķ���ֵ
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ִ�к���֪ͨ������returnVlaue=" + returnValue);
	}
}


































