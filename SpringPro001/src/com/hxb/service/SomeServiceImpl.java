package com.hxb.service;

public class SomeServiceImpl implements ISomeService {
	private int a = 5;
	//动态代码块比无参构造先执行
	//一个没有成员变量的对象，在堆内存中占有8个字节
	{
		System.out.println("执行动态代码块！a =" + a);
	}
	
	public SomeServiceImpl(){
		System.out.println("创建对象！");
	}

	@Override
	public void doSome() {
		System.out.println("执行doSome()...");
	}
	
}




































