package com.hxb.di13;
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
		String resource1 = "com/hxb/di13/spring-base.xml";
		String resource2 = "com/hxb/di13/spring-beans.xml";
		String[] resources = {resource1, resource2};
		String resource = "com/hxb/di13/spring-*.xml";
		//����ƽ�й�ϵ�������ļ�����һ
		//ApplicationContext ac = new ClassPathXmlApplicationContext(resource1, resource2);
		
		//����ƽ�й�ϵ�������ļ�������
		//ApplicationContext ac = new ClassPathXmlApplicationContext(resources);
		
		//����ƽ�й�ϵ�������ļ�������
		ApplicationContext ac = new ClassPathXmlApplicationContext(resource);
		
		
		Student student = (Student)ac.getBean("myStudent");
		Teacher teacher = (Teacher)ac.getBean("myTeacher");
		System.out.println(student);
		System.out.println(teacher);
	}
}

































