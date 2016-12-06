package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetCashadvanceByTypeHeadAction extends ActionSupport
{
	
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

	
	private String typehead;	

	public String getTypehead() {
		return typehead;
	}

	public void setTypehead(String typehead) {
		this.typehead = typehead;
	}
	
	private String con;	
	
	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
	
public String execute() throws Exception
{
   try{
   	   i18n = i18nManager.geti18n();	
	   
	   if (flag!=null && flag.equalsIgnoreCase("filter")) {
			
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");					
						
				
				return SUCCESS;
		}

		if (con != null)
		{
			if (con.equalsIgnoreCase("") )
			{
				cashadvances = (Collection<Cashadvance>)cashadvanceManager.filter(typehead);
			}
	
			else if (con.equalsIgnoreCase("All"))
			{
				cashadvances = (Collection<Cashadvance>)cashadvanceManager.filterAll(typehead);
			}
			else
			{
				cashadvances = (Collection<Cashadvance>)cashadvanceManager.filterByCon(con, typehead);
			}
		}
		else
		{
			cashadvances = (Collection<Cashadvance>)cashadvanceManager.filter(typehead);
		}

        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}	
}
