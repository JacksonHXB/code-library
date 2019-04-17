package com.hxb.di01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
	��@Componentע�⹦����ͬ���������岻ͬ��ע�⻹��������
		1��@Repository: ע����Daoʵ������
		2) @Service: ע����Serviceʵ������
		3) @Controller:ע����SpringMVC�Ĵ�������
*/

//��ʾ��ǰ�౻spring����������,���ע��ֻʹ��һ��value���ԣ�value���Բ���д
@Component("mySchool")
public class School {
	
	//��Bean��ע�����Բ���ֵ
	@Value("�廪��ѧ")
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
}
