package com.hxb.di02;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration				//��ʾ��ǰ�࣬�䵱Spring�����������е�Bean���������������
public class MyBeanContent {
	
	@Bean(name="mySchool")	//�������м���Bean
	public School getMySchool(){
		return new School("������ѧ");
	}
	
	@Bean(name="myStudent", autowire=Autowire.BY_TYPE) //�ӵ�ǰ��������У������������Ե����;���is-a��ϵ��Bean
	public Student getMyStudent(){
		return new Student("��ɺ", 28);
	}
}




























