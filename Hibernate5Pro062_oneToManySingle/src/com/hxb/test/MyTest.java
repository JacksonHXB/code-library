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
	
	/*测试1:n关系映射*/
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
			//Country即一方在建立(维护)关联关系
			country.setMinisters(ministers);
			
			/*当使用级联操作的时候，这里就不要三个保存*/
			//将瞬时态的Minister变为持久态度
//			session.save(minister);
//			session.save(minister2);
//			session.save(minister3);
			
			session.save(country);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*测试1:n关系映射2*/
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








































