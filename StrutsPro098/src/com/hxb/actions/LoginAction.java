package com.hxb.actions;

import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("all")
public class LoginAction extends ActionSupport{
	private String name;
	private String mobile;
	
	public String execute() {
		return "success";
	}
	public String doFirst() {
		System.out.println("执行doFirst()!");
		return "success";
	}
	public String doSecond() {
		System.out.println("执行doSecond()!");
		return "success";
	}
	
	/*数据验证*/
	@Override
	public void validate() {
		if(name == null || "".equals(name.trim())){
			//FiledErrors.size()>0说明了有验证失败的信息，则自动跳转到input视图
			this.addFieldError("name", "用户名不能为空！");
		}
		if(mobile == null || "".equals(mobile.trim())){
			this.addFieldError("mobile", "手机号不能为空！");
		}else if(!Pattern.matches("^1[34578]\\d{9}$", mobile)){
			this.addFieldError("mobile", "手机号格式不正确！");
		}
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










































