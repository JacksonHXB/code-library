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
	
	/*��������׼��*/
	@Test
	public void test00(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Minister minister = new Minister("aaa");
			Minister minister2 = new Minister("bbb");
			Minister minister3 = new Minister("ccc");
			
			Country country = new Country("USA");
			//Country����һ����ά��������ϵ
			country.getMinisters().add(minister);
			country.getMinisters().add(minister2);
			country.getMinisters().add(minister3);
			
			session.save(country);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*����ɾ��orphan*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			
			Minister minister = session.get(Minister.class, 2);
			
			Country country = session.get(Country.class, 1);
			Set<Minister> ministers = country.getMinisters();
			
			/*ɾ���ڵ�*/
			ministers.remove(minister);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}







































