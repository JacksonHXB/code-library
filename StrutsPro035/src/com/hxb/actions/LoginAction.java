package com.hxb.actions;

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
	
	//action方法，默认时执行execute()
	public String execute() {
		System.out.println("默认执行execute()");
		return "success";
	}
	
	public String doSome() {
		System.out.println("执行doSome()");
		return "success";
	}
	
	//action方法，可以指定执行那个方法
	public String doSecond() {
		System.out.println("执行doSecond()");
		return "success";
	}
}










































