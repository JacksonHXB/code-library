package com.hxb.actions;


@SuppressWarnings("all")
public class LoginAction {
	//向root中隐式的放入数据
	private String name;
	private int age;
	
	public String execute() {
		return "success";
	}
	
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
}





















































































