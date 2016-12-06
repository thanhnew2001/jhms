package com.ph.hms.action;

import java.util.*;
import java.sql.ResultSet;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetIndicationdetailByTypeHeadAction extends ActionSupport {

	private IndicationdetailManager indicationdetailManager;

	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}

	private Collection<Indicationdetail> indicationdetails;

	public Collection<Indicationdetail> getIndicationdetails() {
		return indicationdetails;
	}

	public void setIndicationdetails(
			Collection<Indicationdetail> indicationdetails) {
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

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private HMSDataManager hmsDataManager;

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}


	
public String execute() throws Exception
{
   try{
   	   i18n = i18nManager.geti18n();	
	   
   	   Map session = ActionContext.getContext().getSession();
   	   
   	   Department department = (Department)session.get("selecteddepartment");
   	   
	   if (flag!=null && flag.equalsIgnoreCase("filter")) {
			
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
				
				Date d = new Date();
				
				if (date==null || date.equals(""))
				{
					d = null;
				}
				else
				{
					if(!date.equals(""))	d = sdf.parse(date + " 12:00:00");					
				}
			
				encounters = encounterManager.searchEncounterForIndicationdetail(department, d, status, con);
				
				//for testing purpose
				// Get current size of heap in bytes
		    	long heapSize = Runtime.getRuntime().totalMemory();
		    	
		    	System.out.println(heapSize);

		    	// Get maximum size of heap in bytes. The heap cannot grow beyond this size.
		    	// Any attempt will result in an OutOfMemoryException.
		    	long heapMaxSize = Runtime.getRuntime().maxMemory();
		    	
		    	System.out.println(heapMaxSize);

		    	// Get amount of free memory within the heap in bytes. This size will increase
		    	// after garbage collection and decrease as new objects are created.
		    	long heapFreeSize = Runtime.getRuntime().freeMemory();
		    	
		    	System.out.println(heapFreeSize);
		    	
		    	
				
		}
	   	
        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}}
