package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class ImportinvoicedetailFormAction extends ActionSupport
{	
	public String fname = "importinvoicedetail";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Importinvoicedetail importinvoicedetail;
	
	private int id;	
		
   
	public Importinvoicedetail getImportinvoicedetail() {
		return importinvoicedetail;
	}

	public void setImportinvoicedetail(Importinvoicedetail importinvoicedetail) {
		this.importinvoicedetail = importinvoicedetail;
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


	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
		
	importinvoicedetails = (Collection<Importinvoicedetail>)importinvoicedetailManager.getAllImportinvoicedetails();
	
	
	drugs = (Collection<Drug>)drugManager.getAllDrugs();
	
	
	importinvoices = (Collection<Importinvoice>)importinvoiceManager.getAllImportinvoices();
	
	if( id == 0) {
		
		boolean matched = ds.checkRight(fname, anameAdd);

		   if (matched == false) return "noprivilege";
		
		Date d = new Date();
		
		DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
		today = sdf.format(d).toString();
		
		return SUCCESS;
		
	} else {
		boolean matched = ds.checkRight(fname, anameEdit);

		   if (matched == false) return "noprivilege";

        	importinvoicedetail = importinvoicedetailManager.getImportinvoicedetail(id);
        	        	
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
