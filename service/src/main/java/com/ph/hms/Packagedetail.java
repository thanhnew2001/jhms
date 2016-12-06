
package com.ph.hms;

import java.util.*;

public class Packagedetail {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Serpackage serpackage;   
		
	
	public Serpackage getSerpackage()
	{
		return serpackage;
	}
	
	public void setSerpackage(Serpackage serpackage)
	{
		this.serpackage =  serpackage;
	}
	
	private Service service;   
		
	
	public Service getService()
	{
		return service;
	}
	
	public void setService(Service service)
	{
		this.service =  service;
	}
	
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
