package com.hxb.actions;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

//实现接口
public class SomeAction implements RequestAware, SessionAware, ApplicationAware{
	
	//定义成员成员变量用于接收
	private Map<String, Object> req;
	private Map<String, Object> ses;
	private Map<String, Object> app;
	
	public String execute() {
		//通过接口方式获取Servlet API
		
		req.put("req", "req_value");
		ses.put("ses", "ses_value");
		app.put("app", "app_value");
		
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.req = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.ses = session;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.app = application;
	}
}










































