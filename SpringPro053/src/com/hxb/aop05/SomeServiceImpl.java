package com.hxb.aop05;


//Ŀ����
public class SomeServiceImpl implements ISomeService {
	@Override
	public boolean login(String username, String password) throws UserException {
		if(!"beijing".equals(username)){
			throw new UsernameException("�û���������ˣ�");
		}
		if(!"123456".equals(password)){
			throw new PasswordException("����������ˣ�");
		}
		return true;
	}
}































