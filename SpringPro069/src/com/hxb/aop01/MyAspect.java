package com.hxb.aop01;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect		//��ʾ��ǰ��Ϊ����
public class MyAspect {
	
	/*ǰ��֪ͨ*/
	@Before("execution(* *..ISomeService.doFirst(..))")
	public void before(){
		//jp��ʾƥ�����ķ���
		System.out.println("ִ��ǰ��֪ͨ������");
	}
	@Before("execution(* *..ISomeService.doFirst(..))")
	public void before(JoinPoint jp){
		//jp��ʾƥ�����ķ���
		System.out.println("ִ��ǰ��֪ͨ������jp = " + jp);
	}
	
	
	/*����֪ͨ*/
	@AfterReturning(value="execution(* *..ISomeService.doSecond(..))", returning="result")
	public void myAfterReturning(Object result){
		System.out.println("ִ�к���֪ͨ!result=" + result);
	}
	
	
	/*����֪ͨ*/
	@Around("execution(* *..ISomeService.doThrid(..))")
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
	@AfterThrowing("execution(* *..ISomeService.doThrid(..))")
	public void myAfterThrowing(){
		System.out.println("ִ���쳣֪ͨ��");
	}
	@AfterThrowing(value="execution(* *..ISomeService.doThrid(..))", throwing="ex")
	public void myAfterThrowing(Exception ex){
		System.out.println("ִ���쳣֪ͨ��ex = " + ex.getMessage());
	}
	
	
	/*����֪ͨ*/
	@After("doThridPointcut()")
	public void myAfter(){
		System.out.println("ִ������֪ͨ����");
	}
	
	
	/*�Զ��������*/
	@Pointcut("execution(* *..ISomeService.doThrid(..))")
	public void doThridPointcut(){}
}





































