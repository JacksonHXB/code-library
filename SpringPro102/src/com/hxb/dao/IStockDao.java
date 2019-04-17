package com.hxb.dao;

public interface IStockDao {

	//股票开户
	void insertStock(String sname, int amount);

	//更新账户
	void updateStock(String sname, int amount, boolean isBuy);

}
