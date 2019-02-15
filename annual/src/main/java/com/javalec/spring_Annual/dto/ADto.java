package com.javalec.spring_Annual.dto;

public class ADto {
	private int aId;
	private String aName;
	private String rank;
	private int annual;
	private int use;
	private String aComent;
	private String aDate;
	
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getAnnual() {
		return annual;
	}
	public void setAnnual(int annual) {
		this.annual = annual;
	}
	public String getaDate() {
		return aDate;
	}
	public void setaDate(String aDate) {
		this.aDate = aDate;
	}
	public String getaComent() {
		return aComent;
	}
	public void setaComent(String aComent) {
		this.aComent = aComent;
	}
}
