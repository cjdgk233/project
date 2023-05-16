package com.ex.discntbox;

import org.apache.ibatis.session.SqlSession;



public class DiscntBoxDAO {  // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)
	
	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public DiscntBoxDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	
	
	public DiscntBoxVO findDiscntSeq(int productSeq) {
		DiscntBoxVO vo= null;
		
		try {
			vo= sqlSession.selectOne("discntbox.findDiscntSeq", productSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public int insertDiscntBox(DiscntBoxVO vo) {
		int num=0;
		
		try {
			num= sqlSession.insert("discntbox.insertDiscntBox", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	

}