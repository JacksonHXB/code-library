package com.hxb.di04;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * ������
 * */
@SuppressWarnings("all")
public class MyTest {
	@Test
	public void test01(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hxb/di04/applicationContext.xml");
		Student student = (Student)ac.getBean("myStudent");
		System.out.println(student);
	}
}

































