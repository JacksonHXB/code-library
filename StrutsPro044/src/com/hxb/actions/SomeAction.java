package com.hxb.actions;

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
	
	public String doFirst() {
		if("aaa".equals(name)) {
			return "ar";
		}
		if("bbb".equals(name)) {
			return "br";
		}
		return "success";
	}
	
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










































