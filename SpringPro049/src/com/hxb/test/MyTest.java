package com.hxb.test;

import com.hxb.service.ISomeService;
import com.hxb.service.SomeServiceImpl;

public class MyTest {
	public static void main(String[] args) {
		ISomeService service = new SomeServiceImpl();
		service.doFirst();
		System.out.println("---------------------------");
		service.doSecond();
	}
}





































