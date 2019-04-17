package com.hxb.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("all")
public class SomeAction {
	public String execute() {
		/*从request中获取ValueStack对象*/
		String key = ServletActionContext.STRUTS_VALUESTACK_KEY;
		HttpServletRequest request = ServletActionContext.getRequest();
		ValueStack vs = (ValueStack)request.getAttribute(key);
		
		/*从ValueStack中获取其属性context*/
//		Map<String, Object> context =  vs.getContext();
//		context.put("city", "beijing");
//		
//		/*第二种方式获取属性context*/
//		ActionContext.getContext().put("city", "shanghai");
		
		/*简单的获取值栈*/
		ValueStack vs2 = ActionContext.getContext().getValueStack();
		System.out.println(vs);
		System.out.println(vs2);
		
		return null;
	}
}































