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
	
	/*���Ե��˼����Ż�*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Minister minister = session.get(Minister.class, 3);
			Country country = minister.getCountry();
			System.out.println("country.cname:" + country.getCname());
			
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}







































