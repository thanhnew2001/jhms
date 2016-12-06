package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ReceiptUpdateAction extends ActionSupport
{
	public String fname = "receipt";
	public String aname = "update";
	
	private ReceiptManager receiptManager;
	
	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}	
	
	private Collection<Receipt> receipts;
	
	public Collection<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Collection<Receipt> receipts) {
		this.receipts = receipts;
	}	
	
	private PaymenttypeManager paymenttypeManager;
	
	public PaymenttypeManager getPaymenttypeManager() {
		return paymenttypeManager;
	}

	public void setPaymenttypeManager(PaymenttypeManager paymenttypeManager) {
		this.paymenttypeManager = paymenttypeManager;
	}	
	
	private Collection<Paymenttype> paymenttypes;
	
	public Collection<Paymenttype> getPaymenttypes() {
		return paymenttypes;
	}

	public void setPaymenttypes(Collection<Paymenttype> paymenttypes) {
		this.paymenttypes = paymenttypes;
	}	
	
	private EncounterManager encounterManager;
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}	
	
	private Collection<Encounter> encounters;
	
	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
	}	
	
	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}	
	
	private Collection<User> users;
	
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}	
	
	private Hashtable<String, String> i18n;			
		
	public Hashtable<String, String> getI18n() {			  		   
		return i18n;
	}
		
	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}
		
	private I18nManager i18nManager;			
		
	public I18nManager getI18nManager() {
		return i18nManager;
	}
		
	public void setI18nManager(I18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}

	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	private int encounter;   
		
	
	public int getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(int encounter)
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
	
	private int user;   
		
	
	public int getUser()
	{
		return user;
	}
	
	public void setUser(int user)
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
	
	private int paymenttype;   
		
	
	public int getPaymenttype()
	{
		return paymenttype;
	}
	
	public void setPaymenttype(int paymenttype)
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
	private String prepaidCard;
	
	public String getPrepaidCard() {
		return prepaidCard;
	}

	public void setPrepaidCard(String prepaidCard) {
		this.prepaidCard = prepaidCard;
	}

	public String execute() throws Exception
    {
        try{
        	
     	   DefaultSecurity ds = new DefaultSecurity();
       	   
       	   boolean matched = ds.checkRight(fname, aname);  
       	     
       	   if (matched == false) return "noprivilege";

        	Receipt receipt = receiptManager.getReceipt(id);
			
			
			receipt.setEncounter(encounterManager.getEncounter(encounter));
	
			receipt.setCode(code);
	
			receipt.setNode(node);
	
			receipt.setPaymentmethod(paymentmethod);
			
			if (paymentmethod.equalsIgnoreCase("TU"))
			{
				receipt.setPrepaidCard(receipt.getEncounter().getPrepaidCard());
			}	
			if (paymentmethod.equalsIgnoreCase("TT"))
			{
				receipt.setPrepaidCard(prepaidCard);
			}	
	
			receipt.setDiscount(discount);
	
			receipt.setUser(userManager.getUser(user));
	
			receipt.setDate(date);
	
			receipt.setPayfor(payfor);

			receipt.setPaymenttype(paymenttypeManager.getPaymenttype(paymenttype));
	
			receipt.setBirthday(birthday);
	
			receipt.setAddress(address);
	
			receipt.setAge(age);
	
			receipt.setPhone(phone);
			
		
	
			receipt.setEncounter(encounterManager.getEncounter(encounter));
	
			for(Receiptdetail dd: receipt.getReceiptdetails())
			{
				/*
				int serviceGroupId =  dd.getService().getServicegroup().getId();
				if(serviceGroupId <= 31)
				{
					dd.setPercentdiscount(20);
					dd.setDiscount(dd.getQuantity()*dd.getService().getPrice()*dd.getPercentdiscount()/100);
				}
				*/
				
				//total += dd.getSubtotal()-dd.getDiscount();
				
				
				total += dd.getSubtotal();
			}	
			receipt.setTotal(total);
			receiptManager.updateReceipt(receipt);

        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
