package com.hxb.test;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxb.beans.Student;
import com.hxb.service.IStudentService;
/*
 * ������
 * */
@SuppressWarnings("all")
public class MyTest {
	private IStudentService service;
	
	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IStudentService)ac.getBean("studentService");
	}
	
	/*�����û�*/
	@Test
	public void test01(){
		Student student = new Student("����", 23);
		service.addStudent(student);
	}
	
	/*ɾ���û�*/
	@Test
	public void test02(){
		service.removeStudentById(2);
	}
	
	/*�޸��û�*/
	@Test
	public void test03(){
		Student student = new Student("����", 100);
		service.modifyStudent(student);
	}
	
	/*��ѯ���е�ѧ������*/
	@Test
	public void test04(){
		List<String> names = service.queryAllStudentsNames();
		System.out.println(names);
	}
	
	/*����ID��ѯ����*/
	@Test
	public void test05(){
		String name = service.queryStudentNameById(3);
		System.out.println(name);
	}
	
	/*��ѯ���е�ѧ��*/
	@Test
	public void test06(){
		List<Student> students = service.queryAll();
		for(Student student: students){
			System.out.println(student);
		}
	}
	
	/*����ID��ѯѧ��*/
	@Test
	public void test07(){
		Student student = service.queryStudentById(3);
		System.out.println(student);
	}
}











































































