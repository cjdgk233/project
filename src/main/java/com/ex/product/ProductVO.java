package com.ex.product;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private int productSeq;        // 작품SEQ
	private String productImage;   // 포스터 이미지명
	private String productName;    // 작품명
	private String productRuntime; // 관람(상영)시간
	private Date productPeriodBegin; // 공연시작일
	private Date productPeriodEnd;   // 공연종료일
	private String productRate;      // 관람등급
	private String productDetail;    // 상세정보
	private int productPointAvg;     // 별점합계
	private String productCxlInfo;   // 예매/취소안내
	private int productCxlDeadline;  // 취소기한
	private int productCxlFee; // 취소수수료
	private int productPdType; // 공연종류SEQ
	private int productHall;   // 공연홀SEQ
	private int productArea;   // 지역SEQ

	
	
	/* 아영 */
	private String hallName; // 공연홀명
	private String hallTel;  // 대표번호
	private String hallAddress; // 주소
	private double hallLatitude; //위도
	private double hallLongitude; //경도
	

	
	private int priceBoxSeatRate1; //좌석 등급
	private int seatRatePrice1; //좌석 가격
	
	private int priceBoxSeatRate2;
	private int seatRatePrice2;
	
	private int priceBoxSeatRate3;
	private int seatRatePrice3;
	
	
	
	
	private String pdTypeName;




	public int getProductSeq() {
		return productSeq;
	}




	public void setProductSeq(int productSeq) {
		this.productSeq = productSeq;
	}




	public String getProductImage() {
		return productImage;
	}




	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public String getProductRuntime() {
		return productRuntime;
	}




	public void setProductRuntime(String productRuntime) {
		this.productRuntime = productRuntime;
	}




	public Date getProductPeriodBegin() {
		return productPeriodBegin;
	}




	public void setProductPeriodBegin(Date productPeriodBegin) {
		this.productPeriodBegin = productPeriodBegin;
	}




	public Date getProductPeriodEnd() {
		return productPeriodEnd;
	}




	public void setProductPeriodEnd(Date productPeriodEnd) {
		this.productPeriodEnd = productPeriodEnd;
	}




	public String getProductRate() {
		return productRate;
	}




	public void setProductRate(String productRate) {
		this.productRate = productRate;
	}




	public String getProductDetail() {
		return productDetail;
	}




	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}




	public int getProductPointAvg() {
		return productPointAvg;
	}




	public void setProductPointAvg(int productPointAvg) {
		this.productPointAvg = productPointAvg;
	}




	public String getProductCxlInfo() {
		return productCxlInfo;
	}




	public void setProductCxlInfo(String productCxlInfo) {
		this.productCxlInfo = productCxlInfo;
	}




	public int getProductCxlDeadline() {
		return productCxlDeadline;
	}




	public void setProductCxlDeadline(int productCxlDeadline) {
		this.productCxlDeadline = productCxlDeadline;
	}




	public int getProductCxlFee() {
		return productCxlFee;
	}




	public void setProductCxlFee(int productCxlFee) {
		this.productCxlFee = productCxlFee;
	}




	public int getProductPdType() {
		return productPdType;
	}




	public void setProductPdType(int productPdType) {
		this.productPdType = productPdType;
	}




	public int getProductHall() {
		return productHall;
	}




	public void setProductHall(int productHall) {
		this.productHall = productHall;
	}




	public int getProductArea() {
		return productArea;
	}




	public void setProductArea(int productArea) {
		this.productArea = productArea;
	}




	public String getHallName() {
		return hallName;
	}




	public void setHallName(String hallName) {
		this.hallName = hallName;
	}




	public String getHallTel() {
		return hallTel;
	}




	public void setHallTel(String hallTel) {
		this.hallTel = hallTel;
	}




	public String getHallAddress() {
		return hallAddress;
	}




	public void setHallAddress(String hallAddress) {
		this.hallAddress = hallAddress;
	}




	public double getHallLatitude() {
		return hallLatitude;
	}




	public void setHallLatitude(double hallLatitude) {
		this.hallLatitude = hallLatitude;
	}




	public double getHallLongitude() {
		return hallLongitude;
	}




	public void setHallLongitude(double hallLongitude) {
		this.hallLongitude = hallLongitude;
	}




	public int getPriceBoxSeatRate1() {
		return priceBoxSeatRate1;
	}




	public void setPriceBoxSeatRate1(int priceBoxSeatRate1) {
		this.priceBoxSeatRate1 = priceBoxSeatRate1;
	}




	public int getSeatRatePrice1() {
		return seatRatePrice1;
	}




	public void setSeatRatePrice1(int seatRatePrice1) {
		this.seatRatePrice1 = seatRatePrice1;
	}




	public int getPriceBoxSeatRate2() {
		return priceBoxSeatRate2;
	}




	public void setPriceBoxSeatRate2(int priceBoxSeatRate2) {
		this.priceBoxSeatRate2 = priceBoxSeatRate2;
	}




	public int getSeatRatePrice2() {
		return seatRatePrice2;
	}




	public void setSeatRatePrice2(int seatRatePrice2) {
		this.seatRatePrice2 = seatRatePrice2;
	}




	public int getPriceBoxSeatRate3() {
		return priceBoxSeatRate3;
	}




	public void setPriceBoxSeatRate3(int priceBoxSeatRate3) {
		this.priceBoxSeatRate3 = priceBoxSeatRate3;
	}




	public int getSeatRatePrice3() {
		return seatRatePrice3;
	}




	public void setSeatRatePrice3(int seatRatePrice3) {
		this.seatRatePrice3 = seatRatePrice3;
	}




	public String getPdTypeName() {
		return pdTypeName;
	}




	public void setPdTypeName(String pdTypeName) {
		this.pdTypeName = pdTypeName;
	}






}

