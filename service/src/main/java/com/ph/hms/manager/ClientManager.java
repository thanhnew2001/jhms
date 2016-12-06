
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Client;
import com.ph.hms.FamilyMember;

public interface ClientManager {

	String ID = ClientManager.class.getName();
	
	public void addClient(Client client);
	
	public void updateClient(Client client);
	
	public void deleteClient(int id);
	
	public Client getClient(int id);
	
	public Collection<Client> getAllClients();
	
	public Collection<Client> filter(String typehead);
	
	public Collection<Client> filterAll(String typehead);
	
	public Collection<Client> filterByCon(String con, String typehead);
	
	public Collection<Client> filterByCreateddate( Date createddate );
	
	public String genCode(String formula);
	
	//family member
	public void addFamilyMember(FamilyMember familyMember);
	
	public void updateFamilyMember(FamilyMember familyMember);
	
	public void deleteFamilyMember(int id);
	
	public FamilyMember getFamilyMember(int id);
	
	public Collection<FamilyMember> getAllFamilyMembers();
	
	

}
