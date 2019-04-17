package com.hxb.aop07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("all")
public class MyTest {
	
	/*�нӿ���û�ӿڵ�����
		�нӿ�ʱ�õ���JDK��̬����
		�޽ӿ�ʱ�õ���CGLIB�Ķ�̬���������Զ�ѡ��
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




























