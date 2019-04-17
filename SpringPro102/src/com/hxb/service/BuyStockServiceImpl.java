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
		//购买股票银行账户减去金额
		adao.updateAccount(aname, money, isBuy);
		
		//这里手动抛出异常，检测如果出现异常，交易是否会影响账户；这里需要用事务回滚
		if(1 == 1){
			throw new BuyStockException("购买股票异常");
		}
		
		//购买股票银行账户增加金额
		sdao.updateStock(sname, amount, isBuy);
	}
}



































