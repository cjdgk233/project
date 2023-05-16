package com.ex.book;

import java.util.HashMap;
import java.util.List;

public class BookService {

	public BookDAO bookDao;
	
	public BookService(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	public List<BookVO> selectBook(int memberSeq) {
		return bookDao.selectBook(memberSeq);
	}
	
	public int insertBook(BookVO vo) {
		return bookDao.insertBook(vo);
	}


	public int countBook(HashMap<String, Object> priceMap) {
		// TODO Auto-generated method stub
		return bookDao.countBook(priceMap);
	}
	
	public List<BookVO> selectBookProduct(int productSeq) {
	return bookDao.selectBookProduct(productSeq);
	}
	
	public List<BookVO> allBook() {
		return bookDao.allBook();
	}

	public int updateDeleteBook(int bookSeq) {
		return bookDao.updateDeleteBook(bookSeq);
	}

	
	
}
