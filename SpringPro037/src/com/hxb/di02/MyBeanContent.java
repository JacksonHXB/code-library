package com.hxb.di02;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration				//表示当前类，充当Spring容器，即所有的Bean将由这个类来创建
public class MyBeanContent {
	
	@Bean(name="mySchool")	//在容器中加载Bean
	public School getMySchool(){
		return new School("北京大学");
	}
	
	@Bean(name="myStudent", autowire=Autowire.BY_TYPE) //从当前类的容器中，查找与域属性的类型具有is-a关系的Bean
	public Student getMyStudent(){
		return new Student("张珊", 28);
	}
}




























