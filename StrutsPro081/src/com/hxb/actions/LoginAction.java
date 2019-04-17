package com.hxb.actions;

import com.hxb.beans.Student;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Administrator
 * 模型驱动方式
 */
public class LoginAction implements ModelDriven<Student>{
	private Student student;
	
	public String execute(){
		return "success";
	}
	
	@Override
	public Student getModel() {
		if(student == null){
			student = new Student();
		}
		return student;
	}
}








































