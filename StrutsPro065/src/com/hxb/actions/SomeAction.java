package com.hxb.actions;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

@SuppressWarnings("all")
public class SomeAction {
	public String execute() {
		ActionContext contextMap = ActionContext.getContext();
		
		contextMap.put("some", "some_value");
		contextMap.getSession().put("ses", "ses_value");
		contextMap.getApplication().put("app", "app_value");
		
		return "success";
	}
}





















































































