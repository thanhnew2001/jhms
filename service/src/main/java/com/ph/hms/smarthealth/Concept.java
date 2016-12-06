package com.ph.hms.smarthealth;

import java.util.Collection;

public class Concept {

	private int id;
	
	private String shortName;
	
	private ConceptClass conceptClass;
	
	private Collection<ConceptName> conceptNames;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public ConceptClass getConceptClass() {
		return conceptClass;
	}

	public void setConceptClass(ConceptClass conceptClass) {
		this.conceptClass = conceptClass;
	}

	public Collection<ConceptName> getConceptNames() {
		return conceptNames;
	}

	public void setConceptNames(Collection<ConceptName> conceptNames) {
		this.conceptNames = conceptNames;
	}
	
	
	
}
