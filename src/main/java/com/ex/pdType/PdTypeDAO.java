package com.ex.pdType;

import java.util.List;

import org.apache.ibatis.session.SqlSession;






public class PdTypeDAO {

	private SqlSession sqlSession; // SqlSession 인터페이스 타입의 변수를 만든다.

	public PdTypeDAO(SqlSession sqlSession) {
		//MemberDAO클래스 객체 생성시 변수 sqlSession을 값을 초기 설정할
		//수 있는 MemberDAO생성자를 만든다.
		
		//생성자는 변수의 개수나 다양한 조건에 따라 여러개 만들 수 잇따.
		
		this.sqlSession = sqlSession;
	}
	
	
	public List<PdTypeVO> allPdtype() {
		
		List<PdTypeVO > pdtypeList= null;
		try {
			pdtypeList=	sqlSession.selectList("pdtype.allPdtype");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return pdtypeList;
		
	}
	
	

}