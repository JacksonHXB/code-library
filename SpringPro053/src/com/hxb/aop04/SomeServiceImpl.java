package com.hxb.aop04;


//Ŀ����
public class SomeServiceImpl implements ISomeService {

	@Override
	public void doFirst() {
		System.out.println("ִ��doFirst()����" + 3/0);
	}
	
	@Override
	public String doSecond() {
		System.out.println("ִ��doSecond()����");
		return "abcd";
	}
}































