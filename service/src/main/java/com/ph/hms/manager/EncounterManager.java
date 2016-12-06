
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Department;
import com.ph.hms.Encounter;
import com.ph.hms.Promotion;
import com.ph.hms.Room;
import com.ph.hms.Solving;

public interface EncounterManager {

	String ID = EncounterManager.class.getName();
	
	public void addEncounter(Encounter encounter);
	
	public void updateEncounter(Encounter encounter);
	
	public void deleteEncounter(int id);
	
	public Encounter getEncounter(int id);
	
	public Collection<Encounter> getAllEncounters(Room room);
	
	public Collection<Encounter> filter(String typehead, Room room);
	
	public Collection<Encounter> filterAll(String typehead);
	
	public Collection<Encounter> filterByCon(String con, String typehead, Room room);
	
	public Collection<Encounter> filterByDateSolving( Date date, Solving solving, Room room );
	
	public String genCode(String formula);
	
	public Collection<Encounter> searchEncounterForIndicationdetail(String clientCode, String clientName, String misc);
	
	public Collection<Encounter> searchEncounterForIndicationdetail(String con, Date d);
	
	public Collection<Encounter> searchEncounterForDrug(String con, Date d);
	
	public Collection<Encounter> getEncounterByClientId(int id);
	
	public Collection<Encounter> getEncounterByType(int encounterType);
	
	public Collection<Encounter> searchEncounterForIndicationdetail(Department department, Date d, String status, String con);
	
	public Collection<Encounter> searchEncounterForEncounter(Room room, Date d, Solving solving, String con);
		
	//for promotion class
	public void addPromotion(Promotion promotion);
	
	public void updatePromotion(Promotion promotion);
	
	public void deletePromotion(int id);
	
	public Promotion getPromotion(int id);
	
	public Promotion getPromotion(String code);
		
	public Collection<Promotion> getAllPromotions(Room room);
	
	public boolean isUsed(String cardNo);
	
	public Collection<Encounter> getEncountersByPromotionCode(String promotionCode);
	
	//
	public double getTotalPaidOfPrepaidCard(String prepaidCard);
		

}
