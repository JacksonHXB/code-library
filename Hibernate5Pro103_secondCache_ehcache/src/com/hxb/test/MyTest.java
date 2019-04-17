package com.hxb.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.junit.Test;
import com.hxb.beans.Country;
import com.hxb.beans.Minister;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*��������׼��*/
	@Test
	public void test00(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Minister minister = new Minister("aaa");
			Minister minister2 = new Minister("bbb");
			Minister minister3 = new Minister("ccc");
			Minister minister4 = new Minister("ddd");
			Minister minister5 = new Minister("eee");
			
			Country country = new Country("USA");
			Country country2 = new Country("CHN");
			//Country����һ����ά��������ϵ
			country.getMinisters().add(minister);
			country.getMinisters().add(minister2);
			country.getMinisters().add(minister3);
			country2.getMinisters().add(minister4);
			country2.getMinisters().add(minister5);
			
			session.save(country);
			session.save(country2);
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	//�鿴ϵͳĬ�ϵ���ʱ�ļ�
	@Test
	public void test01(){
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(path);
	}
	
	/*��֤��������Ĵ�����
		�ڶ��β�ѯ��Ȼ��Hibernate��һ�������������������β�ѯʱ����ȥ��ѯ���ݿ⣬��ô���������Ǵ��ڵģ�*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//��һ�β�ѯ�������ݿ��в�ѯ����
			Country country = session.get(Country.class, 2);
			System.out.println("country:" + country);
			
			//�ڶ��β�ѯ����Session�����в�ѯ����
			Country country2 = session.get(Country.class, 2);
			System.out.println("country:" + country2);
			
			//���һ������
			session.clear();
			
			//�����β�ѯ���Ӷ��������в�ѯ����
			Country country3 = session.get(Country.class, 2);
			System.out.println("country:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	/*��֤���ϻ����е�����:˼·-�ر�Minster���໺��*/
	@Test
	public void test03(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//��һ�β�ѯ
			Country country = session.get(Country.class, 2);
			Set<Minister> ministers = country.getMinisters();
			System.out.println("ministers.size()=" + ministers.size());
			
			
			//�ڶ��β�ѯ
			Country country2 = session.get(Country.class, 2);
			Set<Minister> ministers2 = country2.getMinisters();
			System.out.println("ministers2.size()=" + ministers2.size());
			
			//���һ������
			session.clear();
			
			//�����β�ѯ
			//�໺���������ר�ŵ�һ����Ϊʵ������Ļ����У����������Ϊ��������
			//���ϻ����������ר�ŵ�һ����Ϊ��������Ļ����У����������Ϊ�����������Ķ����ID
			Country country3 = session.get(Country.class, 2);
			Set<Minister> ministers3 = country3.getMinisters();
			System.out.println("ministers3.size()=" + ministers3.size());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}

































