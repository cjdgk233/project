package com.ex.seatrate;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ex.pdType.PdTypeVO;

public class SeatRateDAO {  // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)
	
	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public SeatRateDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	public List<SeatRateVO> allSeatrate() {

		 List<SeatRateVO> seatrateList= null;
			try {
				seatrateList=sqlSession.selectList("seatrate.allSeatrate");
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return seatrateList;
			
		}
	
	public List<SeatRateVO> findSeatrate(int seatRatehall) {

		 List<SeatRateVO> seatrateList= null;
			try {
				seatrateList=sqlSession.selectList("seatrate.findSeatrate",seatRatehall);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return seatrateList;
			
		}
	
	
	//seatRateSeq로 레코드 찾는 메서드
	
	public SeatRateVO findSeatRate(int seatRateSeq) {

		SeatRateVO srvo= null;
			try {
				srvo=sqlSession.selectOne("seatrate.findSeatRate",seatRateSeq);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return srvo;
			
		}
	
	public String findSeatRateName(int seatRateSeq) {

		String name ="";
			try {
				name=sqlSession.selectOne("seatrate.findSeatRateName",seatRateSeq);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return name;
			
		}
	
	public int findSeatRateNum(int seatRateSeq) {

		int num = 0;
			try {
				num=sqlSession.selectOne("seatrate.findSeatRateNum",seatRateSeq);
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			
			return num;
			
		}
	
	
	
	
	

}
