package com.hxb.di02;

public class Student {
	private String name;
	private int age;
	private School school;	//�������ԣ�������
	
	public Student() {}
	
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		System.out.println("ִ��setName()");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("ִ��setAge()");
		this.age = age;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
	}
}
