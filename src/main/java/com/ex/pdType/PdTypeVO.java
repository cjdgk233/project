package com.ex.pdType;

public class PdTypeVO {
	private int pdTypeSeq;     // 공연종류SEQ
	private String pdTypeName; // 공연종류명
	
	public PdTypeVO() {
		
	}
	
	public int getPdTypeSeq() {
		return pdTypeSeq;
	}
	public void setPdTypeSeq(int pdTypeSeq) {
		this.pdTypeSeq = pdTypeSeq;
	}
	public String getPdTypeName() {
		return pdTypeName;
	}
	public void setPdTypeName(String pdTypeName) {
		this.pdTypeName = pdTypeName;
	}
	

}