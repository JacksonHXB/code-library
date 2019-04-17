package com.hxb.di01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//��ʾ��ǰ�౻spring����������,���ע��ֻʹ��һ��value���ԣ�value���Բ���д
@Component(value="myStudent")
@Scope("singleton")					//ָ��������Ĭ����singleton
public class Student {
	
	@Value("����")
	private String name;
	
	@Value("23")
	private int age;
	
	@Autowired						//����byType��ʽ���������Զ�ע�룬����ʹ��
	@Qualifier("mySchool")			//����byName��ʽ���������Զ�ע��,Ҫ��@Autowired��@Qualifier����ʹ��
	private School school;			//�������ԣ�������
	
	//@Resource						//����byType��ʽ���������Զ�ע�뷽ʽ2������ʹ��
	@Resource(name="myHome")		//����byName��ʽ���������Զ�ע�뷽ʽ2������ʹ��
	private Home home;
	
	public void setHome(Home home) {
		this.home = home;
	}
	public void setName(String name) {
		System.out.println("ִ��setName()");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("ִ��setAge()");
		this.age = age;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + ", home=" + home + "]";
	}
	
	//Bean��ʼ��ʱ
	@PostConstruct
	public void initAfter(){
		System.out.println("��ǰBean��ʼ������ϣ�");
	}
	
	//Bean����ʱ
	@PreDestroy
	public void preDestory(){
		System.out.println("��ǰBean���������٣�");
	}
}
