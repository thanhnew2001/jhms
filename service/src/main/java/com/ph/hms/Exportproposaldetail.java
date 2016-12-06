
package com.ph.hms;

import java.util.*;

public class Exportproposaldetail {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Exportproposal exportproposal;   
		
	
	public Exportproposal getExportproposal()
	{
		return exportproposal;
	}
	
	public void setExportproposal(Exportproposal exportproposal)
	{
		this.exportproposal =  exportproposal;
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
	
}
