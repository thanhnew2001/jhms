package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class PackagedetailFormAction extends ActionSupport
{	
	public String fname = "packagedetail";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Packagedetail packagedetail;
	
	private int id;	
		
   
	public Packagedetail getPackagedetail() {
		return packagedetail;
	}

	public void setPackagedetail(Packagedetail packagedetail) {
		this.packagedetail = packagedetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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


	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
	   
			
	packagedetails = (Collection<Packagedetail>)packagedetailManager.getAllPackagedetails();
	
	
	services = (Collection<Service>)serviceManager.getAllServices();
	
	
	serpackages = (Collection<Serpackage>)serpackageManager.getAllSerpackages();
	

	if( id == 0) {
		
		boolean matched = ds.checkRight(fname, anameAdd);

		   if (matched == false) return "noprivilege";
		   
		code = packagedetailManager.genCode("");
		
		Date d = new Date();
		
		DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
		today = sdf.format(d).toString();
		
		return SUCCESS;
		
	} else {
		boolean matched = ds.checkRight(fname, anameEdit);

		   if (matched == false) return "noprivilege";

        	packagedetail = packagedetailManager.getPackagedetail(id);
        	
        	return SUCCESS;
	}

    }
     catch(Exception e){
            System.out.println("Error package detail Form");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
