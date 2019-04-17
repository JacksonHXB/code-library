package com.hxb.aop05;

import org.springframework.aop.ThrowsAdvice;

/*异常通知*/
public class MyThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(UsernameException ex){
		System.out.println("发生用户名异常ex=" + ex.getMessage());
	}
	
	public void afterThrowing(PasswordException ex){
		System.out.println("发生密码异常ex=" + ex.getMessage());
	}
	
	//发生其他异常时打印
	public void afterThrowing(Exception ex){
		System.out.println("发生其他异常ex=" + ex.getMessage());
	}
}




































