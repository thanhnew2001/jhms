package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class PackagedetailDeleteAction extends ActionSupport
{
	public String fname = "packagedetail";
	public String aname = "delete";
	
	
	private PackagedetailManager packagedetailManager;
	
	public PackagedetailManager getPackagedetailManager() {
		return packagedetailManager;
	}

	public void setPackagedetailManager(PackagedetailManager packagedetailManager) {
		this.packagedetailManager = packagedetailManager;
	}	
	
	private Collection<Packagedetail> packagedetails;
	
	public Collection<Packagedetail> getPackagedetails() {
		return packagedetails;
	}

	public void setPackagedetails(Collection<Packagedetail> packagedetails) {
		this.packagedetails = packagedetails;
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
	
	private SerpackageManager serpackageManager;
	
	public SerpackageManager getSerpackageManager() {
		return serpackageManager;
	}

	public void setSerpackageManager(SerpackageManager serpackageManager) {
		this.serpackageManager = serpackageManager;
	}	
	
	private Collection<Serpackage> serpackages;
	
	public Collection<Serpackage> getSerpackages() {
		return serpackages;
	}

	public void setSerpackages(Collection<Serpackage> serpackages) {
		this.serpackages = serpackages;
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

	
	private Packagedetail packagedetail;

	public Packagedetail getPackagedetail() {
		return packagedetail;
	}

	public void setPackagedetail(Packagedetail packagedetail) {
		this.packagedetail = packagedetail;
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
	   
       packagedetailManager.deletePackagedetail(id);
        	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
