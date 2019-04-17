package com.hxb.di09;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 * ≤‚ ‘¿‡
 * */
@SuppressWarnings("all")
public class MyTest {
	@Test
	public void test01(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hxb/di09/applicationContext.xml");
		Student student = (Student)ac.getBean("myStudent");
		Person person = (Person)ac.getBean("myPerson");
		
		System.out.println(person);
		System.out.println(student);
	}
}

































