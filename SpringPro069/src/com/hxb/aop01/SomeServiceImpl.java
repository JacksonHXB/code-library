package com.hxb.aop01;

public class SomeServiceImpl implements ISomeService{

	@Override
	public void doFirst() {
		System.out.println("ִ��doFrist()����");
	}

	@Override
	public String doSecond() {
		System.out.println("ִ��doSecond()����");
		return "asdf";
	}

	@Override
	public void doThrid() {
		System.out.println("ִ��doThrid()����" + 3 / 0);
	}
}
