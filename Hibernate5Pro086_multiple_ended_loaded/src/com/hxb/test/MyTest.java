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
	
	/*测试数据准备*/
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
			//Country，即一方在维护关联关系
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
	
	/*测试多端检索优化*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Country country = session.get(Country.class, 2);
			
			//如果lazy="false",这句执行后还是会查Minister，如果是懒加载，这句执行完，就不会去查询Minister
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
	
	/*测试多端检索优化:fetch="subselect"*/
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







































