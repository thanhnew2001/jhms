package com.ph.hms.cardmanagement;

import java.util.Collection;

import com.ph.hms.Service;
import com.ph.hms.Servicegroup;

public class Privilege {

	private int id;
	
	private String name;
	
	private CardType cardType;
	
	private Collection<PrivilegeDetail> privilegeDetails;
	
	private int percentDiscount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public Collection<PrivilegeDetail> getPrivilegeDetails() {
		return privilegeDetails;
	}

	public void setPrivilegeDetails(Collection<PrivilegeDetail> privilegeDetails) {
		this.privilegeDetails = privilegeDetails;
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}
	
	
}
