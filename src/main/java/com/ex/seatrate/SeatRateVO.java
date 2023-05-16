package com.ex.seatrate;

public class SeatRateVO {
	private int seatRateSeq;     // 좌석등급SEQ
	private String seatRateName; // 좌석등급명
	private int seatRateNum;   // 좌석수
	private int seatRatePrice; // 가격
	private int seatRatehall;    // 홀SEQ
	
	private String discntName;
	
	private int discntDetail;

	public int getSeatRateSeq() {
		return seatRateSeq;
	}

	public void setSeatRateSeq(int seatRateSeq) {
		this.seatRateSeq = seatRateSeq;
	}

	public String getSeatRateName() {
		return seatRateName;
	}

	public void setSeatRateName(String seatRateName) {
		this.seatRateName = seatRateName;
	}

	public int getSeatRateNum() {
		return seatRateNum;
	}

	public void setSeatRateNum(int seatRateNum) {
		this.seatRateNum = seatRateNum;
	}

	public int getSeatRatePrice() {
		return seatRatePrice;
	}

	public void setSeatRatePrice(int seatRatePrice) {
		this.seatRatePrice = seatRatePrice;
	}

	public int getSeatRatehall() {
		return seatRatehall;
	}

	public void setSeatRatehall(int seatRatehall) {
		this.seatRatehall = seatRatehall;
	}

	public String getDiscntName() {
		return discntName;
	}

	public void setDiscntName(String discntName) {
		this.discntName = discntName;
	}

	public int getDiscntDetail() {
		return discntDetail;
	}

	public void setDiscntDetail(int discntDetail) {
		this.discntDetail = discntDetail;
	}
	
	

}
