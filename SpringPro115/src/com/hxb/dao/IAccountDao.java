package com.hxb.dao;

public interface IAccountDao {
	//���п���
	void insertAccount(String aname, double money);
	
	//�����˻�
	void updateAccount(String aname, double money, boolean isBuy);

}
