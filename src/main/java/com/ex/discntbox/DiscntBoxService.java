package com.ex.discntbox;

import java.util.HashMap;
import java.util.List;




public class DiscntBoxService {
	
	private DiscntBoxDAO  discntBoxDao;
	
	public DiscntBoxService(DiscntBoxDAO discntBoxDao) { // 생성자 인젝션
		this.discntBoxDao = discntBoxDao;
	}
	
	
	
	
	public DiscntBoxVO findDiscntSeq(int productSeq) {
		return discntBoxDao.findDiscntSeq(productSeq);
	}
	
	public int insertDiscntBox(DiscntBoxVO vo) {
		return discntBoxDao.insertDiscntBox(vo);
	}
	


	
}