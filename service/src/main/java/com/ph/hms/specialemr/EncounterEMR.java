package com.ph.hms.specialemr;

import com.ph.hms.Encounter;
import com.ph.hms.User;

public class EncounterEMR {

	private int id;
	
	private Encounter encounter;
	
	private SpecialEMR specialEMR;
	
	private String content;
	
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public SpecialEMR getSpecialEMR() {
		return specialEMR;
	}

	public void setSpecialEMR(SpecialEMR specialEMR) {
		this.specialEMR = specialEMR;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
