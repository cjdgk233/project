package com.ex.round;

import java.util.HashMap;
import java.util.List;

public class RoundService {

	public RoundDAO roundDao;

	public RoundService(RoundDAO roundDao) {
		this.roundDao = roundDao;
	}

//	public List<RoundVO> listRoundTodayByProduct(int productSeq) {
//		return roundDao.listRoundTodayByProduct(productSeq);
//	}

	public List<RoundVO> listRoundTodayByProduct(String roundDate) {

		System.out.println("서비스");
		return roundDao.listRoundTodayByProduct(roundDate);
	}

	public int insertRound(RoundVO vo) {
		return roundDao.insertRound(vo);
	}
	
	
	public List<RoundVO> selectRound(HashMap<String, Object> map) {
	
		return roundDao.selectRound(map);
	}
	
	public RoundVO findRound(int roundSeq) {
		return roundDao.findRound(roundSeq);
	}
	
	public RoundVO selectRoundOne(HashMap<String, Object> map) {
		return roundDao.selectRoundOne(map);
	}


}
