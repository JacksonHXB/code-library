package com.hxb.service;

public interface IBuyStockService {
	//开户
	void openAccount(String aname, double money);
	
	//股票开户
	void openStock(String sname, int amount);
	
	//购买股票:用银行账户里的钱购买剁手数量的股票
	void buyStock(String aname, double money, String sname, int amount) throws BuyStockException;
}
