package com.hxb.actions;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("all")
public class SomeAction {
	public String execute() {
		ActionContext context = ActionContext.getContext();
		
		//放入context中
		context.put("some", "context_value");
		//放入root中
		context.getValueStack().set("some", "root_value");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("some", "req_value");
		
		return "success";
	}
}




































































































































