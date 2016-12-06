package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class HospitalFormAction extends ActionSupport
{	
	public String fname = "hospital";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Hospital hospital;
	
	private int id;	
		
   
	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
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
	
	private HospitalManager hospitalManager;
	
	public HospitalManager getHospitalManager() {
		return hospitalManager;
	}

	public void setHospitalManager(HospitalManager hospitalManager) {
		this.hospitalManager = hospitalManager;
	}	
	
	private Collection<Hospital> hospitals;
	
	public Collection<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(Collection<Hospital> hospitals) {
		this.hospitals = hospitals;
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
	   
	   hospitals = (Collection<Hospital>)hospitalManager.getAllHospitals();
	   
	   if( id == 0) {
			
			boolean matched = ds.checkRight(fname, anameAdd);

			   if (matched == false) return "noprivilege";
			   
			   Date d = new Date();
				
				DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
				today = sdf.format(d).toString();
			
				return SUCCESS;
	   } else {
	   
        	hospital = hospitalManager.getHospital(id);
        	
        	return SUCCESS;
	   }

     }
      catch(Exception e){
            System.out.println("Error Hospital Form");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
