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
	
	/*��ѯ����,ԭ��SQL��ѯ*/
	@Test
	public void test01_SQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String sql = "select * from tb_student";
			SQLQuery sqlQuery = session.createSQLQuery(sql);//����SQLQuery��ѯ����ѯ�Ľ����һ��Object���飬û�б���װ
			List<Student> studentList = sqlQuery.addEntity(Student.class).list();//��ѯ�Ľ��ͨ��ӳ���ļ��������࣬����װ�ɶ���
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��ѯ����,HQL��ѯ*/
	@Test
	public void test01_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";//�����������
			Query hqlQuery = session.createQuery(hql);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��ѯ����,QBC��ѯ*/
	@Test
	public void test01_QBC(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Criteria qbc = session.createCriteria(Student.class);
			List<Student> studentList = qbc.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��ѯ�������,ԭ��SQL��ѯ*/
	@Test
	public void test02_SQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String sql = "select * from tb_student order by tscore desc";
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			List<Student> studentList = sqlQuery.addEntity(Student.class).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��ѯ�������,HQL��ѯ*/
	@Test
	public void test02_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//�ڲ�ʹ����ı���������£���HQL��ֱ��ʹ���ֶ���Ҳ�ǿ���ͨ���ġ�������ʹ��"�����.������"����ʽ������ʹ���ֶ���
			String hql = "from Student order by score desc";
			Query hqlQuery = session.createQuery(hql);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��ѯ�������,QBC��ѯ*/
	/*��ѯ�������,HQL��ѯ*/
	@Test
	public void test02_QBC(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Criteria qbc = session.createCriteria(Student.class);
			List<Student> studentList = qbc.addOrder(Order.desc("score")).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��̬������,HQL��ѯ��ʽһ*/
	@Test
	public void test03_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where age>? and score<?";
			//�����set����������һֱ����д
			Query hqlQuery = session.createQuery(hql)
									.setInteger(0, 20)
									.setDouble(1, 94);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��̬������,HQL��ѯ��ʽ��*/
	@Test
	public void test03_HQL2(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where age>:myAge and score<:myScore";//����myAge��mySocre�Ǳ���
			Query hqlQuery = session.createQuery(hql)
									.setInteger("myAge", 20)
									.setDouble("myScore", 94);
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��̬������,HQL��ѯ��ʽ��*/
	@Test
	public void test03_HQL3(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where age>? and score<?";
			//���;���Ҫƥ��,Ҳ����ʹ�÷�ʽ����HQL���
			Query hqlQuery = session.createQuery(hql)
									.setParameter(0, 20)
									.setParameter(1, 94.0);//�������ʹ��double���ͣ�����ᱨ�쳣
			List<Student> studentList = hqlQuery.list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��ҳ��ѯ,HQL��ѯ*/
	@Test
	public void test04_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//selcet * from tb_student limit startIndex,pageSize
			String hql = "from Student";
			
			int pageno = 2;//�ڼ�ҳ
			int pageSize = 3;//ÿҳ��ʾ��Ŀ
			int startIndex = (pageno - 1) * pageSize;//��ʼλ��
			List<Student> studentList = session.createQuery(hql)
											   .setFirstResult(startIndex)
											   .setMaxResults(pageSize)
											   .list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*ģ����ѯ,HQL��ѯ*/
	@Test
	public void test05_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where name like :myName";
			List<Student> studentList = session.createQuery(hql)
											   .setString("myName", "%��%")
											   .list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*Ψһ�Բ�ѯ,HQL��ѯ*/
	@Test
	public void test06_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student where name where id=:myId";
			Student student = (Student)session.createQuery(hql).setInteger("myId", 2).uniqueResult();
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*�ۺϺ�����ѯ,HQL��ѯ*/
	@Test
	public void test07_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "select count(*) from Student";
			Long count = (Long)session.createQuery(hql).uniqueResult();
			System.out.println("�ܹ��У�" + count + "�����ݣ�");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*ͶӰ��ѯ,HQL��ѯ*/
	@Test
	public void test08_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "select new Student(name,age) from Student";//�������󲢷�װ��������Ҫ�����������Ĺ�����
			List<Student> studentList = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s.getName() +"  "+s.getAge());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*�����ѯ,HQL��ѯ*/
	@Test//��ѯ�ж��ٸ�����Σ�����ÿ�����������������1
	public void test09_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "select age from Student group by age having count(age) > 1";
			List<Student> studentList = session.createQuery(hql).list();
			System.out.println(studentList);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*ʹ��list()��ѯ����,HQL��ѯ*/
	//Query�ӿڵ�list()���������Session�����ж�ȡ
	@Test
	public void test10_HQL_list(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";
			//��һ�β�ѯ
			List<Student> studentList = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			System.out.println("---------------------------------");
			//�ڶ��β�ѯ
			List<Student> studentList2 = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*ʹ��iterate()��ѯ����,HQL��ѯ*/
	//iterate()��Ч��ԶԶ����list()����Ҫ�ǲ�ѯ���������⣬����iterate��session���棬��һ�β�ѯ�����������Ժ����ԽϿ�,��Ϊʹ��������ѯ�������������ѯ
	/*
		N+1���⣺
			�ڻ����в�ѯN�Σ�ͬʱ����Ҫ�����ݿ��в�ѯN�Σ���ʵ����2N+1��1�����ָ���������ѯ��һ��
			���������
				��һ�β�ѯ����Session���ڶ���ʹ��iterate()
	*/
	@Test
	public void test10_HQL_iterate(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";
			//��һ�β�ѯ
			Iterator<Student> studentItems = session.createQuery(hql).iterate();
			while(studentItems.hasNext()){
				System.out.println(studentItems.next());
			}
			System.out.println("---------------------------------");
			//�ڶ��β�ѯ
			Iterator<Student> studentItems2 = session.createQuery(hql).iterate();
			while(studentItems2.hasNext()){
				System.out.println(studentItems2.next());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*N+1����Ľ������*/
	@Test
	public void test10_HQL_iterateAndList(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Student";
			//��һ�β�ѯ:ʹ��List()
			List<Student> studentList = session.createQuery(hql).list();
			for(Student s: studentList){
				System.out.println(s);
			}
			System.out.println("---------------------------------");
			//�ڶ��β�ѯ:ʹ��iterate()
			Iterator<Student> studentItems2 = session.createQuery(hql).iterate();
			while(studentItems2.hasNext()){
				System.out.println(studentItems2.next());
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*������ѯ��HQL��ѯ*/
	@Test
	public void test11_HQL(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//��ѯ��������ӳ���ļ��ж�ȡ
			Student student = (Student)session.getNamedQuery("queryById")
					                          .setInteger("myid", 2)
					                          .uniqueResult();
			System.out.println(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































