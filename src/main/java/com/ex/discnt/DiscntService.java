package com.ex.discnt;

import java.util.HashMap;
import java.util.List;




public class DiscntService {
	
	private DiscntDAO  discntDAO;
	
	public DiscntService(DiscntDAO discntDAO) { // 생성자 인젝션
		this.discntDAO = discntDAO;
	}
	
	public DiscntVO findDiscnt(HashMap<String, Object> map) {
		return discntDAO.findDiscnt(map); 
	}
	public int insertDiscnt(DiscntVO vo) {
		return discntDAO.insertDiscnt(vo);
	}

	public List<DiscntVO> allDiscnt() {
		return discntDAO.allDiscnt();
	}
	
	public int getNextDiscntSeq() {
		return discntDAO.getNextDiscntSeq();
	}

	
}