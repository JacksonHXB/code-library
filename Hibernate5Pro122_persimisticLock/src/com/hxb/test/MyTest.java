package com.hxb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.junit.Test;

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
			for (int i = 1; i < 11; i++) {
				Student student = new Student("n_" + i, 15+i, 85+i);
				session.save(student);
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*���Ա�����-д��*/
	@Test
	public void testWrite(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//Ϊ��ѯ���д���������������������������ȡ
			Student student = session.get(Student.class, 2, LockMode.PESSIMISTIC_WRITE);
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*���Ա�����-����*/
	@Test
	public void testRead(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//Ϊ��ѯ��Ӷ��������������ܶ�������޸�
			Student student = session.get(Student.class, 2, LockMode.PESSIMISTIC_READ);
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































