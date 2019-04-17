package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/test")//如果只有一个参数，可以省略不写
@ParentPackage("struts-default")
public class LoginAction {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//如果name是默认属性值，可以省略不写,如果results只有一个值，可以省略大括号
	@Action(value="login", results=@Result(type="redirectAction", location="second", params={"uname","%{name}","uage","%{age}"}))
	public String execute(){
		System.out.println("执行LoginAction中的execute()!");
		return "success";
	}
}

































































