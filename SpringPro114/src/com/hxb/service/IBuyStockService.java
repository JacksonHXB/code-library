package com.hxb.service;

public interface IBuyStockService {
	//����
	void openAccount(String aname, double money);
	
	//��Ʊ����
	void openStock(String sname, int amount);
	
	//�����Ʊ:�������˻����Ǯ������������Ĺ�Ʊ
	void buyStock(String aname, double money, String sname, int amount) throws BuyStockException;
}
