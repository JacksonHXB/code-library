package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hxb.beans.Student;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	@Test
	public void testInsert(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			Student student = new Student("уехЩ", 23, 93.5);
			session.save(student);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































