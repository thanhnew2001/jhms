
package com.ph.hms;

import java.util.*;

public class Prescriptiontemplatedetail {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Prescriptiontemplate prescriptiontemplate;   
		
	
	public Prescriptiontemplate getPrescriptiontemplate()
	{
		return prescriptiontemplate;
	}
	
	public void setPrescriptiontemplate(Prescriptiontemplate prescriptiontemplate)
	{
		this.prescriptiontemplate =  prescriptiontemplate;
	}
	
	private Drug drug;   
		
	
	public Drug getDrug()
	{
		return drug;
	}
	
	public void setDrug(Drug drug)
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
	
}
