package com.ph.hms.action;
import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.text.*;


import com.opensymphony.xwork.*;

public class CashadvanceListAction extends ActionSupport
{
	public String fname = "cashadvance";
	public String aname = "list";
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
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


public String execute() throws Exception
{
   try{
	   i18n = i18nManager.geti18n();	

	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);
  
	     
	   if (matched == false) return "noprivilege";

       cashadvances = (Collection<Cashadvance>)cashadvanceManager.getAllCashadvances();
	   
	   
	cashadvances = (Collection<Cashadvance>)cashadvanceManager.getAllCashadvances();
	
	
	encounters = (Collection<Encounter>)encounterManager.getAllEncounters(null);
	
	
		
		Date d = new Date();
	
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		today = sdf.format(d).toString();
		
        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}	
}
