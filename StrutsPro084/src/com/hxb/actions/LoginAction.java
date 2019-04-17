package com.hxb.actions;

import java.util.Date;

public class LoginAction {
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








































