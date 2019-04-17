package com.hxb.aop02;

public class SomeServiceImpl implements ISomeService{

	//主业务1
	@Override
	public void doFirst() {
		System.out.println("执行doFrist()方法");
	}

	//主业务2
	@Override
	public String doSecond() {
		System.out.println("执行doSecond()方法");
		return "asdf";
	}

	//主业务3
	@Override
	public void doThrid() {
		System.out.println("执行doThrid()方法" + 3 / 0);
	}
}
