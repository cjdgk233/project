package com.ex.seat;

import java.util.HashMap;
import java.util.List;




public class SeatService {
	
	private SeatDAO seatDao;
	
	public SeatService(SeatDAO seatDao) { // 생성자 인젝션
		this.seatDao = seatDao;
	}
	
	
	public SeatVO selectSeat(int seatSeq) {
		
		return seatDao.selectSeat(seatSeq);
	}
	
	public SeatVO findSeat(HashMap<String, Object> map) {
		return seatDao.findSeat(map);
	}

	
}