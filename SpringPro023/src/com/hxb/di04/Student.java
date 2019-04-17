package com.hxb.di04;

public class Student {
	private String name;
	private int age;
	private School school;	//对象属性，域属性
	
//	无参构造器，构造注入属性时不会被调用
//	public Student() {
//		super();
//	}

	public Student(String name, int age, School school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
}
