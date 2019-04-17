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
	
	/*���Զ�˼����Ż�*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Country country = session.get(Country.class, 2);
			
			//���lazy="false",���ִ�к��ǻ��Minister������������أ����ִ���꣬�Ͳ���ȥ��ѯMinister
			System.out.println("country.cname:" + country.getCname());
			
			Set<Minister> ministers = country.getMinisters();
			System.out.println("ministers.size:" + ministers.size());
			for(Minister m: ministers){
				System.out.println(m);
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*���Զ�˼����Ż�:fetch="subselect"*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Country";
			List<Country> countryList = session.createQuery(hql).list();
			for(Country country:countryList){
				Set<Minister> ministers = country.getMinisters();
				System.out.println("ministers.size:" + ministers.size());
				for(Minister minister:ministers){
					System.out.println(minister);
				}
			}
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}







































