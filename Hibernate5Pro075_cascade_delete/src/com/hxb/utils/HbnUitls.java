package com.hxb.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HbnUitls {
	
	private static SessionFactory sessionFactory;

	//��Ϊ����������õ�sessionFactory��������������Ҫ����.getSessionFactory()
	public static SessionFactory getSessionFactory(){
		//�����õ�������ģʽ
		if(sessionFactory == null || sessionFactory.isClosed()){
			//��ΪsessionFacory�����������������ϵͳ��Դ����ó�ȡ����������ִ��.getCurretnSession()
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
}





















































