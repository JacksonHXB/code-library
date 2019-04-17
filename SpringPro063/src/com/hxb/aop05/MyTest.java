package com.hxb.aop05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class MyTest {
	@Test
	public void test01(){
		String resource = "com/hxb/aop05/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService)ac.getBean("someService");
		service.doFirst();
		System.out.println("---------------------------------");
		service.doThrid();
		
		
		System.out.println("*********************************");
		
		
		ISomeService service2 = (ISomeService)ac.getBean("someService2");
		service2.doFirst();
		System.out.println("---------------------------------");
		service2.doThrid();
	}
}




























