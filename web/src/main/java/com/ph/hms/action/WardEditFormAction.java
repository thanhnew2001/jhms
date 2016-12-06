package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import com.opensymphony.xwork.*;

public class WardEditFormAction extends ActionSupport
{	
	public String fname = "ward";
	public String aname = "update";
	
	private Ward ward;
	
	private int id;	
		
   
	public Ward getWard() {
		return ward;
	}

	public void setWard(Ward ward) {
		this.ward = ward;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
	
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


	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);
  
	     
	   if (matched == false) return "noprivilege";

			
	wards = (Collection<Ward>)wardManager.getAllWards();
	
	
	districts = (Collection<District>)districtManager.getAllDistricts();
	
	
        	ward = wardManager.getWard(id);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
