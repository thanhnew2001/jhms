package com.ph.hms.test;

import java.util.Collection;

public class Enc {

	private String name;
	
	private Collection<Integer> cols;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Integer> getCols() {
		return cols;
	}

	public void setCols(Collection<Integer> cols) {
		this.cols = cols;
	}

	public Enc(String name, Collection<Integer> cols) {
		super();
		this.name = name;
		this.cols = cols;
	}
	
	
	
}
