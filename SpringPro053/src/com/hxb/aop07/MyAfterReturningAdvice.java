package com.hxb.aop07;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

/*后置通知*/
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	//在目标方法执行之后
	//returnValue:目标方法的返回值
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("执行后置通知方法！returnVlaue=" + returnValue);
		//测试不能影响主业务的结果
		if(returnValue != null){
			returnValue = ((String)returnValue).toUpperCase();
			System.out.println("修改过后的值returnVlaue：" + returnValue);
		}
	}
}


































