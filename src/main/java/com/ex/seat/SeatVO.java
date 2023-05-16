package com.ex.seat;

public class SeatVO {
	private int seatSeq;      // 좌석SEQ
	private String seatFloor; // 층수
	private String seatZone;  // 구역
	private String seatCol;   // 열
	private int seatNum;      // 번호
	private int seatSeatRate; // 좌석등급SEQ(FK)
	
	private String seatRateName;//좌석 등급명

	public int getSeatSeq() {
		return seatSeq;
	}

	public void setSeatSeq(int seatSeq) {
		this.seatSeq = seatSeq;
	}

	public String getSeatFloor() {
		return seatFloor;
	}

	public void setSeatFloor(String seatFloor) {
		this.seatFloor = seatFloor;
	}

	public String getSeatZone() {
		return seatZone;
	}

	public void setSeatZone(String seatZone) {
		this.seatZone = seatZone;
	}

	public String getSeatCol() {
		return seatCol;
	}

	public void setSeatCol(String seatCol) {
		this.seatCol = seatCol;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getSeatSeatRate() {
		return seatSeatRate;
	}

	public void setSeatSeatRate(int seatSeatRate) {
		this.seatSeatRate = seatSeatRate;
	}

	public String getSeatRateName() {
		return seatRateName;
	}

	public void setSeatRateName(String seatRateName) {
		this.seatRateName = seatRateName;
	}

	

	

}
