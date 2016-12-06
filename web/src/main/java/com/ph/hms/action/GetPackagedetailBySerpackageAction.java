package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetPackagedetailBySerpackageAction extends ActionSupport
{
	
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
		
	
	private PackagedetailManager packagedetailManager;
	
	public PackagedetailManager getPackagedetailManager() {
		return packagedetailManager;
	}

	public void setPackagedetailManager(PackagedetailManager packagedetailManager) {
		this.packagedetailManager = packagedetailManager;
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

	
	private Collection<Packagedetail> packagedetails;
	
	public Collection<Packagedetail> getPackagedetails() {
		return packagedetails;
	}

	public void setPackagedetails(Collection<Packagedetail> packagedetails) {
		this.packagedetails = packagedetails;
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

   	   i18n = i18nManager.geti18n();	
   
	   Map session = ActionContext.getContext().getSession();
	   
	   session.put("serpackage_id", id);
	   
	   Serpackage serpackage = serpackageManager.getSerpackage(id);
	   
	   System.out.println(serpackage);
	   
		services = (Collection<Service>)serviceManager.getAllServices();		
		
		serpackages = (Collection<Serpackage>)serpackageManager.getAllSerpackages();		
		
	   
	   if (serpackage != null)
	   {
	   		session.put("serpackage_node", serpackageManager.getSerpackage(id).getNode());
			packagedetails = serpackage.getPackagedetails();
			
			   System.out.println(packagedetails.size());
	   }
	   else
	   {
		    packagedetails = (Collection<Packagedetail>)packagedetailManager.getAllPackagedetails();
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
