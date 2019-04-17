package com.hxb.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("all")
public class SomeAction {
	public String execute() {
		/*从request中获取ValueStack对象*/
		String key = ServletActionContext.STRUTS_VALUESTACK_KEY;
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs = (ValueStack)request.getAttribute(key);
		return "success";
	}
}
