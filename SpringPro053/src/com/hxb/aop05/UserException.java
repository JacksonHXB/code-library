package com.hxb.aop05;

/*异常分两种：
	1）运行时异常, 不进行处理，也可以通过编译。若一个类继承自RunTimeException,则该异常就是运行时异常
	2）编译时异常，受查异常(Checked Exception)，不进行处理，将无法通过编译。若一个类继承自Exception,则该异常就是受查异常
*/
@SuppressWarnings("all")
public class UserException extends Exception{
	public UserException(){
		
	}
	
	public UserException(String message){
		
	}
}











































