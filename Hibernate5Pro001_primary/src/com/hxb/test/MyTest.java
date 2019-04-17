package com.hxb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hxb.beans.Student;

/*测试类*/
@SuppressWarnings("all")
public class MyTest {
	
	/*测试保存学生对象*/
	@Test
	public void testSave(){
		//1，加载主配置文件，如果主配置文件是标准的名称：hiberante.cfg.xml
		Configuration configure = new Configuration().configure();
		//如果主配置文件不是标准的名称
//		Configuration configure = new Configuration().configure("hibernate.xml");
		
		//2，创建session工厂对象
		SessionFactory sessionFactory = configure.buildSessionFactory();
		
		//3，获取session对象
		Session session = sessionFactory.getCurrentSession();
		
		try {
			//4，开启事务
			session.beginTransaction();
			
			//5，执行操作
			Student student = new Student("张三", 23, 93.5);
			session.save(student);
			
			//6，提交事务
			session.getTransaction().commit();
		} catch (Exception e) {
			//7，如果出现异常，回滚事务
			session.getTransaction().rollback();
		}
	}
	
	/*测试Session接口对象的两种获取方式*/
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








































