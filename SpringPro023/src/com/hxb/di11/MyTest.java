package com.hxb.di11;
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
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hxb/di11/applicationContext.xml");
		Student student = (Student)ac.getBean("myStudent");
		Student student2 = (Student)ac.getBean("myStudent2");
		Student student3 = (Student)ac.getBean("myStudent3");
		System.out.println(student);
		System.out.println(student2);
		System.out.println(student3);
	}
}

































