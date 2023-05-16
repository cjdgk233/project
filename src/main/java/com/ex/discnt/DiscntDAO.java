package com.ex.discnt;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.session.SqlSession;



public class DiscntDAO {  // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)
	
	private SqlSession sqlSession;  // sqlSession이라는 변수선언
	
	public DiscntDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}
	
	
	public DiscntVO findDiscnt(HashMap<String, Object> map) {
		DiscntVO vo = null;
		
		try {
			vo = sqlSession.selectOne("discnt.findDiscnt", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	public int insertDiscnt(DiscntVO vo) {
		
		int num=0;
		
		try {
			num= sqlSession.insert("discnt.insertDiscnt", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return num;
	}
	
	public List<DiscntVO> allDiscnt() {
		
		List<DiscntVO> list = null;
		
		try {
			list = sqlSession.selectList("discnt.allDiscnt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int getNextDiscntSeq() {
		return sqlSession.selectOne("discnt.getNextDiscntSeq");
	}
	

}