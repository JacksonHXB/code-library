package com.hxb.aop06;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;


/*ǰ��֪ͨ*/
public class MyMethodBeforeAdvice implements MethodBeforeAdvice{
	/*��ǰ������Ŀ�귽��ִ��֮ǰִ��
		method��Ŀ�귽��
		args:Ŀ�귽���Ĳ����б�
		target:Ŀ�����
	*/
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		/*--����Ŀ�귽������ǿ�����Ӧ��д������--*/
		System.out.println("ִ��ǰ��֪ͨ������");
	}
}




























