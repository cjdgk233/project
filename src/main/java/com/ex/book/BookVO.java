package com.ex.book;

import java.sql.Date;

public class BookVO {
	private int bookSeq;  // 예매내역SEQ
	private int bookFee;  // 예매수수료
	private int bookShippingFee;  // 배송료
	private String bookReceive;   // 수령방법
	private int bookTotalDiscnt;  // 총할인금액
	private int bookTotalPayment; // 총결제금액
	private String bookAgreePersonal; // 개인정보 동의여부
	private String bookAgreeCxlFee;   // 취소기한및수수료 동의여부
	private String bookStatus;  // 예약상태
	private int bookPayNum;     // 결제 승인번호
	private String bookPayCard; // 결제카드사
	private Date bookPayDate;   // 결제일시
	private String bookPayStatus; // 결제상태
	private Date bookCxlDate; // 결제취소일시
	private int bookMember;   // 회원정보SEQ(FK)
	private int bookProduct;  // 작품SEQ(FK)
	private int bookSeat;     // 좌석SEQ(FK)
	private Date bookProductDate; //관람일시
	private String bookProductName; //작품이름
	private int bookRound; //예매회차
	private int bookSeatRate; //예매 좌석 등급
	
	private String productName;
//	private int bookDiscntUsed; // 할인적용SEQ(FK)
//	private int bookCpnUsed;    // 쿠폰적용SEQ(FK)
//	private int bookRefund;     // 환불내역SEQ(FK)
	
	private Date bookCxLastDate; //취소 기한

	public int getBookSeq() {
		return bookSeq;
	}

	public void setBookSeq(int bookSeq) {
		this.bookSeq = bookSeq;
	}

	public int getBookFee() {
		return bookFee;
	}

	public void setBookFee(int bookFee) {
		this.bookFee = bookFee;
	}

	public int getBookShippingFee() {
		return bookShippingFee;
	}

	public void setBookShippingFee(int bookShippingFee) {
		this.bookShippingFee = bookShippingFee;
	}

	public String getBookReceive() {
		return bookReceive;
	}

	public void setBookReceive(String bookReceive) {
		this.bookReceive = bookReceive;
	}

	public int getBookTotalDiscnt() {
		return bookTotalDiscnt;
	}

	public void setBookTotalDiscnt(int bookTotalDiscnt) {
		this.bookTotalDiscnt = bookTotalDiscnt;
	}

	public int getBookTotalPayment() {
		return bookTotalPayment;
	}

	public void setBookTotalPayment(int bookTotalPayment) {
		this.bookTotalPayment = bookTotalPayment;
	}

	public String getBookAgreePersonal() {
		return bookAgreePersonal;
	}

	public void setBookAgreePersonal(String bookAgreePersonal) {
		this.bookAgreePersonal = bookAgreePersonal;
	}

	public String getBookAgreeCxlFee() {
		return bookAgreeCxlFee;
	}

	public void setBookAgreeCxlFee(String bookAgreeCxlFee) {
		this.bookAgreeCxlFee = bookAgreeCxlFee;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public int getBookPayNum() {
		return bookPayNum;
	}

	public void setBookPayNum(int bookPayNum) {
		this.bookPayNum = bookPayNum;
	}

	public String getBookPayCard() {
		return bookPayCard;
	}

	public void setBookPayCard(String bookPayCard) {
		this.bookPayCard = bookPayCard;
	}

	public Date getBookPayDate() {
		return bookPayDate;
	}

	public void setBookPayDate(Date bookPayDate) {
		this.bookPayDate = bookPayDate;
	}

	public String getBookPayStatus() {
		return bookPayStatus;
	}

	public void setBookPayStatus(String bookPayStatus) {
		this.bookPayStatus = bookPayStatus;
	}

	public Date getBookCxlDate() {
		return bookCxlDate;
	}

	public void setBookCxlDate(Date bookCxlDate) {
		this.bookCxlDate = bookCxlDate;
	}

	public int getBookMember() {
		return bookMember;
	}

	public void setBookMember(int bookMember) {
		this.bookMember = bookMember;
	}

	public int getBookProduct() {
		return bookProduct;
	}

	public void setBookProduct(int bookProduct) {
		this.bookProduct = bookProduct;
	}

	public int getBookSeat() {
		return bookSeat;
	}

	public void setBookSeat(int bookSeat) {
		this.bookSeat = bookSeat;
	}

	public Date getBookProductDate() {
		return bookProductDate;
	}

	public void setBookProductDate(Date bookProductDate) {
		this.bookProductDate = bookProductDate;
	}

	public String getBookProductName() {
		return bookProductName;
	}

	public void setBookProductName(String bookProductName) {
		this.bookProductName = bookProductName;
	}

	public int getBookRound() {
		return bookRound;
	}

	public void setBookRound(int bookRound) {
		this.bookRound = bookRound;
	}

	public int getBookSeatRate() {
		return bookSeatRate;
	}

	public void setBookSeatRate(int bookSeatRate) {
		this.bookSeatRate = bookSeatRate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getBookCxLastDate() {
		return bookCxLastDate;
	}

	public void setBookCxLastDate(Date bookCxLastDate) {
		this.bookCxLastDate = bookCxLastDate;
	}
	

	
}