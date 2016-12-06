package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class VitalsignDeleteAction extends ActionSupport
{
	public String fname = "vitalsign";
	public String aname = "delete";
	
	
	private VitalsignManager vitalsignManager;
	
	public VitalsignManager getVitalsignManager() {
		return vitalsignManager;
	}

	public void setVitalsignManager(VitalsignManager vitalsignManager) {
		this.vitalsignManager = vitalsignManager;
	}	
	
	private Collection<Vitalsign> vitalsigns;
	
	public Collection<Vitalsign> getVitalsigns() {
		return vitalsigns;
	}

	public void setVitalsigns(Collection<Vitalsign> vitalsigns) {
		this.vitalsigns = vitalsigns;
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

	
	private Vitalsign vitalsign;

	public Vitalsign getVitalsign() {
		return vitalsign;
	}

	public void setVitalsign(Vitalsign vitalsign) {
		this.vitalsign = vitalsign;
	}
	
	private int id;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception
    {
        try{

		//checking role
	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);  
	     
	   if (matched == false) return "noprivilege";
	   
       vitalsignManager.deleteVitalsign(id);
        	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
