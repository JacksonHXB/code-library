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
	
	/*֤��һ�������Ǵ��ڵ�*/
	@Test
	public void testCache(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//��һ�β�ѯ
			Student student = session.get(Student.class, 2);
			System.out.println("student=" + student);
			System.out.println("-----------------------------------");
			
			//�ڶ��β�ѯ
			/*��������һ�β�ѯ��select�����ڶ��β�ѯû��select��ѯ��䣬����һ�������Ǵ��ڵ�*/
			Student student2 = session.get(Student.class, 2);
			System.out.println("student2=" + student2);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*��֤���յ�����*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			/*session.get()������Щ������
				1) �����ݴ�DB�ж�ȡ����
				2��������ת��Ϊ���󣬴�ŵ����ڴ�
				3���������ID����session����map��key�У��������Ӧ�÷���session����map��value��
				4���������������뵽�����ա���
			*/
			Student student = session.get(Student.class, 2);
			//������޸�����޸ĵ��Ƕ��ڴ��еĶ���
			student.setName("����");
			
			/* �����ύʱ�Ĳ������ݣ�
				�����ڴ��е������롰���ա��е����ݽ��жԱȣ����ȽϵĽ����ͬ����ִ�С�ͬ����������session�е����ݸ��µ�DB�С������ȽϽ����ͬ����ִ��update
			*/
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*ɾ���ٵ���ˢ�µ��Ĳ���*/
	@Test
	public void test03(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			//ִ�е�session.delete()�󣬲�����ֱ��ִ��delete��SQL��䣬�����ڵ���ˢ�µ�֮�󣬲Ż�ִ�С�����Ƕ�Session�������ݵ�ˢ��
			//ʵ�ʾ��ǶԶ��ڴ������ݵĸ���
			session.delete(student);
			
			//ˢ�µ�
			session.createQuery("from Student").list();
			
			//û�е���ͬ���㣬�ǲ���������ݿ��
			//session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*�޸Ĳٵ���ˢ�µ��Ĳ���*/
	@Test
	public void test04(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = session.get(Student.class, 2);
			//��ִ���޸Ĳ���ʱ����ʹ�ﵽˢ�µ㣬�Ƿ�ִ��update��SQL���
			//��Ҫȡ�����޸ĵ���������������ݵĶԱȽ������ͬ����ִ�У�����ִ��update��SQL
			student.setName("����");
			//session.update(student);
			
			//ˢ�µ�
			session.createQuery("from Student").list();
			
			//session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*����ٵ���ˢ�µ��Ĳ���*/
	@Test
	public void test05(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Student student = new Student("��ĸ", 25, 46.5);
			//����������赽��ˢ�µ�
			session.save(student);
			
			//ˢ�µ�
			session.createQuery("from Student").list();
			
			//session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































