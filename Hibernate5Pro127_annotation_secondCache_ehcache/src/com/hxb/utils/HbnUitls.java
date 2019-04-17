package com.hxb.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUitls {
	
	private static SessionFactory sessionFactory;

	//因为二级缓存会用到sessionFactory对象，所以这里需要创建.getSessionFactory()
	public static SessionFactory getSessionFactory(){
		//这里用到单例的模式
		if(sessionFactory == null || sessionFactory.isClosed()){
			//因为sessionFacory是重量级对象很消耗系统资源，最好抽取出来，单独执行.getCurretnSession()
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
}





















































