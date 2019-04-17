package com.hxb.service;

import com.hxb.dao.IAccountDao;
import com.hxb.dao.IStockDao;

@SuppressWarnings("all")
public class BuyStockServiceImpl implements IBuyStockService{
	private IAccountDao adao;
	private IStockDao sdao;

	
	public void setAdao(IAccountDao adao) {
		this.adao = adao;
	}
	public void setSdao(IStockDao sdao) {
		this.sdao = sdao;
	}
	
	
	@Override
	public void openAccount(String aname, double money) {
		adao.insertAccount(aname, money);
	}
	
	@Override
	public void openStock(String sname, int amount) {
		sdao.insertStock(sname, amount);
	}
	
	@Override
	public void buyStock(String aname, double money, String sname, int amount) throws BuyStockException {
		boolean isBuy = true;
		//�����Ʊ�����˻���ȥ���
		adao.updateAccount(aname, money, isBuy);
		
		//�����ֶ��׳��쳣�������������쳣�������Ƿ��Ӱ���˻���������Ҫ������ع�
		if(1 == 1){
			throw new BuyStockException("�����Ʊ�쳣");
		}
		
		//�����Ʊ�����˻����ӽ��
		sdao.updateStock(sname, amount, isBuy);
	}
}



































