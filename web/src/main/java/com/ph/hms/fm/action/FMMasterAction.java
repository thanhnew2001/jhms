/*package com.ph.hms.fm.action;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.BodyPartManager;
import com.ph.hms.Client;
import com.ph.hms.ClientManager;
import com.ph.hms.Encounter;
import com.ph.hms.EncounterManager;
import com.ph.hms.Service;

public class FMMasterAction extends ActionSupport 
{
	
	private ClientManager clientManager;
	
	private int clientId;
	
	private Client client;

	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	private BodyPartManager bodyPartManager;
		
	
	public BodyPartManager getBodyPartManager() {
		return bodyPartManager;
	}

	public void setBodyPartManager(BodyPartManager bodyPartManager) {
		this.bodyPartManager = bodyPartManager;
	}

	private String action;
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private String page1;
	
	private String page2;
	
	private String page3;
	
	private String page4;
	
	

	public String getPage1() {
		return page1;
	}

	public void setPage1(String page1) {
		this.page1 = page1;
	}

	public String getPage2() {
		return page2;
	}

	public void setPage2(String page2) {
		this.page2 = page2;
	}

	public String getPage3() {
		return page3;
	}

	public void setPage3(String page3) {
		this.page3 = page3;
	}

	public String getPage4() {
		return page4;
	}

	public void setPage4(String page4) {
		this.page4 = page4;
	}
	
	private EncounterManager encounterManager;
	
	private Encounter encounter;
	
	private int encounterId;
	
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public int getEncounterId() {
		return encounterId;
	}

	public void setEncounterId(int encounterId) {
		this.encounterId = encounterId;
	}

	public String execute()
	{
		
		if(encounterId>0) encounter = encounterManager.getEncounter(encounterId);
		
		if(action==null) action = "";
		if (action.equalsIgnoreCase("save")) //save it to db
		{
				encounter.setFmPage1(page1);	
				encounter.setFmPage2(page2);	
				encounter.setFmPage3(page3);				
				encounter.setFmPage4(page4);
		}
		else //showing edit form
		{
			//load the template if there is no content in the client
			//bodypart id: 5000:5010 are for family medicine template
			if (encounter.getFmPage1().trim().equalsIgnoreCase(""))
			{				
				encounter.setFmPage1(bodyPartManager.getBodyPart(5001).getDescription());
			}
			
			if (encounter.getFmPage2().trim().equalsIgnoreCase(""))
			{				
				encounter.setFmPage2(bodyPartManager.getBodyPart(5002).getDescription());
			}
			
			if (encounter.getFmPage3().trim().equalsIgnoreCase(""))
			{				
				encounter.setFmPage3(bodyPartManager.getBodyPart(5003).getDescription());
			}
			
			if (encounter.getFmPage4().trim().equalsIgnoreCase(""))
			{				
				encounter.setFmPage4(bodyPartManager.getBodyPart(5004).getDescription());
			}
				
		}		
		
		encounterManager.updateEncounter(encounter);		
		
		return SUCCESS;
	}
}
*/