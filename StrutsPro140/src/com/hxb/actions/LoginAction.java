package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/test")//���ֻ��һ������������ʡ�Բ�д
@ParentPackage("struts-default")
public class LoginAction {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//���name��Ĭ������ֵ������ʡ�Բ�д,���resultsֻ��һ��ֵ������ʡ�Դ�����
	@Action(value="login", results=@Result(type="redirectAction", location="second", params={"uname","%{name}","uage","%{age}"}))
	public String execute(){
		System.out.println("ִ��LoginAction�е�execute()!");
		return "success";
	}
}

































































