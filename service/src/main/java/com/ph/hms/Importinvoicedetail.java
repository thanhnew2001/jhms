
package com.ph.hms;

import java.util.*;

public class Importinvoicedetail implements Comparable<Importinvoicedetail> {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Importinvoice importinvoice;   
		
	
	public Importinvoice getImportinvoice()
	{
		return importinvoice;
	}
	
	public void setImportinvoice(Importinvoice importinvoice)
	{
		this.importinvoice =  importinvoice;
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
	
	private Date expireddate;   
		
	
	public Date getExpireddate()
	{
		return expireddate;
	}
	
	public void setExpireddate(Date expireddate)
	{
		this.expireddate =  expireddate;
	}
	
	private String expiredmonth;
	
	
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private double discount;   
		
	
	public double getDiscount()
	{
		return discount;
	}
	
	public void setDiscount(double discount)
	{
		this.discount =  discount;
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
	
	private double subtotal;   
		
	
	public double getSubtotal()
	{
		return subtotal;
	}
	
	public void setSubtotal(double subtotal)
	{
		this.subtotal =  subtotal;
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
	
	private String batchnumber;   
		
	
	public String getBatchnumber()
	{
		return batchnumber;
	}
	
	public void setBatchnumber(String batchnumber)
	{
		this.batchnumber =  batchnumber;
	}

	public String getExpiredmonth() {
		return expiredmonth;
	}

	public void setExpiredmonth(String expiredmonth) {
		this.expiredmonth = expiredmonth;
	}

	private String visaNo;

	public String getVisaNo() {
		return visaNo;
	}

	public void setVisaNo(String visaNo) {
		this.visaNo = visaNo;
	}

	public int compareTo(Importinvoicedetail o) {		
		return this.id-o.id;
	}
	
	

	
}
