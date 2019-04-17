package com.hxb.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hxb.service.ISomeService;
import com.hxb.service.SomeServiceImpl;
import com.hxb.utils.SystemService;

public class MyTest {
	public static void main(String[] args) {
		//ʹ�ô���
		final ISomeService target = new SomeServiceImpl();
		
		ISomeService service = (ISomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new InvocationHandler() {
			/*֯�룺��ϵͳ���������뵽��ҵ���߼��еĹ���*/
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//ִ�з���֮ǰ����ϵͳ������
				SystemService.doTx();
				
				//ִ����ҵ��
				Object result = method.invoke(target, args);
				
				//ִ�з���֮�����ϵͳ������
				SystemService.doLog();
				return result;
			}
		});
		
		service.doFirst();
		System.out.println("---------------------------");
		service.doSecond();
	}
}





































