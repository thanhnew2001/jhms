package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class PrescriptiontemplatedetailDeleteAction extends ActionSupport
{
	public String fname = "prescriptiontemplatedetail";
	public String aname = "delete";
	
	
	private PrescriptiontemplatedetailManager prescriptiontemplatedetailManager;
	
	public PrescriptiontemplatedetailManager getPrescriptiontemplatedetailManager() {
		return prescriptiontemplatedetailManager;
	}

	public void setPrescriptiontemplatedetailManager(PrescriptiontemplatedetailManager prescriptiontemplatedetailManager) {
		this.prescriptiontemplatedetailManager = prescriptiontemplatedetailManager;
	}	
	
	private Collection<Prescriptiontemplatedetail> prescriptiontemplatedetails;
	
	public Collection<Prescriptiontemplatedetail> getPrescriptiontemplatedetails() {
		return prescriptiontemplatedetails;
	}

	public void setPrescriptiontemplatedetails(Collection<Prescriptiontemplatedetail> prescriptiontemplatedetails) {
		this.prescriptiontemplatedetails = prescriptiontemplatedetails;
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
	
	private PrescriptiontemplateManager prescriptiontemplateManager;
	
	public PrescriptiontemplateManager getPrescriptiontemplateManager() {
		return prescriptiontemplateManager;
	}

	public void setPrescriptiontemplateManager(PrescriptiontemplateManager prescriptiontemplateManager) {
		this.prescriptiontemplateManager = prescriptiontemplateManager;
	}	
	
	private Collection<Prescriptiontemplate> prescriptiontemplates;
	
	public Collection<Prescriptiontemplate> getPrescriptiontemplates() {
		return prescriptiontemplates;
	}

	public void setPrescriptiontemplates(Collection<Prescriptiontemplate> prescriptiontemplates) {
		this.prescriptiontemplates = prescriptiontemplates;
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

	
	private Prescriptiontemplatedetail prescriptiontemplatedetail;

	public Prescriptiontemplatedetail getPrescriptiontemplatedetail() {
		return prescriptiontemplatedetail;
	}

	public void setPrescriptiontemplatedetail(Prescriptiontemplatedetail prescriptiontemplatedetail) {
		this.prescriptiontemplatedetail = prescriptiontemplatedetail;
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
	   
       prescriptiontemplatedetailManager.deletePrescriptiontemplatedetail(id);
        	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
