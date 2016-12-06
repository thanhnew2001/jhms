
package com.ph.hms;

import java.util.*;

public class Receiptdetail implements Comparable<Receiptdetail> {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Receipt receipt;   
		
	
	public Receipt getReceipt()
	{
		return receipt;
	}
	
	public void setReceipt(Receipt receipt)
	{
		this.receipt =  receipt;
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
		
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity =  quantity;
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
	
	private String cancel;   
		
	
	public String getCancel()
	{
		return cancel;
	}
	
	public void setCancel(String cancel)
	{
		this.cancel =  cancel;
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
	
	private double percentdiscount;   
		
	
	public double getPercentdiscount()
	{
		return percentdiscount;
	}
	
	public void setPercentdiscount(double percentdiscount)
	{
		this.percentdiscount =  percentdiscount;
	}
	
	private Doctor inddoctor;   
		
	
	public Doctor getInddoctor()
	{
		return inddoctor;
	}
	
	public void setInddoctor(Doctor inddoctor)
	{
		this.inddoctor =  inddoctor;
	}
	
	private double childunder6;   
		
	
	public double getChildunder6()
	{
		return childunder6;
	}
	
	public void setChildunder6(double childunder6)
	{
		this.childunder6 =  childunder6;
	}
	
	private double actualpay;   
		
	
	public double getActualpay()
	{
		return actualpay;
	}
	
	public void setActualpay(double actualpay)
	{
		this.actualpay =  actualpay;
	}
	
	private Doctor exedoctor;   
		
	
	public Doctor getExedoctor()
	{
		return exedoctor;
	}
	
	public void setExedoctor(Doctor exedoctor)
	{
		this.exedoctor =  exedoctor;
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
	
	private double discount;   
		
	
	public double getDiscount()
	{
		return discount;
	}
	
	public void setDiscount(double discount)
	{
		this.discount =  discount;
	}
	
	private double insurancepay;   
		
	
	public double getInsurancepay()
	{
		return insurancepay;
	}
	
	public void setInsurancepay(double insurancepay)
	{
		this.insurancepay =  insurancepay;
	}
	
	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int compareTo(Receiptdetail o) {
		
		return this.id-o.id;
	}
	
	
	
}
