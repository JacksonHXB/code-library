package com.hxb.exception;

/*自定义异常，用来测试显示错误页面，并传递产生错误的JSON数据*/
public class UserNotExistException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public UserNotExistException(){
		super("用户不存在");
	}
}
