package com.hxb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hxb.beans.Student;

/*������*/
@SuppressWarnings("all")
public class MyTest {
	
	/*���Ա���ѧ������*/
	@Test
	public void testSave(){
		//1�������������ļ�������������ļ��Ǳ�׼�����ƣ�hiberante.cfg.xml
		Configuration configure = new Configuration().configure();
		//����������ļ����Ǳ�׼������
//		Configuration configure = new Configuration().configure("hibernate.xml");
		
		//2������session��������
		SessionFactory sessionFactory = configure.buildSessionFactory();
		
		//3����ȡsession����
		Session session = sessionFactory.getCurrentSession();
		
		try {
			//4����������
			session.beginTransaction();
			
			//5��ִ�в���
			Student student = new Student("����", 23, 93.5);
			session.save(student);
			
			//6���ύ����
			session.getTransaction().commit();
		} catch (Exception e) {
			//7����������쳣���ع�����
			session.getTransaction().rollback();
		}
	}
	
	/*����Session�ӿڶ�������ֻ�ȡ��ʽ*/
	@Test
	public void test03(){
		Configuration configure = new Configuration().configure("hibernate.xml");
		SessionFactory sessionFactory = configure.buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		System.out.println("session1 ?= seesion2 : " + (session1 == session2));
		Session session3 = sessionFactory.getCurrentSession();
		Session session4 = sessionFactory.getCurrentSession();
		System.out.println("session3 ?= seesion4 : " + (session3 == session4));
	}
}








































