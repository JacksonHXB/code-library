package com.hxb.service;

import com.hxb.utils.SystemService;

public class SomeServiceImpl implements ISomeService {

	//主业务与系统级服务出现了混杂
	@Override
	public void doFirst() {
		SystemService.doTx();
		System.out.println("执行doFirst()方法");
		SystemService.doLog();
	}
	
	@Override
	public void doSecond() {
		SystemService.doTx();
		System.out.println("执行doSecond()方法");
		SystemService.doLog();
	}
}































