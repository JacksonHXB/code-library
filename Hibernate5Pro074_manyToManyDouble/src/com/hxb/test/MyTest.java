package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hxb.beans.Course;
import com.hxb.beans.Student;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*��Զ�˫�����*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Course course1 = new Course("JavaSE");
			Course course2 = new Course("JavaEE");
			Course course3 = new Course("Android");
			
			Student student1 = new Student("����");
			Student student2 = new Student("����");
			
			//Student��ά��������ϵ
			student1.getCourses().add(course1);
			student1.getCourses().add(course2);
			student2.getCourses().add(course1);
			student2.getCourses().add(course3);
			
			session.save(student1);
			session.save(student2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��Զ�˫�����2*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student1 = new Student("����");
			Student student2 = new Student("����");
			
			Course course1 = new Course("JavaSE");
			Course course2 = new Course("JavaEE");
			Course course3 = new Course("Android");
			
			//Course��ά��������ϵ
			course1.getStudents().add(student1);
			course1.getStudents().add(student2);
			course2.getStudents().add(student1);
			course3.getStudents().add(student2);
			
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































