package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class EthnicFormAction extends ActionSupport
{	
	public String fname = "ethnic";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Ethnic ethnic;
	
	private int id;	
		
   
	public Ethnic getEthnic() {
		return ethnic;
	}

	public void setEthnic(Ethnic ethnic) {
		this.ethnic = ethnic;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}	
	
	private EthnicManager ethnicManager;
	
	public EthnicManager getEthnicManager() {
		return ethnicManager;
	}

	public void setEthnicManager(EthnicManager ethnicManager) {
		this.ethnicManager = ethnicManager;
	}	
	
	private Collection<Ethnic> ethnics;
	
	public Collection<Ethnic> getEthnics() {
		return ethnics;
	}

	public void setEthnics(Collection<Ethnic> ethnics) {
		this.ethnics = ethnics;
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
	   
	   ethnics = (Collection<Ethnic>)ethnicManager.getAllEthnics();
	   
	   if ( id == 0){
			
			boolean matched = ds.checkRight(fname, anameAdd);

			if (matched == false) return "noprivilege";
			
			Date d = new Date();
			
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
			today = sdf.format(d).toString();
		
			return SUCCESS;
			

	   } else {
		   
		   boolean matched = ds.checkRight(fname, anameEdit);

			if (matched == false) return "noprivilege";

        	ethnic = ethnicManager.getEthnic(id);
        	
        	return SUCCESS;
	   }

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
