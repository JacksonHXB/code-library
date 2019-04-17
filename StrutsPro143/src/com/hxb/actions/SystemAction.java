package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * @author Administrator
 * 系统拦截器
 */
@Namespace("/test")
@ParentPackage("basePackage")//使用拦截器，这里需要继承定义拦截器的包
//@InterceptorRefs(@InterceptorRef(value="permissionStack"))相当于XML中的默认的拦截器<default-interceptor-ref name="permissionStack" />
public class SystemAction {
	
	@Action(value="system", 
			results={@Result(location="/welcome.jsp"), @Result(name="fail",location="/fail.jsp")},
			interceptorRefs=@InterceptorRef(value="permissionStack"))
	public String execute(){
		System.out.println("已经进入系统！");
		return "success";
	}
}







































