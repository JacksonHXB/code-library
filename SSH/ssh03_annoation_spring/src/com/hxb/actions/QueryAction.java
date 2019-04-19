package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.hxb.service.IStudentService;

@Namespace("/test")
@ParentPackage("struts-default")
public class QueryAction {
	private int id;
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
		return "success";
	}
}





































