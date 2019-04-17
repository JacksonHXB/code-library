package com.hxb.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Namespace(value="/test")
@ParentPackage(value="struts-default")
public class SecondAction {
	private String uname;
	private int uage;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	
	@Action(value="second", results={@Result(name="success", type="dispatcher", location="/welcome.jsp")})
	public String execute(){
		System.out.println("Ö´ÐÐSecondActionÖÐµÄexecute()!");
		System.out.println("uname:" + uname);
		System.out.println("uage:" + uage);
		return "success";
	}
}







































