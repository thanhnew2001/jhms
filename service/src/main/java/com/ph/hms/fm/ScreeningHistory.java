package com.ph.hms.fm;

import java.util.Date;
import com.ph.hms.*;

public class ScreeningHistory {

	private int id;
	
	private ScreeningTest screeningTest;
	
	private Encounter encounter;
	
	private String result;
	
	private String resultDescription;
	
	private String note;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ScreeningTest getScreeningTest() {
		return screeningTest;
	}

	public void setScreeningTest(ScreeningTest screeningTest) {
		this.screeningTest = screeningTest;
	}


	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	
}
