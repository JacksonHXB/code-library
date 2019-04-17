package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;
import com.hxb.beans.Course;
import com.hxb.beans.Student;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*׼����������*/
	@Test
	public void test00(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Course course1 = new Course("JavaSE");
			Course course2 = new Course("JavaEE");
			Course course3 = new Course("Android");
			
			Student student1 = new Student("����");
			Student student2 = new Student("����");
			
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
	
	/*����ɾ��ѧ��*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			session.delete(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































