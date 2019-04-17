package com.hxb.di05;
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
		ApplicationContext ac = new ClassPathXmlApplicationContext("com/hxb/di05/applicationContext.xml");
		Some some = (Some)ac.getBean("mySome");
		System.out.println(some);
	}
}

































