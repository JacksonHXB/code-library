package com.hxb.dao;

public interface IStockDao {

	//��Ʊ����
	void insertStock(String sname, int amount);

	//�����˻�
	void updateStock(String sname, int amount, boolean isBuy);

}
