package com.hxb.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

//继承ActionSupport实现数据的回显
@SuppressWarnings("all")
public class LoginAction extends ActionSupport{
	//使用属性驱动方式接收参数
	private int age;
	private Date birthday;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String execute(){
		System.out.println("birthday=" + birthday);
		System.out.println("age=" + age);
		return "success";
	}
}








































