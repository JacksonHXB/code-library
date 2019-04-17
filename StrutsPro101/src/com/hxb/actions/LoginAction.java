package com.hxb.actions;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class LoginAction extends ActionSupport{
	private String name;
	private String mobile;
	
	public String execute() {
		System.out.println("Ö´ÐÐexecute()!");
		return "success";
	}
	public String doFirst() {
		System.out.println("Ö´ÐÐdoFirst()!");
		return "success";
	}
	public String doSecond() {
		System.out.println("Ö´ÐÐdoSecond()!");
		return "success";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}










































