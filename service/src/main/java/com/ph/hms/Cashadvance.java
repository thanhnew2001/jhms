
package com.ph.hms;

import java.util.*;

public class Cashadvance {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Encounter encounter;   
		
	
	public Encounter getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(Encounter encounter)
	{
		this.encounter =  encounter;
	}
	
	private Date node;   
		
	
	public Date getNode()
	{
		return node;
	}
	
	public void setNode(Date node)
	{
		this.node =  node;
	}
	
	private double amount;   
		
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double amount)
	{
		this.amount =  amount;
	}
	
	private String code;   
		
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
	}
	
	private String type;   
		
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type =  type;
	}
	
}
