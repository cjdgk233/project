package com.ex.seatrate;

import java.util.List;

public class SeatRateService {
	
	private SeatRateDAO seatRateDao;
	
	public SeatRateService(SeatRateDAO seatRateDAO) { // 생성자 인젝션
		this.seatRateDao = seatRateDAO;
	}
	
	public List<SeatRateVO> allSeatrate() {
		return seatRateDao.allSeatrate();
	}
	
	public List<SeatRateVO> findSeatrate(int seatRatehall) {
	
		return seatRateDao.findSeatrate(seatRatehall);
	}
	
	public SeatRateVO findSeatRate(int seatRateSeq) {
	return seatRateDao.findSeatRate(seatRateSeq);
	}
	
	
	
	public String findSeatRateName(int seatRateSeq) {
		return seatRateDao.findSeatRateName(seatRateSeq);
	}
	
	public int findSeatRateNum(int seatRateSeq) {
	return seatRateDao.findSeatRateNum(seatRateSeq);
	}
	
	
	
	
//	public List<SeatRateVO> selectSeatrate(int productSeq) {
//		return seatRateDAO.selectSeatrate(productSeq);
//	}
//	
//	public List<SeatRateVO> selectSeatrate3(int productSeq) {
//		return seatRateDAO.selectSeatrate3(productSeq);
//	}
//	
//	public List<SeatRateVO> selectSeatrate2(int productSeq) {
//		return seatRateDAO.selectSeatrate2(productSeq);
//	}
//	
//	public List<SeatRateVO> selectSeatrateS(int productSeq) {
//		return seatRateDAO.selectSeatrateS(productSeq);
//	}
//	
//	
//	
//	
//	
//	public List<SeatRateVO> selectSeatrateByproductSeq(int productSeq) {
//		return seatRateDAO.selectSeatrateByproductSeq(productSeq);
//	}
}