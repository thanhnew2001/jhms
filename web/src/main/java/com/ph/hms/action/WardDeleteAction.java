package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class WardDeleteAction extends ActionSupport
{
	public String fname = "ward";
	public String aname = "delete";
	
	
	private WardManager wardManager;
	
	public WardManager getWardManager() {
		return wardManager;
	}

	public void setWardManager(WardManager wardManager) {
		this.wardManager = wardManager;
	}	
	
	private Collection<Ward> wards;
	
	public Collection<Ward> getWards() {
		return wards;
	}

	public void setWards(Collection<Ward> wards) {
		this.wards = wards;
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

	
	private Ward ward;

	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
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
	   
       wardManager.deleteWard(id);
        	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
