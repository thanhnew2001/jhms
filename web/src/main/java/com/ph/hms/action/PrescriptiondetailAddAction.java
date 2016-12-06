package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class PrescriptiondetailAddAction extends ActionSupport
{

	private String usageDescription;
	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	private PrescriptiondetailManager prescriptiondetailManager;
	
	public PrescriptiondetailManager getPrescriptiondetailManager() {
		return prescriptiondetailManager;
	}

	public void setPrescriptiondetailManager(PrescriptiondetailManager prescriptiondetailManager) {
		this.prescriptiondetailManager = prescriptiondetailManager;
	}	
	
	private Collection<Prescriptiondetail> prescriptiondetails;
	
	public Collection<Prescriptiondetail> getPrescriptiondetails() {
		return prescriptiondetails;
	}

	public void setPrescriptiondetails(Collection<Prescriptiondetail> prescriptiondetails) {
		this.prescriptiondetails = prescriptiondetails;
	}	
	
	private EncounterManager encounterManager;
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}	
	
	private Collection<Encounter> encounters;
	
	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
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

	
	
	private int encounter;   
		
	
	public int getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(int encounter)
	{
		this.encounter =  encounter;
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
	
	private String unit;   
		
	
	public String getUnit()
	{
		return unit;
	}
	
	public void setUnit(String unit)
	{
		this.unit =  unit;
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
	
	private double quantityuse;   
		
	
	
	
	private String note;   
		
	
	public String getNote()
	{
		return note;
	}
	
	public void setNote(String note)
	{
		this.note =  note;
	}
	
	private double price;   
		
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price =  price;
	}
	
	private String paid;   
		
	
	public String getPaid()
	{
		return paid;
	}
	
	public void setPaid(String paid)
	{
		this.paid =  paid;
	}
	
	private String howtouse;


	public String getHowtouse() {
		return howtouse;
	}

	public void setHowtouse(String howtouse) {
		this.howtouse = howtouse;
	}

	public String execute() throws Exception
    {
        try{

			String code = prescriptiondetailManager.genCode("");
			
        	Prescriptiondetail prescriptiondetail = new Prescriptiondetail();
			
			
			prescriptiondetail.setEncounter(encounterManager.getEncounter(encounter));
	
			prescriptiondetail.setDrug(drugManager.getDrug(drug));
			
			if (prescriptiondetail.getDrug().getForprescription().equalsIgnoreCase("N")){
				return "nodrug";				
			}
	
			prescriptiondetail.setQuantity(quantity);
			
			
			prescriptiondetail.setUnit(prescriptiondetail.getDrug().getUnit());
	
			prescriptiondetail.setTimeuse(timeuse);
	
			//prescriptiondetail.setQuantityuse(quantityuse);
	
			prescriptiondetail.setNote(note);
			prescriptiondetail.setUsageDescription(usageDescription);
			
	
			prescriptiondetail.setPrice(prescriptiondetail.getDrug().getPrice());
	
			prescriptiondetail.setPaid("N");
	
			prescriptiondetail.setHowtouse(howtouse);
			
        	prescriptiondetailManager.addPrescriptiondetail(prescriptiondetail);
			
			id = prescriptiondetail.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }
	 

	public double getQuantityuse() {
		return quantityuse;
	}

	public void setQuantityuse(double quantityuse) {
		this.quantityuse = quantityuse;
	}

	public String getUsageDescription() {
		return usageDescription;
	}

	public void setUsageDescription(String usageDescription) {
		this.usageDescription = usageDescription;
	}	
}
