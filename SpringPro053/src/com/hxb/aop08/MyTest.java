package com.hxb.aop08;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class MyTest {
	@Test
	public void test01(){
		String resource = "com/hxb/aop08/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService)ac.getBean("serviceProxy");
		service.doFirst();
		System.out.println("---------------------------------");
		String result = service.doSecond();
		System.out.println(result);
	}
}




























