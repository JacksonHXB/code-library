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
	
	//查看系统默认的临时文件
	@Test
	public void test01(){
		String path = System.getProperty("java.io.tmpdir");
		System.out.println(path);
	}
	
	/*验证二级缓存的存在性
		第二次查询后，然后将Hibernate的一级缓存清除，如果第三次查询时，不去查询数据库，那么二级缓存是存在的；*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//第一次查询：从数据库中查询数据
			Country country = session.get(Country.class, 2);
			System.out.println("country:" + country);
			
			//第二次查询：从Session缓存中查询数据
			Country country2 = session.get(Country.class, 2);
			System.out.println("country:" + country2);
			
			//清除一级缓存
			session.clear();
			
			//第三次查询：从二级缓存中查询数据
			Country country3 = session.get(Country.class, 2);
			System.out.println("country:" + country3);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	/*验证集合缓存中的内容:思路-关闭Minster的类缓存*/
	@Test
	public void test03(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//第一次查询
			Country country = session.get(Country.class, 2);
			Set<Minister> ministers = country.getMinisters();
			System.out.println("ministers.size()=" + ministers.size());
			
			
			//第二次查询
			Country country2 = session.get(Country.class, 2);
			Set<Minister> ministers2 = country2.getMinisters();
			System.out.println("ministers2.size()=" + ministers2.size());
			
			//清除一级缓存
			session.clear();
			
			//第三次查询
			//类缓存对象存放在专门的一个成为实体区域的缓存中，缓存的内容为对象详情
			//集合缓存对象存放在专门的一个称为集合区域的缓存中，缓存的内容为集合所包含的对象的ID
			Country country3 = session.get(Country.class, 2);
			Set<Minister> ministers3 = country3.getMinisters();
			System.out.println("ministers3.size()=" + ministers3.size());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}

































