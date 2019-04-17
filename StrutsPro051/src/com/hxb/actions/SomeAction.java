package com.hxb.actions;

import org.apache.struts2.ServletActionContext;

public class SomeAction {
	public String execute() {
		//获取到真正的ServletAPI
		
		ServletActionContext.getRequest().setAttribute("req", "req_value");
		ServletActionContext.getRequest().getSession().setAttribute("ses", "ses_value");
		ServletActionContext.getServletContext().setAttribute("app", "app_value");
		
		return "success";
	}
}










































