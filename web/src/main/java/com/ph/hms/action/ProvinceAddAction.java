package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ProvinceAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	

	public String execute() throws Exception
    {
        try{

			String code = provinceManager.genCode("");
			
        	Province province = new Province();
			
			
			province.setNode(node);
	
			
        	provinceManager.addProvince(province);
			
			id = province.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
