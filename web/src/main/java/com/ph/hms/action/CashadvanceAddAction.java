package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class CashadvanceAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	private CashadvanceManager cashadvanceManager;
	
	public CashadvanceManager getCashadvanceManager() {
		return cashadvanceManager;
	}

	public void setCashadvanceManager(CashadvanceManager cashadvanceManager) {
		this.cashadvanceManager = cashadvanceManager;
	}	
	
	private Collection<Cashadvance> cashadvances;
	
	public Collection<Cashadvance> getCashadvances() {
		return cashadvances;
	}

	public void setCashadvances(Collection<Cashadvance> cashadvances) {
		this.cashadvances = cashadvances;
	}	
	
	private EncounterManager encounterManager;
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}	
	
	private Collection<Encounter> encounters;
	
	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
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

	
	
	private int encounter;   
		
	
	public int getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(int encounter)
	{
		this.encounter =  encounter;
	}
	
	private Date node;   
		
	
	public Date getNode()
	{
		return node;
	}
	
	public void setNode(Date node)
	{
		this.node =  node;
	}
	
	private double amount;   
		
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount =  amount;
	}
	
	private String code;   
		
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
	}
	
	private String type;   
		
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type =  type;
	}
	

	public String execute() throws Exception
    {
        try{

			String code = cashadvanceManager.genCode("TU");
			
        	Cashadvance cashadvance = new Cashadvance();
			
			
			cashadvance.setEncounter(encounterManager.getEncounter(encounter));
	
			cashadvance.setNode(node);
	
			cashadvance.setAmount(amount);
	
			cashadvance.setCode(code);
	
			cashadvance.setType(type);
	
			
        	cashadvanceManager.addCashadvance(cashadvance);
			
			id = cashadvance.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
