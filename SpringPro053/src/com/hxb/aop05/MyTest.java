package com.hxb.aop05;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class MyTest {
	@Test
	public void test01() throws UserException{
		String resource = "com/hxb/aop04/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		ISomeService service = (ISomeService)ac.getBean("serviceProxy");
		service.login("beijing", "123456");
		service.login("Jackson", "123456");
		service.login("beijing", "654321");
	}
}




























