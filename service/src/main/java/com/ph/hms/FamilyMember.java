package com.ph.hms;

public class FamilyMember {

	private String relationship;
	
	private Client client;

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	private Client clientMember;

	public Client getClientMember() {
		return clientMember;
	}

	public void setClientMember(Client clientMember) {
		this.clientMember = clientMember;
	}
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
