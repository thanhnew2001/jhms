package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import com.opensymphony.xwork.*;

public class SerpackageEditFormAction extends ActionSupport
{	
	public String fname = "serpackage";
	public String aname = "update";
	
	private Serpackage serpackage;
	
	private int id;	
		
   
	public Serpackage getSerpackage() {
		return serpackage;
	}

	public void setSerpackage(Serpackage serpackage) {
		this.serpackage = serpackage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	   
	   boolean matched = ds.checkRight(fname, aname);
  
	     
	   if (matched == false) return "noprivilege";

			
	serpackages = (Collection<Serpackage>)serpackageManager.getAllSerpackages();
	
	
        	serpackage = serpackageManager.getSerpackage(id);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
