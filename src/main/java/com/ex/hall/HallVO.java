package com.ex.hall;

public class HallVO {
	//공연홀마다 존재하는 좌석 등급을 정해 놓는다.
	
	private int hallSeq;     // 공연홀SEQ
	private String hallName; // 공연홀명
	private String hallTel;  // 대표번호
	private int hallTheater;     
	
	private int hallSeatRate1;
	private int hallSeatRate2;
	private int hallSeatRate3;
	
	private String seatRateName;

	
	public HallVO() {
	}


	public int getHallSeq() {
		return hallSeq;
	}


	public void setHallSeq(int hallSeq) {
		this.hallSeq = hallSeq;
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


	public int getHallTheater() {
		return hallTheater;
	}


	public void setHallTheater(int hallTheater) {
		this.hallTheater = hallTheater;
	}


	public int getHallSeatRate1() {
		return hallSeatRate1;
	}


	public void setHallSeatRate1(int hallSeatRate1) {
		this.hallSeatRate1 = hallSeatRate1;
	}


	public int getHallSeatRate2() {
		return hallSeatRate2;
	}


	public void setHallSeatRate2(int hallSeatRate2) {
		this.hallSeatRate2 = hallSeatRate2;
	}


	public int getHallSeatRate3() {
		return hallSeatRate3;
	}


	public void setHallSeatRate3(int hallSeatRate3) {
		this.hallSeatRate3 = hallSeatRate3;
	}


	public String getSeatRateName() {
		return seatRateName;
	}


	public void setSeatRateName(String seatRateName) {
		this.seatRateName = seatRateName;
	}


	
	

	}