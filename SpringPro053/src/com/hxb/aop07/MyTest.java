package com.hxb.aop07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class MyTest {
	
	/*有接口与没接口的区别：
		有接口时用的是JDK动态代理
		无接口时用的是CGLIB的动态代理，它会自动选择
	*/
	@Test
	public void test01(){
		String resource = "com/hxb/aop07/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		SomeService service = (SomeService)ac.getBean("serviceProxy");
		service.doFirst();
		System.out.println("---------------------------------");
		String result = service.doSecond();
		System.out.println(result);
	}
}




























