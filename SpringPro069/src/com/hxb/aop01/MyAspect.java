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

@Aspect		//表示当前类为切面
public class MyAspect {
	
	/*前置通知*/
	@Before("execution(* *..ISomeService.doFirst(..))")
	public void before(){
		//jp表示匹配过后的方法
		System.out.println("执行前置通知方法！");
	}
	@Before("execution(* *..ISomeService.doFirst(..))")
	public void before(JoinPoint jp){
		//jp表示匹配过后的方法
		System.out.println("执行前置通知方法！jp = " + jp);
	}
	
	
	/*后置通知*/
	@AfterReturning(value="execution(* *..ISomeService.doSecond(..))", returning="result")
	public void myAfterReturning(Object result){
		System.out.println("执行后置通知!result=" + result);
	}
	
	
	/*环绕通知*/
	@Around("execution(* *..ISomeService.doThrid(..))")
	public Object myAround(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("执行环绕通知方法，目标方法执行之前！");
		//执行目标方法
		Object result = pjp.proceed();
		System.out.println("执行环绕通知方法，目标方法执行之后！");
		if(result != null){
			result = ((String)result).toUpperCase();
		}
		return result;
	}
	
	
	/*异常通知*/
	@AfterThrowing("execution(* *..ISomeService.doThrid(..))")
	public void myAfterThrowing(){
		System.out.println("执行异常通知！");
	}
	@AfterThrowing(value="execution(* *..ISomeService.doThrid(..))", throwing="ex")
	public void myAfterThrowing(Exception ex){
		System.out.println("执行异常通知！ex = " + ex.getMessage());
	}
	
	
	/*最终通知*/
	@After("doThridPointcut()")
	public void myAfter(){
		System.out.println("执行最终通知方法");
	}
	
	
	/*自定义切入点*/
	@Pointcut("execution(* *..ISomeService.doThrid(..))")
	public void doThridPointcut(){}
}





































