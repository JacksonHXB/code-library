package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;
import com.hxb.beans.Course;
import com.hxb.beans.Student;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*准备测试数据*/
	@Test
	public void test00(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Course course1 = new Course("JavaSE");
			Course course2 = new Course("JavaEE");
			Course course3 = new Course("Android");
			
			Student student1 = new Student("张三");
			Student student2 = new Student("李四");
			
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
	
	/*级联删除学生*/
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








































