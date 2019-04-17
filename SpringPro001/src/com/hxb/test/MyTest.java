package com.hxb.test;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.hxb.service.ISomeService;
import com.hxb.service.SomeServiceImpl;
/*
 * 测试类
 * */
@SuppressWarnings("all")
public class MyTest {
	/*传统方法*/
	@Test
	public void test01(){
		//获取实现类
		ISomeService service = new SomeServiceImpl();
		service.doSome();
	}
	
	/*使用Spring*/
	@Test
	public void test02(){
		//创建ApplicationContext容器对象, 默认加载类路径下的xml文件
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//创建ApplicationContext容器对象，默认加载项目的根下查找配置文件
		ApplicationContext ac = new FileSystemXmlApplicationContext("D:/Java/Code/Frame_Codes/SpringPro001/src/applicationContext.xml");
		
		//获取实现类
		ISomeService service = (ISomeService)ac.getBean("myService");
		service.doSome();
	}
	
	/*使用Spring2*/
	@Test
	public void test03(){
		//创建BeanFactory工厂
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//获取实现类
		ISomeService service = (ISomeService)bf.getBean("myService");
		service.doSome();
	}
	/*
		ApplicationContext与BeanFactory两个容器对象的区别：
			这两个容器对于其中Bean创建时机不同
			ApplicationContext: 在进行初始化时，会将其中所有Bean(对象)进行创建（现在一般采用这种方式）
				缺点：占用系统资源（内存，CPU等）过多
				优点：响应速度快
			BeanFactory: 容器中的对象，在容器初始化时并不会被创建，而是在真正获取该对象时才会被创建
				缺点：相对来说，响应速度慢
				优点：不多占用系统资源
	*/
}

































