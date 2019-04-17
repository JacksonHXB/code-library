package com.hxb.aop01;

public class SomeServiceImpl implements ISomeService{

	@Override
	public void doFirst() {
		System.out.println("执行doFrist()方法");
	}

	@Override
	public String doSecond() {
		System.out.println("执行doSecond()方法");
		return "asdf";
	}

	@Override
	public void doThrid() {
		System.out.println("执行doThrid()方法" + 3 / 0);
	}
}
