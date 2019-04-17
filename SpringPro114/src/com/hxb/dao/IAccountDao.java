package com.hxb.dao;

public interface IAccountDao {
	//银行开户
	void insertAccount(String aname, double money);
	
	//更新账户
	void updateAccount(String aname, double money, boolean isBuy);

}
