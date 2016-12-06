
package com.ph.hms;

import java.util.*;

public class Importdetail {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	private Date expireddate;   
		
	
	public Date getExpireddate()
	{
		return expireddate;
	}
	
	public void setExpireddate(Date expireddate)
	{
		this.expireddate =  expireddate;
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
	
	private Drug drug;   
		
	
	public Drug getDrug()
	{
		return drug;
	}
	
	public void setDrug(Drug drug)
	{
		this.drug =  drug;
	}
	
	private Importcard importcard;   
		
	
	public Importcard getImportcard()
	{
		return importcard;
	}
	
	public void setImportcard(Importcard importcard)
	{
		this.importcard =  importcard;
	}
	
}
