package com.hxb.aop02;


//Ŀ����
public class SomeServiceImpl implements ISomeService {

	@Override
	public void doFirst() {
		System.out.println("ִ��doFirst()����");
	}
	
	@Override
	public String doSecond() {
		System.out.println("ִ��doSecond()����");
		return "abcd";
	}

	@Override
	public void doThrid() {
		System.out.println("ִ��doThrid()����");
	}
}































