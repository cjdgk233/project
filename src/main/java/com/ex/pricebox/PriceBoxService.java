package com.ex.pricebox;

import java.util.HashMap;
import java.util.List;




public class PriceBoxService {
	
	private PriceBoxDAO  priceBoxDao;
	
	public PriceBoxService(PriceBoxDAO  priceBoxDao) { // 생성자 인젝션
		this.priceBoxDao = priceBoxDao;
	}
	public int insertPriceBox(PriceBoxVO vo) {
		return priceBoxDao.insertPriceBox(vo);
	}
	public PriceBoxVO findPriceBox(int priceBoxProduct) {
		return priceBoxDao.findPriceBox(priceBoxProduct);
	}
	
	
	


	
}