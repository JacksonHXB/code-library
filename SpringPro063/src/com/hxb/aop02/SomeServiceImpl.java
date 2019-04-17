package com.hxb.aop02;


//目标类
public class SomeServiceImpl implements ISomeService {

	@Override
	public void doFirst() {
		System.out.println("执行doFirst()方法");
	}
	
	@Override
	public String doSecond() {
		System.out.println("执行doSecond()方法");
		return "abcd";
	}

	@Override
	public void doThrid() {
		System.out.println("执行doThrid()方法");
	}
}































