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
	
	/*����1:n��ϵ˫�����ӳ��*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			Minister minister = new Minister("aaa");
			Minister minister2 = new Minister("bbb");
			
			Country country = new Country("USA");
			//Country����һ����ά��������ϵ����ӳ���ļ��м���inverse����ʹCountry����ά��Ȩ
			country.getMinisters().add(minister);
			country.getMinisters().add(minister2);
			
			session.save(country);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































