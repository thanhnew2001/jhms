package com.ph.hms.fm;

/*
This class is to persist list of problem. 
Example data:
- Nhuc dau
- So mui
- Dau lung
- Dau bung
 */
public class Problem {

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
