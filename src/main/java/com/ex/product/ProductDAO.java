package com.ex.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ProductDAO {

	private SqlSession sqlSession; // SqlSession 인터페이스 타입의 변수를 만든다.

	public ProductDAO(SqlSession sqlSession) {
		// MemberDAO클래스 객체 생성시 변수 sqlSession을 값을 초기 설정할
		// 수 있는 MemberDAO생성자를 만든다.

		// 생성자는 변수의 개수나 다양한 조건에 따라 여러개 만들 수 잇따.

		this.sqlSession = sqlSession;
	}

	public List<ProductVO> allProduct() {
		List<ProductVO> result = null;// ProductVO객체들을 List에 담은것

		try {
			result = sqlSession.selectList("product.allProduct");
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int registProduct(ProductVO pvo) {

		int num = 0;
		try {
			num = sqlSession.insert("product.registProduct", pvo);

			System.out.println("디에이오 확인");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

	public ProductVO findProduct(int productSeq) {

		ProductVO pvo = null;

		try {
			pvo = sqlSession.selectOne("product.findProduct", productSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pvo;
	}

	public int getNextProductSeq() {

		int num = 0;

		try {
			num = sqlSession.selectOne("product.getNextProductSeq");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	public int selectHallSeq(int productSeq) {

		int num = 0;

		try {
			num = sqlSession.selectOne("product.selectHallSeq", productSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;
	}

	public ProductVO findProductRecode(int productSeq) {

		ProductVO vo = null;

		try {
			vo = sqlSession.selectOne("product.findProductRecode", productSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}

	public int getTotal(Map<String, Object> map) {
		return sqlSession.selectOne("product.getTotal", map);
	}

//	
	public List<ProductVO> selectList(Map<String, Object> map) {
		return sqlSession.selectList("product.selectList", map);
	}

	public List<ProductVO> fineProductHall(int hallSeq) {

		List<ProductVO> list = null;

		try {
			list = sqlSession.selectList("product.fineProductHall", hallSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int updateProduct(ProductVO vo) {

		int num = 0;

		try {
			num = sqlSession.update("product.updateProduct",vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int deleteProdut(int productSeq) {
		
		int num = 0;
		
		try {
			num= sqlSession.delete("product.deleteProdut", productSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}