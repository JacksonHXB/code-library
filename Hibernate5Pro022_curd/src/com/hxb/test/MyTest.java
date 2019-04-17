package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hxb.beans.Student;
import com.hxb.utils.HbnUitls;

/*����CURD*/
@SuppressWarnings("all")
public class MyTest {
	
	/*����ѧ������*/
	@Test
	public void testInsert(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("����", 23, 93.5);
			//���Ӷ���
			session.save(student);
			//���Ӷ���ĵڶ��ַ�ʽ������JPA�����API������Hibernate��API,һ�㲻ʹ���������
			//session.persist(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*ɾ��ѧ������*/
	@Test
	public void testDelete(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("����", 23, 93.5);
			//����ֱ��ɾ������,����ͨ������ɾ����Ҳ���Ƕ���Ҫ����Ψһ��
			student.setId(1);
			session.delete(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*�޸�ѧ������*/
	@Test
	public void testUpdate(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("����", 45, 95.5);
			//�޸Ķ���
			student.setId(2);
			session.update(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*�޸�ѧ������*/
	@Test
	public void testQuery(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			System.out.println(student);
			/*get()��load()��ͬ�㣺����ID���ض���������get()��ѯ��������ʱ���᷵��null����load()��ѯ��������ʱ���ᱨ�쳣*/
			Student student2 = session.load(Student.class, 2);
			System.out.println(student2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*����.saveOrUpdate()*/
	@Test
	public void testSaveOrUpdate(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("����", 45, 95.5);
			//��������Ķ�����ID,��ִ��.update()������ִ��.save();����������Ķ��������ݿ���û�д�ID������׳��쳣
			session.saveOrUpdate(student);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	//����.getCurrentSession()�������Ҫ��
	@Test
	public void testGetLoad(){
		Session session = HbnUitls.getSession();
		//ͨ��.getCurrentSession()��ȡ����Session����ִ�еĲ�ѯ�����������񻷾��²���
		Student student = session.get(Student.class, 2);
		System.out.println(student);
	}
	
	//����.openSession()�������Ҫ��
	@Test
	public void testGetLoad2(){
		Session session = HbnUitls.getSessionFactory().openSession();
		//ͨ��.openSession()��ȡ����Session����ִ�еĲ���������һ��Ҫ�����񻷾���ִ��
		Student student = session.get(Student.class, 2);
		System.out.println(student);
	}
	
	@Test
	public void testCURD(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			/*��ɾ�Ĳ���������ͬһ���������У���ϵͳĬ�ϵ�ִ��˳��Ϊ����ɾ*/
			//ɾ��
			Student student = session.get(Student.class, 2);
			session.delete(student);
			//ͨ��ˢ��Session���棬���Դ���ͬһ������Ĭ�ϵ�ִ��˳��
//			session.flush();
			
			//����
			Student student2 = new Student("����", 23, 54.2);
			session.save(student2);
			
			//�޸�
			Student student3 = session.get(Student.class, 3);
			student3.setName("����");
			session.update(student3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
		}
	}
}








































