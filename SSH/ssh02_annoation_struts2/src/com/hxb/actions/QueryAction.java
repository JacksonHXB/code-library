package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hxb.beans.Student;
import com.hxb.service.IStudentService;

@Namespace("/test")
@ParentPackage("struts-default")
@Component			//spring注解
public class QueryAction {
	private int id;
	
	@Autowired
	@Qualifier("studentService")   //byName方式自动注入
	private IStudentService service;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IStudentService getService() {
		return service;
	}
	public void setService(IStudentService service) {
		this.service = service;
	}
	
	@Action(value="query",results={@Result(location="/welcome.jsp")})
	public String execute(){
		Student student = service.findStudentById(id);
		System.out.println("student.name=" + student.getName());
		return "success";
	}
}





































