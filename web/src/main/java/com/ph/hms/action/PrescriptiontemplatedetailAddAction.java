package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class PrescriptiontemplatedetailAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
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

	
	
	private int prescriptiontemplate;   
		
	
	public int getPrescriptiontemplate()
	{
		return prescriptiontemplate;
	}
	
	public void setPrescriptiontemplate(int prescriptiontemplate)
	{
		this.prescriptiontemplate =  prescriptiontemplate;
	}
	
	private int drug;   
		
	
	public int getDrug()
	{
		return drug;
	}
	
	public void setDrug(int drug)
	{
		this.drug =  drug;
	}
	
	private int quantity;   
		
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity =  quantity;
	}
	
	private int timeuse;   
		
	
	public int getTimeuse()
	{
		return timeuse;
	}
	
	public void setTimeuse(int timeuse)
	{
		this.timeuse =  timeuse;
	}
	
	private int quantityuse;   
		
	
	public int getQuantityuse()
	{
		return quantityuse;
	}
	
	public void setQuantityuse(int quantityuse)
	{
		this.quantityuse =  quantityuse;
	}
	
	private String note;   
		
	
	public String getNote()
	{
		return note;
	}
	
	public void setNote(String note)
	{
		this.note =  note;
	}
	

	public String execute() throws Exception
    {
        try{

			String code = prescriptiontemplatedetailManager.genCode("");
			
        	Prescriptiontemplatedetail prescriptiontemplatedetail = new Prescriptiontemplatedetail();
			
			
			prescriptiontemplatedetail.setPrescriptiontemplate(prescriptiontemplateManager.getPrescriptiontemplate(prescriptiontemplate));
	
			prescriptiontemplatedetail.setDrug(drugManager.getDrug(drug));
	
			prescriptiontemplatedetail.setQuantity(quantity);
	
			prescriptiontemplatedetail.setTimeuse(timeuse);
	
			prescriptiontemplatedetail.setQuantityuse(quantityuse);
	
			prescriptiontemplatedetail.setNote(note);
	
			
        	prescriptiontemplatedetailManager.addPrescriptiontemplatedetail(prescriptiontemplatedetail);
			
			id = prescriptiontemplatedetail.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
