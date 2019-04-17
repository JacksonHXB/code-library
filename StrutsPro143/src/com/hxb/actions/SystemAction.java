package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * @author Administrator
 * ϵͳ������
 */
@Namespace("/test")
@ParentPackage("basePackage")//ʹ����������������Ҫ�̳ж����������İ�
//@InterceptorRefs(@InterceptorRef(value="permissionStack"))�൱��XML�е�Ĭ�ϵ�������<default-interceptor-ref name="permissionStack" />
public class SystemAction {
	
	@Action(value="system", 
			results={@Result(location="/welcome.jsp"), @Result(name="fail",location="/fail.jsp")},
			interceptorRefs=@InterceptorRef(value="permissionStack"))
	public String execute(){
		System.out.println("�Ѿ�����ϵͳ��");
		return "success";
	}
}







































