package com.hxb.service;

import com.hxb.utils.SystemService;

public class SomeServiceImpl implements ISomeService {

	//��ҵ����ϵͳ����������˻���
	@Override
	public void doFirst() {
		SystemService.doTx();
		System.out.println("ִ��doFirst()����");
		SystemService.doLog();
	}
	
	@Override
	public void doSecond() {
		SystemService.doTx();
		System.out.println("ִ��doSecond()����");
		SystemService.doLog();
	}
}































