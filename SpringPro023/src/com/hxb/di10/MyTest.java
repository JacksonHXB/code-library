package com.hxb.di10;
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
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hxb/di10/applicationContext.xml");
		Student student = (Student)ac.getBean("myStudent");
		System.out.println(student);
		School school = (School)ac.getBean("mySchool");
		System.out.println(school);
	}
}

































