package com.hxb.actions;

import com.opensymphony.xwork2.ActionContext;

public class SomeAction {
	public String execute() {
		//获取Servlet API
		//注意：下面的方式获取到的仅仅是这些ServletAPI域空间的，而不是真正的ServletAPI
		
		//向request域空间中放入数据(注意：暂且这样认为放入到了request域空间中数据，但这中理解是不正确的)
		ActionContext.getContext().put("req", "req_value");
		//向Session域空间中放入数据
		ActionContext.getContext().getSession().put("ses", "ses_value");
		//向Application（ServletContext）域空间中放入数据
		ActionContext.getContext().getApplication().put("app", "app_value");
		//这里获取不到response
		
		
		return "success";
	}
}










































