package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import com.opensymphony.xwork.*;

public class IndicationdetailEditFormAction extends ActionSupport
{	
	public String fname = "indicationdetail";
	public String aname = "update";
	
	private Indicationdetail indicationdetail;
	
	private int id;	
		
   
	public Indicationdetail getIndicationdetail() {
		return indicationdetail;
	}

	public void setIndicationdetail(Indicationdetail indicationdetail) {
		this.indicationdetail = indicationdetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
	
	private IndicationdetailManager indicationdetailManager;
	
	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}	
	
	private Collection<Indicationdetail> indicationdetails;
	
	public Collection<Indicationdetail> getIndicationdetails() {
		return indicationdetails;
	}

	public void setIndicationdetails(Collection<Indicationdetail> indicationdetails) {
		this.indicationdetails = indicationdetails;
	}	
	
	private ServiceManager serviceManager;
	
	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}	
	
	private Collection<Service> services;
	
	public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
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

			
	indicationdetails = (Collection<Indicationdetail>)indicationdetailManager.getAllIndicationdetails(null);
	
	
	services = (Collection<Service>)serviceManager.getAllServices();
	
	
	encounters = (Collection<Encounter>)encounterManager.getAllEncounters(null);
	
	
        	indicationdetail = indicationdetailManager.getIndicationdetail(id);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
