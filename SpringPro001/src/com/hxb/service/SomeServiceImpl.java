package com.hxb.service;

public class SomeServiceImpl implements ISomeService {
	private int a = 5;
	//��̬�������޲ι�����ִ��
	//һ��û�г�Ա�����Ķ����ڶ��ڴ���ռ��8���ֽ�
	{
		System.out.println("ִ�ж�̬����飡a =" + a);
	}
	
	public SomeServiceImpl(){
		System.out.println("��������");
	}

	@Override
	public void doSome() {
		System.out.println("ִ��doSome()...");
	}
	
}




































