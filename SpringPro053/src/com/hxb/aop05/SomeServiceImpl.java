package com.hxb.aop05;


//目标类
public class SomeServiceImpl implements ISomeService {
	@Override
	public boolean login(String username, String password) throws UserException {
		if(!"beijing".equals(username)){
			throw new UsernameException("用户名输入错了！");
		}
		if(!"123456".equals(password)){
			throw new PasswordException("密码输入错了！");
		}
		return true;
	}
}































