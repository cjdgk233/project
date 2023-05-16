package com.ex.book;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BookDAO {

	private SqlSession sqlSession;

	public BookDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<BookVO> selectBook(int memberSeq) {
		List<BookVO> list = null;

		try {
			list = sqlSession.selectList("book.selectBook", memberSeq); // ("매퍼파일namespace.selectAll")

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int insertBook(BookVO vo) {
		return sqlSession.insert("book.insertBook", vo);
	}

	public int countBook(HashMap<String, Object> priceMap) {
		return sqlSession.selectOne("book.countBook", priceMap);
	}

	public List<BookVO> selectBookProduct(int productSeq) {
		List<BookVO> list = null;

		try {
			list = sqlSession.selectList("book.selectBookProduct", productSeq); // ("매퍼파일namespace.selectAll")

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BookVO> allBook() {

		List<BookVO> list = null;

		try {
			list = sqlSession.selectList("book.allBook");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public int updateDeleteBook(int bookSeq) {

		int num = 0;

		try {
			num = sqlSession.update("book.updateDeleteBook", bookSeq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return num;

	}

}
