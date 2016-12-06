package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class PackagedetailAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	
	
	private int serpackage;   
		
	
	public int getSerpackage()
	{
		return serpackage;
	}
	
	public void setSerpackage(int serpackage)
	{
		this.serpackage =  serpackage;
	}
	
	private int service;   
		
	
	public int getService()
	{
		return service;
	}
	
	public void setService(int service)
	{
		this.service =  service;
	}
	
	private int quantity;

	public String execute() throws Exception
    {
        try{

			String code = packagedetailManager.genCode("");
			
        	Packagedetail packagedetail = new Packagedetail();
			
			
        	
			packagedetail.setSerpackage(serpackageManager.getSerpackage(serpackage));
	
			packagedetail.setService(serviceManager.getService(service));
	
			packagedetail.setQuantity(quantity);
			
        	packagedetailManager.addPackagedetail(packagedetail);
			
			id = packagedetail.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
