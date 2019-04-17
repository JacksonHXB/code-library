package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hxb.beans.NewsLabel;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*�Թ���1*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//����Ŀ
			NewsLabel child = new NewsLabel("����","��������");
			NewsLabel child2 = new NewsLabel("����","��������");
			
			//����Ŀ
			NewsLabel sport = new NewsLabel("��������", "��������");
			
			//����Ŀά��������ϵ
			sport.getChildNewsLabels().add(child);
			sport.getChildNewsLabels().add(child2);
			
			session.save(sport);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*�Թ���2*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//����Ŀ
			NewsLabel sport = new NewsLabel("��������", "��������");
			
			//����Ŀ
			NewsLabel child = new NewsLabel("����","��������");

			//����Ŀά��������ϵ
			child.setParentNewsLabel(sport);
			
			session.save(child);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































