package com.ex.pricebox;

import org.apache.ibatis.session.SqlSession;

public class PriceBoxDAO { // DAO는 mapper파일을 불러오는 역할을 한다 (Sql세션 필요함)

	private SqlSession sqlSession; // sqlSession이라는 변수선언

	public PriceBoxDAO(SqlSession sqlSession) { // 생성자 인젝션
		this.sqlSession = sqlSession;
	}

	public int insertPriceBox(PriceBoxVO vo) {
		int num = 0;

		try {
			num = sqlSession.insert("pricebox.insertPriceBox", vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public PriceBoxVO findPriceBox(int priceBoxProduct) {

		PriceBoxVO vo = null;

		try {
			vo = sqlSession.selectOne("pricebox.findPriceBox", priceBoxProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

}