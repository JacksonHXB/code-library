package com.hxb.di12;
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
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hxb/di12/applicationContext.xml");
		Student student = (Student)ac.getBean("myStudent");
		Teacher teacher = (Teacher)ac.getBean("myTeacher");
		System.out.println(student);
		System.out.println(teacher);
	}
}

































