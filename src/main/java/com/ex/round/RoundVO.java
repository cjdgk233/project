package com.ex.round;

import java.sql.Time;
import java.util.Date;

public class RoundVO {
	private int roundSeq;     // 회차SEQ
	private String roundDate;   // 공연일자
	private String roundTime;   // 공연시간
	private Integer roundSeatCnt; // 잔여석 수
	private int roundProduct; // 작품SEQ(FK)
	private int roundHall; // 홀SEQ(FK)
	private String roundDeadLine;
	
	
	public int getRoundSeq() {
		return roundSeq;
	}
	public void setRoundSeq(int roundSeq) {
		this.roundSeq = roundSeq;
	}
	public String getRoundDate() {
		return roundDate;
	}
	public void setRoundDate(String roundDate2) {
		this.roundDate = roundDate2;
	}
	public String getRoundTime() {
		return roundTime;
	}
	public void setRoundTime(String roundTime) {
		this.roundTime = roundTime;
	}
	public Integer getRoundSeatCnt() {
		return roundSeatCnt;
	}
	public void setRoundSeatCnt(Integer roundSeatCnt) {
		this.roundSeatCnt = roundSeatCnt;
	}
	public int getRoundProduct() {
		return roundProduct;
	}
	public void setRoundProduct(int roundProduct) {
		this.roundProduct = roundProduct;
	}
	public int getRoundHall() {
		return roundHall;
	}
	public void setRoundHall(int roundHall) {
		this.roundHall = roundHall;
	}
	public String getRoundDeadLine() {
		return roundDeadLine;
	}
	public void setRoundDeadLine(String roundDeadLine) {
		this.roundDeadLine = roundDeadLine;
	}
	
	
}