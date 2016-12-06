package com.ph.hms.action;
import com.opensymphony.xwork.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import java.text.*;

public class ServicegroupAddFormAction extends ActionSupport
{
	public String fname = "servicegroup";
	public String aname = "add";
	
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
	
	
	private ServicegroupManager servicegroupManager;
	
	public ServicegroupManager getServicegroupManager() {
		return servicegroupManager;
	}

	public void setServicegroupManager(ServicegroupManager servicegroupManager) {
		this.servicegroupManager = servicegroupManager;
	}	
	
	private Collection<Servicegroup> servicegroups;
	
	public Collection<Servicegroup> getServicegroups() {
		return servicegroups;
	}

	public void setServicegroups(Collection<Servicegroup> servicegroups) {
		this.servicegroups = servicegroups;
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
		   
		   code = servicegroupManager.genCode("");
		   
			
	servicegroups = (Collection<Servicegroup>)servicegroupManager.getAllServicegroups();
	
	
			
			Date d = new Date();
		
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
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
