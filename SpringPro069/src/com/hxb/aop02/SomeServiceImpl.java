package com.hxb.aop02;

public class SomeServiceImpl implements ISomeService{

	//��ҵ��1
	@Override
	public void doFirst() {
		System.out.println("ִ��doFrist()����");
	}

	//��ҵ��2
	@Override
	public String doSecond() {
		System.out.println("ִ��doSecond()����");
		return "asdf";
	}

	//��ҵ��3
	@Override
	public void doThrid() {
		System.out.println("ִ��doThrid()����" + 3 / 0);
	}
}
