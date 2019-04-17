package com.hxb.actions;

public class SecondAction {
	private String uname;
	private int uage;

	public String execute() {
		System.out.println("uname:" + uname);
		System.err.println("uage:" + uage);
		return "success";
	}
	
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
}



























