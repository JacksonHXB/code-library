package com.hxb.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hxb.beans.NewsLabel;
import com.hxb.utils.HbnUitls;

@SuppressWarnings("all")
public class MyTest {
	
	/*自关联1*/
	@Test
	public void test01(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//子栏目
			NewsLabel child = new NewsLabel("足球","我是足球");
			NewsLabel child2 = new NewsLabel("篮球","我是篮球");
			
			//父栏目
			NewsLabel sport = new NewsLabel("体育新闻", "体育新闻");
			
			//父栏目维护关联关系
			sport.getChildNewsLabels().add(child);
			sport.getChildNewsLabels().add(child2);
			
			session.save(sport);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	/*自关联2*/
	@Test
	public void test02(){
		Session session = HbnUitls.getSession();
		try {
			session.beginTransaction();
			
			//父栏目
			NewsLabel sport = new NewsLabel("体育新闻", "体育新闻");
			
			//子栏目
			NewsLabel child = new NewsLabel("足球","我是足球");

			//子栏目维护关联关系
			child.setParentNewsLabel(sport);
			
			session.save(child);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
}








































