package com.hxb.di03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
 * spirng的junit测试类:
 * 		自动创建容器对象
 * */
@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)									//配置环境
@ContextConfiguration(locations="classpath:com/hxb/di03/applicationContext.xml")	//加载配置文件，配置文件必须要放在类路径下
public class MyTest {
	
	@Autowired
	private Student student;
	
	@Autowired
	private School school;
	
	@Test
	public void test01(){
		System.out.println(student);
		System.out.println(school);
	}
}

































