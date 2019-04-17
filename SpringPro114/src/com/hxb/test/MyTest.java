package com.hxb.test;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxb.service.BuyStockException;
import com.hxb.service.IBuyStockService;
/*
 * ������
 * */
@SuppressWarnings("all")
public class MyTest {
	private IBuyStockService service;
	
	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IBuyStockService)ac.getBean("serviceProxy");
	}
	
	/*����*/
	@Test
	public void test01(){
		service.openAccount("����", 10000);
		service.openStock("���������ڵ�", 0);
	}
	
	/*���Ʊ*/
	@Test
	public void test02(){
		try {
			service.buyStock("����", 2000, "���������ڵ�", 5);
		} catch (BuyStockException e) {
			e.printStackTrace();
		}
	}
}











































































