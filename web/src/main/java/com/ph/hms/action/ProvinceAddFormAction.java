package com.ph.hms.action;
import com.opensymphony.xwork.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import java.text.*;

public class ProvinceAddFormAction extends ActionSupport
{
	public String fname = "province";
	public String aname = "add";
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
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
		   
		   boolean matched = ds.checkRight(fname, aname);
	  
			 
		   if (matched == false) return "noprivilege";
		   
		   code = provinceManager.genCode("");
		   
			
	provinces = (Collection<Province>)provinceManager.getAllProvinces();
	
	
			
			Date d = new Date();
		
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
			today = sdf.format(d).toString();
		
			return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }
       
    }

	
}
