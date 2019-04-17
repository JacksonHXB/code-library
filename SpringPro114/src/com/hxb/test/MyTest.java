package com.hxb.test;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hxb.service.BuyStockException;
import com.hxb.service.IBuyStockService;
/*
 * 测试类
 * */
@SuppressWarnings("all")
public class MyTest {
	private IBuyStockService service;
	
	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IBuyStockService)ac.getBean("serviceProxy");
	}
	
	/*开户*/
	@Test
	public void test01(){
		service.openAccount("张三", 10000);
		service.openStock("北京动力节点", 0);
	}
	
	/*买股票*/
	@Test
	public void test02(){
		try {
			service.buyStock("张三", 2000, "北京动力节点", 5);
		} catch (BuyStockException e) {
			e.printStackTrace();
		}
	}
}











































































