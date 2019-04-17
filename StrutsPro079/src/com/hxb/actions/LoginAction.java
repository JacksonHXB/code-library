package com.hxb.actions;

import com.hxb.beans.Student;

public class LoginAction {
	private Student student;/*以域属性的方式接收参数*/
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}


	public String execute(){
		return "success";
	}
}








































