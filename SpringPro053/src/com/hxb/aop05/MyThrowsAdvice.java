package com.hxb.aop05;

import org.springframework.aop.ThrowsAdvice;

/*�쳣֪ͨ*/
public class MyThrowsAdvice implements ThrowsAdvice {
	public void afterThrowing(UsernameException ex){
		System.out.println("�����û����쳣ex=" + ex.getMessage());
	}
	
	public void afterThrowing(PasswordException ex){
		System.out.println("���������쳣ex=" + ex.getMessage());
	}
	
	//���������쳣ʱ��ӡ
	public void afterThrowing(Exception ex){
		System.out.println("���������쳣ex=" + ex.getMessage());
	}
}




































