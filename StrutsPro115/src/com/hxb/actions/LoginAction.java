package com.hxb.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class LoginAction extends ActionSupport{
	private String name;
	private int age;
	
	public String execute(){
		String[] params = {name};
		String message = this.getText("action.login.message");
		String message2 = this.getText("action.login.message2", params);
		ActionContext.getContext().getSession().put("msg", message);
		ActionContext.getContext().getSession().put("msg2", message2);
		return "success";
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
}







































