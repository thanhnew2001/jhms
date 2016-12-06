package com.ph.hms.smarthealth;

import com.ph.hms.Encounter;

public class EncounterConcept {

	private int id;
	
	private Encounter encounter;
	
	private Concept concept;

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

	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	
}
