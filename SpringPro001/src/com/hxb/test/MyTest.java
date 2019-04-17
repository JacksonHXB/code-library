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
 * ������
 * */
@SuppressWarnings("all")
public class MyTest {
	/*��ͳ����*/
	@Test
	public void test01(){
		//��ȡʵ����
		ISomeService service = new SomeServiceImpl();
		service.doSome();
	}
	
	/*ʹ��Spring*/
	@Test
	public void test02(){
		//����ApplicationContext��������, Ĭ�ϼ�����·���µ�xml�ļ�
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//����ApplicationContext��������Ĭ�ϼ�����Ŀ�ĸ��²��������ļ�
		ApplicationContext ac = new FileSystemXmlApplicationContext("D:/Java/Code/Frame_Codes/SpringPro001/src/applicationContext.xml");
		
		//��ȡʵ����
		ISomeService service = (ISomeService)ac.getBean("myService");
		service.doSome();
	}
	
	/*ʹ��Spring2*/
	@Test
	public void test03(){
		//����BeanFactory����
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		//��ȡʵ����
		ISomeService service = (ISomeService)bf.getBean("myService");
		service.doSome();
	}
	/*
		ApplicationContext��BeanFactory�����������������
			������������������Bean����ʱ����ͬ
			ApplicationContext: �ڽ��г�ʼ��ʱ���Ὣ��������Bean(����)���д���������һ��������ַ�ʽ��
				ȱ�㣺ռ��ϵͳ��Դ���ڴ棬CPU�ȣ�����
				�ŵ㣺��Ӧ�ٶȿ�
			BeanFactory: �����еĶ�����������ʼ��ʱ�����ᱻ������������������ȡ�ö���ʱ�Żᱻ����
				ȱ�㣺�����˵����Ӧ�ٶ���
				�ŵ㣺����ռ��ϵͳ��Դ
	*/
}

































