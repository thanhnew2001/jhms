package com.ph.hms;

import java.util.Collection;

public class DrugGroup {

	private int id;
	
	private String node;
	
	private String description;

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
	
	private Collection<Drug> drugs;

	public Collection<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Collection<Drug> drugs) {
		this.drugs = drugs;
	}
	
	
}
