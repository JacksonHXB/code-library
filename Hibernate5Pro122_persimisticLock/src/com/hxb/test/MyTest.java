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
	
	/*测试悲观锁-写锁*/
	@Test
	public void testWrite(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//为查询添加写锁，不允许其它事务对其操作或读取
			Student student = session.get(Student.class, 2, LockMode.PESSIMISTIC_WRITE);
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*测试悲观锁-读锁*/
	@Test
	public void testRead(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//为查询添加读锁，其余事务不能对其进行修改
			Student student = session.get(Student.class, 2, LockMode.PESSIMISTIC_READ);
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































