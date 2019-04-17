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
	
	/*证明一级缓存是存在的*/
	@Test
	public void testCache(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//第一次查询
			Student student = session.get(Student.class, 2);
			System.out.println("student=" + student);
			System.out.println("-----------------------------------");
			
			//第二次查询
			/*剖析：第一次查询有select，而第二次查询没有select查询语句，所以一级缓存是存在的*/
			Student student2 = session.get(Student.class, 2);
			System.out.println("student2=" + student2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*验证快照的作用*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			/*session.get()做了哪些工作：
				1) 将数据从DB中读取出来
				2）将数据转变为对象，存放到堆内存
				3）将对象的ID放入session缓存map的key中，将对象的应用放入session缓存map的value中
				4）将对象的详情放入到“快照”中
			*/
			Student student = session.get(Student.class, 2);
			//下面的修改语句修改的是堆内存中的对象
			student.setName("张三");
			
			/* 事务提交时的操作内容；
				将堆内存中的数据与“快照”中的数据进行对比，若比较的结果不同，则执行“同步操作：将session中的数据更新到DB中”，若比较结果相同，则不执行update
			*/
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*删除操到达刷新点后的操作*/
	@Test
	public void test03(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			//执行到session.delete()后，并不会直接执行delete的SQL语句，而是在到达刷新点之后，才会执行。这就是对Session缓存数据的刷新
			//实际就是对堆内存中数据的更新
			session.delete(student);
			
			//刷新点
			session.createQuery("from Student").list();
			
			//没有到达同步点，是不会更新数据库的
			//session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*修改操到达刷新点后的操作*/
	@Test
	public void test04(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			//当执行修改操作时，即使达到刷新点，是否执行update的SQL语句
			//还要取决于修改的数据与快照中数据的对比结果：相同，则不执行，否则执行update的SQL
			student.setName("李四");
			//session.update(student);
			
			//刷新点
			session.createQuery("from Student").list();
			
			//session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*插入操到达刷新点后的操作*/
	@Test
	public void test05(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("王母", 25, 46.5);
			//插入操作无需到达刷新点
			session.save(student);
			
			//刷新点
			session.createQuery("from Student").list();
			
			//session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































