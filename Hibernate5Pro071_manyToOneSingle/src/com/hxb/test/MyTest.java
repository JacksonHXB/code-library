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
	
	/*多对一关联关系映射*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//多对一关联,只能由多方来维护关联关系
			Country country = new Country("USA");
			Minister minister = new Minister("aaa");
			minister.setCountry(country);
			
			session.save(minister);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































