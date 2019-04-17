package com.hxb.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.hxb.beans.Country;
import com.hxb.beans.Minister;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*����1:n��ϵӳ��*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Minister minister = new Minister("aaa");
			Minister minister2 = new Minister("bbb");
			Minister minister3 = new Minister("ccc");
			
			Set<Minister> ministers = new HashSet<Minister>();
			ministers.add(minister);
			ministers.add(minister2);
			ministers.add(minister3);
			
			Country country = new Country("USA");
			//Country��һ���ڽ���(ά��)������ϵ
			country.setMinisters(ministers);
			
			/*��ʹ�ü���������ʱ������Ͳ�Ҫ��������*/
			//��˲ʱ̬��Minister��Ϊ�־�̬��
//			session.save(minister);
//			session.save(minister2);
//			session.save(minister3);
			
			session.save(country);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*����1:n��ϵӳ��2*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Minister minister = new Minister("aaa");
			Minister minister2 = new Minister("bbb");
			Minister minister3 = new Minister("ccc");
			
			Country country = new Country("USA");
			country.getMinisters().add(minister);
			country.getMinisters().add(minister2);
			country.getMinisters().add(minister3);
			
			session.save(country);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































