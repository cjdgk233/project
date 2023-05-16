package com.ex.seat;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.session.SqlSession;



public class SeatDAO {  // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)
	
	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public SeatDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	

	public SeatVO selectSeat(int seatSeq) {
		
		SeatVO vo= null;
		
		try {
			 vo =sqlSession.selectOne("seat.selectSeat", seatSeq); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public SeatVO findSeat(HashMap<String, Object> map) {
		
		SeatVO vo= null;
		
		try {
			 vo =sqlSession.selectOne("seat.findSeat", map); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
	

	
	
}
