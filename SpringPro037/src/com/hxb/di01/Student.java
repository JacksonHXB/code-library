package com.hxb.di01;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//表示当前类被spring容器所管理,如果注解只使用一个value属性，value可以不用写
@Component(value="myStudent")
@Scope("singleton")					//指定作用域，默认是singleton
public class Student {
	
	@Value("张三")
	private String name;
	
	@Value("23")
	private int age;
	
	@Autowired						//这是byType方式的域属性自动注入，单独使用
	@Qualifier("mySchool")			//这是byName方式的域属性自动注入,要求@Autowired与@Qualifier联合使用
	private School school;			//对象属性，域属性
	
	//@Resource						//这是byType方式的域属性自动注入方式2，单独使用
	@Resource(name="myHome")		//这是byName方式的域属性自动注入方式2，单独使用
	private Home home;
	
	public void setHome(Home home) {
		this.home = home;
	}
	public void setName(String name) {
		System.out.println("执行setName()");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("执行setAge()");
		this.age = age;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + ", home=" + home + "]";
	}
	
	//Bean初始化时
	@PostConstruct
	public void initAfter(){
		System.out.println("当前Bean初始化刚完毕！");
	}
	
	//Bean销毁时
	@PreDestroy
	public void preDestory(){
		System.out.println("当前Bean即将被销毁！");
	}
}
