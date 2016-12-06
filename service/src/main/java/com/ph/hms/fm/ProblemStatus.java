package com.ph.hms.fm;


/*
This class is to persist status for problem. 
Example data:
- Nhe
- Nang
 */
public class ProblemStatus {
	 
	private int id;
	
	private String node;

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
	
	
}
