package com.hxb.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	//ǰ��֪ͨ
	public void myBefore(){
		System.out.println("ִ��ǰ��֪ͨ��");
	}
	public void myBefore(JoinPoint jp){
		System.out.println("ִ��ǰ��֪ͨ��jp=" + jp);
	}
	
	//����֪ͨ
	public void myAfterReturning(Object result){
		System.out.println("ִ�к���֪ͨ��result = " + result);
	}
	
	
	/*����֪ͨ*/
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("ִ�л���֪ͨ������Ŀ�귽��ִ��֮ǰ��");
		//ִ��Ŀ�귽��
		Object result = pjp.proceed();
		System.out.println("ִ�л���֪ͨ������Ŀ�귽��ִ��֮��");
		if(result != null){
			result = ((String)result).toUpperCase();
		}
		return result;
	}
	
	/*�쳣֪ͨ*/
	public void myAfterThrowing(Exception ex){
		System.out.println("ִ���쳣֪ͨ��ex=" + ex);
	}
	
	
	/*����֪ͨ*/
	public void myAfter(){
		System.out.println("ִ������֪ͨ����");
	}
}





































