package com.ph.hms.fm;

import com.ph.hms.*; 

public class ImmunisationHistory {

	private int id;
	
	private ImmunisationTime immunisationTime;
	
	private Vaccine vaccine;
	
	private Client client;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ImmunisationTime getImmunisationTime() {
		return immunisationTime;
	}

	public void setImmunisationTime(ImmunisationTime immunisationTime) {
		this.immunisationTime = immunisationTime;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
}
