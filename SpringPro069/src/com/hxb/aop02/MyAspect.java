package com.hxb.aop02;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	//前置通知
	public void myBefore(){
		System.out.println("执行前置通知！");
	}
	public void myBefore(JoinPoint jp){
		System.out.println("执行前置通知！jp=" + jp);
	}
	
	//后置通知
	public void myAfterReturning(Object result){
		System.out.println("执行后置通知！result = " + result);
	}
	
	
	/*环绕通知*/
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
	public void myAfterThrowing(Exception ex){
		System.out.println("执行异常通知！ex=" + ex);
	}
	
	
	/*最终通知*/
	public void myAfter(){
		System.out.println("执行最终通知方法");
	}
}





































