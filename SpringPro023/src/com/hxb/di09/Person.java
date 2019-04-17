package com.hxb.di09;

@SuppressWarnings("all")
public class Person {
	private String pname;
	private int page;
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPage(int page) {
		this.page = page;
	}
	//使用SPEL表达式可以通过这个获取值
	public String getPname() {
		return pname;
	}
	public int getPage() {
		return page;
	}
	@Override
	public String toString() {
		return "Person [pname=" + pname + ", page=" + page + "]";
	}
	
	public int computeAge(){
		return page > 25 ? 25 : page;
	}
}




























