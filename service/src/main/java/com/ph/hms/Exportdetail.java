
package com.ph.hms;

import java.util.*;

public class Exportdetail {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Date expireddate;   
		
	
	public Date getExpireddate()
	{
		return expireddate;
	}
	
	public void setExpireddate(Date expireddate)
	{
		this.expireddate =  expireddate;
	}
	
	private Exportcard exportcard;   
		
	
	public Exportcard getExportcard()
	{
		return exportcard;
	}
	
	public void setExportcard(Exportcard exportcard)
	{
		this.exportcard =  exportcard;
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
	
	private String batchnumber;   
		
	
	public String getBatchnumber()
	{
		return batchnumber;
	}
	
	public void setBatchnumber(String batchnumber)
	{
		this.batchnumber =  batchnumber;
	}
	
}
