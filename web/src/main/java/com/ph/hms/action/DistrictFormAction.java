package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class DistrictFormAction extends ActionSupport
{	
	public String fname = "district";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private District district;
		  
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	private int id;	

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
	
	private DistrictManager districtManager;
	
	public DistrictManager getDistrictManager() {
		return districtManager;
	}

	public void setDistrictManager(DistrictManager districtManager) {
		this.districtManager = districtManager;
	}	
	
	private Collection<District> districts;
	
	public Collection<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Collection<District> districts) {
		this.districts = districts;
	}	
	
	private ProvinceManager provinceManager;
	
	public ProvinceManager getProvinceManager() {
		return provinceManager;
	}

	public void setProvinceManager(ProvinceManager provinceManager) {
		this.provinceManager = provinceManager;
	}	
	
	private Collection<Province> provinces;
	
	public Collection<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(Collection<Province> provinces) {
		this.provinces = provinces;
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
	
	   districts = (Collection<District>)districtManager.getAllDistricts();
	
	   provinces = (Collection<Province>)provinceManager.getAllProvinces();
	   
	   if( id == 0 ) {
		   
		   boolean matched = ds.checkRight(fname, anameAdd);
		     
		   if (matched == false) return "noprivilege";
		   
		   Date d = new Date();
			
		   DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
		   today = sdf.format(d).toString();
		   
		   return SUCCESS;
		   
	   } else {
		   
		   boolean matched = ds.checkRight(fname, anameEdit);
		   
		     
		   if (matched == false) return "noprivilege";
		   
		   district = districtManager.getDistrict(id);
	       
	       System.out.println("District Form Action");
	        	
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
