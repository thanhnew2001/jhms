package com.ph.hms.cardmanagement;

import java.util.Collection;

public class CardType {

	private int id;
	
	private String code;
	
	private String name;

	private int maxPoint;
	
	private String cardTypeGroup;
	

	public String getCardTypeGroup() {
		return cardTypeGroup;
	}

	public void setCardTypeGroup(String cardTypeGroup) {
		this.cardTypeGroup = cardTypeGroup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(int maxPoint) {
		this.maxPoint = maxPoint;
	}

	private Collection<Privilege> privileges;

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	
}
