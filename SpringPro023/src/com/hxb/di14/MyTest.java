package com.hxb.di14;
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
		String resource = "com/hxb/di14/applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		Student student = (Student)ac.getBean("myStudent");
		Teacher teacher = (Teacher)ac.getBean("myTeacher");
		System.out.println(student);
		System.out.println(teacher);
	}
}

































