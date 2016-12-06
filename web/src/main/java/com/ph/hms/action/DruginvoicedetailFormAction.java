package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import com.opensymphony.xwork.*;

import java.text.*;


public class DruginvoicedetailFormAction extends ActionSupport
{
	public String fname = "druginvoicedetail";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
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
	
	
	
	public DruginvoicedetailManager getDruginvoicedetailManager() {
		return druginvoicedetailManager;
	}

	public void setDruginvoicedetailManager(DruginvoicedetailManager druginvoicedetailManager) {
		this.druginvoicedetailManager = druginvoicedetailManager;
	}	
	
	private Collection<Druginvoicedetail> druginvoicedetails;
	
	public Collection<Druginvoicedetail> getDruginvoicedetails() {
		return druginvoicedetails;
	}

	public void setDruginvoicedetails(Collection<Druginvoicedetail> druginvoicedetails) {
		this.druginvoicedetails = druginvoicedetails;
	}	
	
	private DrugManager drugManager;
	
	public DrugManager getDrugManager() {
		return drugManager;
	}

	public void setDrugManager(DrugManager drugManager) {
		this.drugManager = drugManager;
	}	
	
	private Collection<Drug> drugs;
	
	public Collection<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Collection<Drug> drugs) {
		this.drugs = drugs;
	}	
	
	private DruginvoiceManager druginvoiceManager;
	
	public DruginvoiceManager getDruginvoiceManager() {
		return druginvoiceManager;
	}

	public void setDruginvoiceManager(DruginvoiceManager druginvoiceManager) {
		this.druginvoiceManager = druginvoiceManager;
	}	
	
	private Collection<Druginvoice> druginvoices;
	
	public Collection<Druginvoice> getDruginvoices() {
		return druginvoices;
	}

	public void setDruginvoices(Collection<Druginvoice> druginvoices) {
		this.druginvoices = druginvoices;
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

	
	
	private Druginvoicedetail druginvoicedetail;
	
	private int id;	
		
   
	public Druginvoicedetail getDruginvoicedetail() {
		return druginvoicedetail;
	}

	public void setDruginvoicedetail(Druginvoicedetail druginvoicedetail) {
		this.druginvoicedetail = druginvoicedetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
	
	private DruginvoicedetailManager druginvoicedetailManager;
	
	
	public String execute() throws Exception
    {
    
	try{
		 i18n = i18nManager.geti18n();	
		   
		   DefaultSecurity ds = new DefaultSecurity();
		   
		   code = druginvoicedetailManager.genCode("");
		   
			
	druginvoicedetails = (Collection<Druginvoicedetail>)druginvoicedetailManager.getAllDruginvoicedetails();
	
	
	drugs = (Collection<Drug>)drugManager.getAllDrugs();
	
	
	druginvoices = (Collection<Druginvoice>)druginvoiceManager.getAllDruginvoices();

			if( id == 0) {
				
				boolean matched = ds.checkRight(fname, anameAdd);
		
				if (matched == false) return "noprivilege";
				   
				Date d = new Date();
				
				DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
				
				today = sdf.format(d).toString();
					
				return SUCCESS;
					
			} else {
				boolean matched = ds.checkRight(fname, anameAdd);
				
				if (matched == false) return "noprivilege";
					
				druginvoicedetail = druginvoicedetailManager.getDruginvoicedetail(id);
				
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


	

