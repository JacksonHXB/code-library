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
	
	/*���һ������ϵӳ��*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//���һ����,ֻ���ɶ෽��ά��������ϵ
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








































