
package com.ph.hms;

import java.util.*;

public class Druginvoice {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String tax;
	

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
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
	
	private double totalaftertax;   
		
	
	public double getTotalaftertax()
	{
		return totalaftertax;
	}
	
	public void setTotalaftertax(double totalaftertax)
	{
		this.totalaftertax =  totalaftertax;
	}
	
	private double vat;   
		
	
	public double getVat()
	{
		return vat;
	}
	
	public void setVat(double vat)
	{
		this.vat =  vat;
	}
	
	private Warehouse warehouse;   
		
	
	public Warehouse getWarehouse()
	{
		return warehouse;
	}
	
	public void setWarehouse(Warehouse warehouse)
	{
		this.warehouse =  warehouse;
	}
	
	private String identity;   
		
	
	public String getIdentity()
	{
		return identity;
	}
	
	public void setIdentity(String identity)
	{
		this.identity =  identity;
	}
	
	private Date date;   
		
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date =  date;
	}
	
	private User user;   
		
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user =  user;
	}
	
	private Paymenttype paymenttype;   
		
	
	public Paymenttype getPaymenttype()
	{
		return paymenttype;
	}
	
	public void setPaymenttype(Paymenttype paymenttype)
	{
		this.paymenttype =  paymenttype;
	}
	
	private double total;   
		
	
	public double getTotal()
	{
		return total;
	}
	
	public void setTotal(double total)
	{
		this.total =  total;
	}
	
	private String insurancenumber;   
		
	
	public String getInsurancenumber()
	{
		return insurancenumber;
	}
	
	public void setInsurancenumber(String insurancenumber)
	{
		this.insurancenumber =  insurancenumber;
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
	
	private String inpatient;   
		
	
	public String getInpatient()
	{
		return inpatient;
	}
	
	public void setInpatient(String inpatient)
	{
		this.inpatient =  inpatient;
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
	
	private String doctor;   
		
	
	public String getDoctor()
	{
		return doctor;
	}
	
	public void setDoctor(String doctor)
	{
		this.doctor =  doctor;
	}
	
	private String address;   
		
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address =  address;
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
	
	private String type;   
		
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type =  type;
	}
	
	private Warehouse towarehouse;   
		
	
	public Warehouse getTowarehouse()
	{
		return towarehouse;
	}
	
	public void setTowarehouse(Warehouse towarehouse)
	{
		this.towarehouse =  towarehouse;
	}
	
		private Collection<Druginvoicedetail> druginvoicedetails;   
			
		
		public Collection<Druginvoicedetail> getDruginvoicedetails()
		{
			return druginvoicedetails;
		}
		
		public void setDruginvoicedetails(Collection<Druginvoicedetail> druginvoicedetails)
		{
			this.druginvoicedetails =  druginvoicedetails;
		}
		
	private Provider provider;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	private String prepaidCard;

	public String getPrepaidCard() {
		return prepaidCard;
	}

	public void setPrepaidCard(String prepaidCard) {
		this.prepaidCard = prepaidCard;
	}
	
	private String paymentMethod;

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

}
