package com.ex.common;

public class Paging {

	private final int perPage = 10; // 페이지당 글 갯수
	private int pageCount; // 총 페이지갯수
	private int boardCount; // 총 글의 갯수
	private int first; // 현재 페이지의 첫 글의 번호
	private int last; //현재 페이지의 끝글의 번호
	private final int perSection = 10; //페이지갯수
	private int begin; // 시작페이지
	private int end; //끝페이지
	private int section; // 범위 번호
	private int page; //현재 페이지
	
	private boolean prev; //이전
	private boolean next; //다음
	
	
	public Paging(int page,int boardCount) {
		this.page = page;
		this.boardCount = boardCount;
		
		//총페이지
		pageCount = boardCount / perPage;
		pageCount += (boardCount % perPage) == 0 ? 0 : 1;
		
		//시작글의 번호
		first = (page - 1) * perPage + 1;
		//끝글 번호
		last = first + perPage - 1;
		
		section = (page - 1) / perSection;
		//시작페이지
		begin = perSection * section + 1;
		//끝페이지
		end = begin + perSection - 1;
		end = end > pageCount ? pageCount : end;
		
		prev = section != 0;
		next = boardCount > perPage * end;
	}
	
	
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getPerPage() {
		return perPage;
	}
	public int getPerSection() {
		return perSection;
	}
	
	
	
}
