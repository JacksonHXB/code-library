package com.hxb.di03;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/*
 * spirng��junit������:
 * 		�Զ�������������
 * */
@SuppressWarnings("all")
@RunWith(SpringJUnit4ClassRunner.class)									//���û���
@ContextConfiguration(locations="classpath:com/hxb/di03/applicationContext.xml")	//���������ļ��������ļ�����Ҫ������·����
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

































