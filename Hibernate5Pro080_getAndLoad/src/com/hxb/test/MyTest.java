package com.hxb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.junit.Test;

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
			for (int i = 1; i < 11; i++) {
				Student student = new Student("n_" + i, 15+i, 85+i);
				session.save(student);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*当前对象的检索优化：get*/
	@Test
	public void testGet(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			System.out.println("student.id:  " + student.getId());
			System.out.println("student.name:  " + student.getName());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*当前对象的检索优化：load*/
	@Test
	public void testLoad(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.load(Student.class, 2);
			System.out.println("student.id:  " + student.getId());
			System.out.println("student.name:  " + student.getName());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































