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
		System.out.println("ִ��doFirst()!");
		return "success";
	}
	public String doSecond() {
		System.out.println("ִ��doSecond()!");
		return "success";
	}
	
	/*������֤*/
	@Override
	public void validate() {
		if(name == null || "".equals(name.trim())){
			//FiledErrors.size()>0˵��������֤ʧ�ܵ���Ϣ�����Զ���ת��input��ͼ
			this.addFieldError("name", "�û�������Ϊ�գ�");
		}
		if(mobile == null || "".equals(mobile.trim())){
			this.addFieldError("mobile", "�ֻ��Ų���Ϊ�գ�");
		}else if(!Pattern.matches("^1[34578]\\d{9}$", mobile)){
			this.addFieldError("mobile", "�ֻ��Ÿ�ʽ����ȷ��");
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










































