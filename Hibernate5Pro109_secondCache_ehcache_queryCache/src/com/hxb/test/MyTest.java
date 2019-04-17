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

	/*证明Query查询结果同样会放到一二级缓存中*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//第一次查询：使用Query查询
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country:" + country);
			
			Country country2 = session.get(Country.class, 2);
			System.out.println("country:" + country2);
			
			session.clear();
			
			Country country3 = session.get(Country.class, 2);
			System.out.println("country:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*Query缓存不会从缓存中读取数据*/
	@Test
	public void test03(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//第一次查询：使用Query查询
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country:" + country);
			
			Country country2 = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country2:" + country2);
			
			session.clear();
			
			Country country3 = (Country)session.createQuery(hql).uniqueResult();
			System.out.println("country3:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*开启Query总开关的Query缓存，就会从缓存中读取数据*/
	@Test
	public void test04(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//.setCacheable(true)开启Query缓存
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country:" + country);
			
			Country country2 = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country2:" + country2);
			
			session.clear();
			
			Country country3 = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country3:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*Query缓存内容*/
	@Test
	public void test05(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			String hql = "from Country where cid=2";
			Country country = (Country)session.createQuery(hql).setCacheable(true).uniqueResult();
			System.out.println("country:" + country);
			
			String hql2 = "from Country where cid in (2)";
			Country country2 = (Country)session.createQuery(hql2).setCacheable(true).uniqueResult();
			System.out.println("country2:" + country2);
			
			session.clear();
			
			String hql3 = "from Country where cid like '2'";
			Country country3 = (Country)session.createQuery(hql3).setCacheable(true).uniqueResult();
			System.out.println("country3:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*修改时间戳*/
	@Test
	public void test06(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//第一次查询结果肯定会放入一二级缓存中
			Country country = session.get(Country.class, 2);
			System.out.println("更新前country.name:" + country.getCname());
			
			/*此更新绕过了一级缓存，直接改动了DB，此修改与快照没有任何关系*/
			String hql = "update Country set cname='AAA' where cid=2";
			session.createQuery(hql).executeUpdate();
			
			Country country2 = session.get(Country.class, 2);
			System.out.println("更新后country2.name:" + country2.getCname());
			
			session.clear();
			
			//按之前的学习理论，这里的get()，会先查找一级缓存，再查找二级缓存
			//没有从二级缓存读取这个数据，而是从DB中进行了查询
			//因为query的executeUpdate会修改二级缓存对象中的一个属性：updateTimestamp,修改时间戳
			//实际上二级缓存上二级缓存对象中缓存的内容，要比一级缓存对象缓存内容多一个属性，修改时间戳
			//一旦这个属性被修改，那么，查询会不从二级缓存中读取数据，而是直接从DB中查询
			Country country3 = session.get(Country.class, 2);
			System.out.println("二级缓存后country3.name:" + country3.getCname());
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}

































