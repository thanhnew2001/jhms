package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ImportinvoicedetailDeleteAction extends ActionSupport
{
	public String fname = "importinvoicedetail";
	public String aname = "delete";
	
	
	private ImportinvoicedetailManager importinvoicedetailManager;
	
	public ImportinvoicedetailManager getImportinvoicedetailManager() {
		return importinvoicedetailManager;
	}

	public void setImportinvoicedetailManager(ImportinvoicedetailManager importinvoicedetailManager) {
		this.importinvoicedetailManager = importinvoicedetailManager;
	}	
	
	private Collection<Importinvoicedetail> importinvoicedetails;
	
	public Collection<Importinvoicedetail> getImportinvoicedetails() {
		return importinvoicedetails;
	}

	public void setImportinvoicedetails(Collection<Importinvoicedetail> importinvoicedetails) {
		this.importinvoicedetails = importinvoicedetails;
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
	
	private ImportinvoiceManager importinvoiceManager;
	
	public ImportinvoiceManager getImportinvoiceManager() {
		return importinvoiceManager;
	}

	public void setImportinvoiceManager(ImportinvoiceManager importinvoiceManager) {
		this.importinvoiceManager = importinvoiceManager;
	}	
	
	private Collection<Importinvoice> importinvoices;
	
	public Collection<Importinvoice> getImportinvoices() {
		return importinvoices;
	}

	public void setImportinvoices(Collection<Importinvoice> importinvoices) {
		this.importinvoices = importinvoices;
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

	
	private Importinvoicedetail importinvoicedetail;

	public Importinvoicedetail getImportinvoicedetail() {
		return importinvoicedetail;
	}

	public void setImportinvoicedetail(Importinvoicedetail importinvoicedetail) {
		this.importinvoicedetail = importinvoicedetail;
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
	   
       importinvoicedetailManager.deleteImportinvoicedetail(id);
        	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
