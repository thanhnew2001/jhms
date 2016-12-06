package com.ph.hms;

public class Promotion {

	private int id;
	
	private String node;
	
	private String description;
	
	private double firstUseDiscount;	

	public double getFirstUseDiscount() {
		return firstUseDiscount;
	}

	public void setFirstUseDiscount(double firstUseDiscount) {
		this.firstUseDiscount = firstUseDiscount;
	}

	private double percentDiscount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(double percentDiscount) {
		this.percentDiscount = percentDiscount;
	}


	
}
