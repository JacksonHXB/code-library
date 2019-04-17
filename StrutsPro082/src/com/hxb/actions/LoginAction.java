package com.hxb.actions;

import java.util.List;
import com.hxb.beans.Student;

public class LoginAction {
	//集合数据接收
	private List<Student> students;

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String execute(){
		return "success";
	}
}








































