package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DruginvoicedetailDeleteAction extends ActionSupport
{
	public String fname = "druginvoicedetail";
	public String aname = "delete";
	
	
	private DruginvoicedetailManager druginvoicedetailManager;
	
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

	public Druginvoicedetail getDruginvoicedetail() {
		return druginvoicedetail;
	}

	public void setDruginvoicedetail(Druginvoicedetail druginvoicedetail) {
		this.druginvoicedetail = druginvoicedetail;
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
	   
       druginvoicedetailManager.deleteDruginvoicedetail(id);
        	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
