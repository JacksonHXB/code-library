package com.hxb.actions;

import com.hxb.beans.Student;
import com.hxb.service.IStudentService;

public class RegisterAction {
	private String name;
	private int age;
	//×¢Èëservice
	private IStudentService service;
	
	public void setService(IStudentService service) {
		this.service = service;
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
	
	public String execute(){
		Student student = new Student(name,age);
		service.addStudent(student);
		return "success";
	}
}































