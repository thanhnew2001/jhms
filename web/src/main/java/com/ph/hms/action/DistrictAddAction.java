package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DistrictAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private int province;   
		
	
	public int getProvince()
	{
		return province;
	}
	
	public void setProvince(int province)
	{
		this.province =  province;
	}
	

	public String execute() throws Exception
    {
        try{

			String code = districtManager.genCode("");
			
        	District district = new District();
			
			
			district.setNode(node);
	
			district.setProvince(provinceManager.getProvince(province));
	
			
        	districtManager.addDistrict(district);
			
			id = district.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
