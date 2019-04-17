package com.hxb.test;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxb.beans.Student;
import com.hxb.service.IStudentService;
/*
 * 测试类
 * */
@SuppressWarnings("all")
public class MyTest {
	private IStudentService service;
	
	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IStudentService)ac.getBean("studentService");
	}
	
	/*增加用户*/
	@Test
	public void test01(){
		Student student = new Student("张三", 23);
		service.addStudent(student);
	}
	
	/*删除用户*/
	@Test
	public void test02(){
		service.removeStudentById(2);
	}
	
	/*修改用户*/
	@Test
	public void test03(){
		Student student = new Student("王五", 100);
		service.modifyStudent(student);
	}
	
	/*查询所有的学生姓名*/
	@Test
	public void test04(){
		List<String> names = service.queryAllStudentsNames();
		System.out.println(names);
	}
	
	/*根据ID查询名字*/
	@Test
	public void test05(){
		String name = service.queryStudentNameById(3);
		System.out.println(name);
	}
	
	/*查询所有的学生*/
	@Test
	public void test06(){
		List<Student> students = service.queryAll();
		for(Student student: students){
			System.out.println(student);
		}
	}
	
	/*根据ID查询学生*/
	@Test
	public void test07(){
		Student student = service.queryStudentById(3);
		System.out.println(student);
	}
}











































































