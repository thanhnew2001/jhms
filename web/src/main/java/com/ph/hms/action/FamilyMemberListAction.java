package com.ph.hms.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Client;
import com.ph.hms.ClientManager;
import com.ph.hms.FamilyMember;
import com.ph.hms.action.util.DefaultSecurity;
import com.ph.hms.action.util.I18nManager;

public class FamilyMemberListAction extends ActionSupport {

	public String fname = "familymember";
	public String aname = "list";
	
	private ClientManager clientManager;
	
	private int clientId;

	private Collection<FamilyMember> familyMembers;
		
	
	public Collection<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(Collection<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

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
	
	private Hashtable<String, String> i18n;			
	
	public Hashtable<String, String> getI18n() {			  		   
		return i18n;
	}
		
	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}
		
	private I18nManager i18nManager;			
		
	public I18nManager getI18nManager() {
		return i18nManager;
	}
		
	public void setI18nManager(I18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}
 
	private Collection<Client> clients;
	
	private String keyword;
	
		
	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	private String action;	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	private String relationship;
	
	private int clientMemberId;	
	
	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}


	public int getClientMemberId() {
		return clientMemberId;
	}

	public void setClientMemberId(int clientMemberId) {
		this.clientMemberId = clientMemberId;
	}

	private int familyMemberId;	
	
	
	public int getFamilyMemberId() {
		return familyMemberId;
	}

	public void setFamilyMemberId(int familyMemberId) {
		this.familyMemberId = familyMemberId;
	}

	private Client client;	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String execute()
	{
		i18n = i18nManager.geti18n();	
		   
		DefaultSecurity ds = new DefaultSecurity();
		   
		boolean matched = ds.checkRight(fname, aname);	  
			 
		if (matched == false) return "noprivilege";
		
		if (action!=null && action.equalsIgnoreCase("addmember"))
		{
			FamilyMember fm = new FamilyMember();
			fm.setClient(clientManager.getClient(clientId));
			fm.setClientMember(clientManager.getClient(clientMemberId));
			fm.setRelationship(relationship);
			
			clientManager.addFamilyMember(fm);
		}
		
		if (action!=null && action.equalsIgnoreCase("deletemember"))
		{			
			clientManager.deleteFamilyMember(familyMemberId);
		}
		   
		familyMembers = new ArrayList<FamilyMember>();
		
		familyMembers = clientManager.getClient(clientId).getFamilyMembers();
		
		client = clientManager.getClient(clientId);
		
		if (keyword != null && !keyword.equalsIgnoreCase(""))
			clients = clientManager.filterAll(keyword);
		
		return SUCCESS;
	}
	
}
