package com.hxb.aop07;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/*����֪ͨ*/
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	//��Ŀ�귽��ִ��֮��
	//returnValue:Ŀ�귽���ķ���ֵ
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ִ�к���֪ͨ������returnVlaue=" + returnValue);
		//���Բ���Ӱ����ҵ��Ľ��
		if(returnValue != null){
			returnValue = ((String)returnValue).toUpperCase();
			System.out.println("�޸Ĺ����ֵreturnVlaue��" + returnValue);
		}
	}
}


































