package com.ph.hms.action;
import java.util.*;
import java.sql.ResultSet;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DrugAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
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
	
	private String ingredient;   
		
	
	public String getIngredient()
	{
		return ingredient;
	}
	
	public void setIngredient(String ingredient)
	{
		this.ingredient =  ingredient;
	}
	
	private String indication;   
		
	
	public String getIndication()
	{
		return indication;
	}
	
	public void setIndication(String indication)
	{
		this.indication =  indication;
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
	
	private String insurance;   
		
	
	public String getInsurance()
	{
		return insurance;
	}
	
	public void setInsurance(String insurance)
	{
		this.insurance =  insurance;
	}
	private double companyprice;
	
	public double getCompanyprice() {
		return companyprice;
	}

	public void setCompanyprice(double companyprice) {
		this.companyprice = companyprice;
	} 

	private String forprescription;
	 
	public String getForprescription() {
			return forprescription;
		}

		public void setForprescription(String forprescription) {
			this.forprescription = forprescription;
		}
	private int drugGroup;
	
	

	public int getDrugGroup() {
		return drugGroup;
	}

	public void setDrugGroup(int drugGroup) {
		this.drugGroup = drugGroup;
	}
	private String genericName;

	
	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String execute() throws Exception
    {
        try{
        	
			String code = drugManager.genCode("");
			
        	Drug drug = new Drug();
			
			drug.setNode(node);
	
			drug.setUnit(unit);
	
			drug.setIngredient(ingredient);
	
			drug.setIndication(indication);
	
			drug.setPrice(price);
			
			drug.setCompanyprice(companyprice);
			
			drug.setForprescription(forprescription);
	
			drug.setInsurance(insurance);
			
			drug.setGenericName(genericName);
			
			drug.setDrugGroup(drugManager.getDrugGroup(drugGroup));
			
        	drugManager.addDrug(drug);
        	
        			
			id = drug.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }

	
	
}
