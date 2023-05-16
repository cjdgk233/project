package com.ex.hall;

import java.util.List;

import org.apache.ibatis.session.SqlSession;






public class HallDAO {

	private SqlSession sqlSession; // SqlSession 인터페이스 타입의 변수를 만든다.

	public HallDAO(SqlSession sqlSession) {
		//MemberDAO클래스 객체 생성시 변수 sqlSession을 값을 초기 설정할
		//수 있는 MemberDAO생성자를 만든다.
		
		//생성자는 변수의 개수나 다양한 조건에 따라 여러개 만들 수 잇따.
		
		this.sqlSession = sqlSession;
	}
	
	
	public List<HallVO> allHall() {
		
		List<HallVO> hallList= null;
		try {
			hallList = sqlSession.selectList("hall.allHall");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return hallList;
		
	}
	
	public int getHallSeq() {
		return sqlSession.selectOne("hall.getHallSeq");
	}
	
	
	public int insertHall(HallVO vo) {
		int num=0;
		try {
			num = sqlSession.insert("hall.insertHall", vo);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
public List<HallVO> findHall(int theaterSeq) {
		
		List<HallVO> hallList= null;
		try {
			hallList = sqlSession.selectList("hall.findHall",theaterSeq);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return hallList;
		
	}
	
	public HallVO findHallWithHallSeq(int productHall) {
		
		HallVO vo = null;
		
		try {
			vo = sqlSession.selectOne("hall.findHallWithHallSeq", productHall);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
		
	}
	
	public HallVO findOneHall(int hallTheater) {
		
		HallVO hvo= null;
		try {
			hvo = sqlSession.selectOne("hall.findOneHall",hallTheater);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return hvo;
		
	}
	
	
	
	

}