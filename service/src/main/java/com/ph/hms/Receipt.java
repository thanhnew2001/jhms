
package com.ph.hms;

import java.util.*;

public class Receipt {

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
	
	private String code;   
		
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
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
	
	private double total;   
		
	
	public double getTotal()
	{
		return total;
	}
	
	public void setTotal(double total)
	{
		this.total =  total;
	}
	
	private String paymentmethod;   
		
	
	public String getPaymentmethod()
	{
		return paymentmethod;
	}
	
	public void setPaymentmethod(String paymentmethod)
	{
		this.paymentmethod =  paymentmethod;
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
	
	private User user;   
		
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user =  user;
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
	
	private String payfor;   
		
	
	public String getPayfor()
	{
		return payfor;
	}
	
	public void setPayfor(String payfor)
	{
		this.payfor =  payfor;
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
	
	private double insurancepay;   
		
	
	public double getInsurancepay()
	{
		return insurancepay;
	}
	
	public void setInsurancepay(double insurancepay)
	{
		this.insurancepay =  insurancepay;
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
	
	private Date birthday;   
		
	
	public Date getBirthday()
	{
		return birthday;
	}
	
	public void setBirthday(Date birthday)
	{
		this.birthday =  birthday;
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
	
	private int age;   
		
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age =  age;
	}
	
	private String phone;   
		
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone =  phone;
	}
	
		private Collection<Receiptdetail> receiptdetails;   
			
		
		public Collection<Receiptdetail> getReceiptdetails()
		{
			return receiptdetails;
		}
		
		public void setReceiptdetails(Collection<Receiptdetail> receiptdetails)
		{
			this.receiptdetails =  receiptdetails;
		}
	
	private String note;

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	private String prepaidCard;

	public String getPrepaidCard() {
		return prepaidCard;
	}

	public void setPrepaidCard(String prepaidCard) {
		this.prepaidCard = prepaidCard;
	}
	
	
	
		
}
