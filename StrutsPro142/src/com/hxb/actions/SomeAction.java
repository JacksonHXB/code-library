package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/test")
@ParentPackage("struts-default")
@Results({@Result(name="ar", location="/apage.jsp"), @Result(name="br", location="/bpage.jsp")})//����ȫ����ͼ
public class SomeAction {
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
	
	@Action(value="first", results={@Result(location="/success.jsp")})//type��name���Զ����Բ���д
	public String doFirst() {
		if("aaa".equals(name)) {
			return "ar";
		}
		if("bbb".equals(name)) {
			return "br";
		}
		return "success";
	}
	
	@Action(value="second", results={@Result(name="welcome", location="/welcome.jsp")})
	public String doSecond() {
		if(age < 15) {
			return "ar";
		}
		if(age > 40) {
			return "br";
		}
		return "welcome";
	}
}










































