package com.ex.round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class RoundDAO {

	public SqlSession sqlSession;

	public RoundDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<RoundVO> listRoundTodayByProduct(String roundDate) {

		System.out.println("디에이오?");
		return sqlSession.selectList("round.listRoundTodayByProduct", roundDate);
	}

	public List<Map<String, Object>> getRoundList(String date) {
		List<Map<String, Object>> checkList = new ArrayList<Map<String, Object>>();
		checkList = sqlSession.selectList("round.getRoundList", date);
		return checkList;
	}

	public int insertRound(RoundVO vo) {

		int num = 0;
		try {
			num = sqlSession.insert("round.insertRound", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	public List<RoundVO> selectRound(HashMap<String, Object> map) {

		List<RoundVO> list = null;

		try {
			list = sqlSession.selectList("round.selectRound", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public RoundVO findRound(int roundSeq) {

		RoundVO vo =null;
		
		try {
			vo = sqlSession.selectOne("round.findRound", roundSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}
	
	public RoundVO selectRoundOne(HashMap<String, Object> map) {

		RoundVO vo =null;
		
		try {
			vo = sqlSession.selectOne("round.selectRoundOne", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}
	
	
	
	

}
