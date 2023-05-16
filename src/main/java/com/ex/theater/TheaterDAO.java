package com.ex.theater;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class TheaterDAO {

	private SqlSession sqlSession; // SqlSession 인터페이스 타입의 변수를 만든다.

	public TheaterDAO(SqlSession sqlSession) {
		// MemberDAO클래스 객체 생성시 변수 sqlSession을 값을 초기 설정할
		// 수 있는 MemberDAO생성자를 만든다.

		// 생성자는 변수의 개수나 다양한 조건에 따라 여러개 만들 수 잇따.

		this.sqlSession = sqlSession;
	}

	public int inputTheater(TheaterVO vo) {

		int num = 0;
		try {
			num = sqlSession.insert("theater.inputTheater", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public int getTheaterSeq() {
		return sqlSession.selectOne("theater.getTheaterSeq");
	}

	public List<TheaterVO> allTheater() {

		List<TheaterVO> list = null;

		try {
			list = sqlSession.selectList("theater.allTheater");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public TheaterVO findTheater(int productHall) {

		TheaterVO vo = null;

		try {
			vo = sqlSession.selectOne("theater.findTheater", productHall);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	

}