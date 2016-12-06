package com.ph.hms.cardmanagement;

import java.util.Collection;
import com.ph.hms.*;

public interface CardManager {

	//card
	public void addCard(Card card); 
	public void updateCard(Card card);	
	public void deleteCard(int id);
	public Card getCard(int id);
	public Collection<Card> searchCards(String con, int pageSize, int page);
	public Card getCardByCode(String con, int pageSize, int page);
	
	public Collection<Encounter> getEncountersByCard(Card card);
	
	
	
	//card type
	public void addCardType(CardType cardType); 
	public void updateCardType(CardType cardType);	
	public void deleteCardType(int id);
	public CardType getCardType(int id);	
	public Collection<CardType> getAllCardTypes();
	public Collection<CardType> searchCardTypes(String con, int pageSize, int page);

	
	
	//privilege
	public void addPrivilege(Privilege privilege); 
	public void updatePrivilege(Privilege privilege);	
	public void deletePrivilege(int id);
	public Privilege getPrivilege(int id);
	
	
	//add privilege detail
	public void addPrivilegeDetail(PrivilegeDetail privilegeDetail); 
	public void updatePrivilegeDetail(PrivilegeDetail privilegeDetail);	
	public void deletePrivilegeDetail(int id);
	public PrivilegeDetail getPrivilegeDetail(int id);	
	public Collection<PrivilegeDetail> getAllPrivilegeDetailsByService(Service service, int pageSize, int page);
	public Collection<PrivilegeDetail> getAllPrivilegeDetailsByServiceGroup(Servicegroup serviceGroup, int pageSize, int page);
	
}
