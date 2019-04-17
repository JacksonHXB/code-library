package com.hxb.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.hxb.service.ISomeService;
import com.hxb.service.SomeServiceImpl;
import com.hxb.utils.SystemService;

public class MyTest {
	public static void main(String[] args) {
		//使用代理
		final ISomeService target = new SomeServiceImpl();
		
		ISomeService service = (ISomeService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),new InvocationHandler() {
			/*织入：将系统级服务切入到主业务逻辑中的过程*/
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				//执行方法之前调用系统级服务
				SystemService.doTx();
				
				//执行主业务
				Object result = method.invoke(target, args);
				
				//执行方法之后调用系统级服务
				SystemService.doLog();
				return result;
			}
		});
		
		service.doFirst();
		System.out.println("---------------------------");
		service.doSecond();
	}
}





































