package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DruginvoiceUpdateAction extends ActionSupport
{
	public String fname = "druginvoice";
	public String aname = "update";
	
	private DruginvoiceManager druginvoiceManager;
	
	public DruginvoiceManager getDruginvoiceManager() {
		return druginvoiceManager;
	}

	public void setDruginvoiceManager(DruginvoiceManager druginvoiceManager) {
		this.druginvoiceManager = druginvoiceManager;
	}	
	
	private Collection<Druginvoice> druginvoices;
	
	public Collection<Druginvoice> getDruginvoices() {
		return druginvoices;
	}

	public void setDruginvoices(Collection<Druginvoice> druginvoices) {
		this.druginvoices = druginvoices;
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
	
	private WarehouseManager warehouseManager;
	
	public WarehouseManager getWarehouseManager() {
		return warehouseManager;
	}

	public void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}	
	
	private Collection<Warehouse> warehouses;
	
	public Collection<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Collection<Warehouse> warehouses) {
		this.warehouses = warehouses;
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
	
	private int warehouse;   
		
	
	public int getWarehouse()
	{
		return warehouse;
	}
	
	public void setWarehouse(int warehouse)
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
	
	private int user;   
		
	
	public int getUser()
	{
		return user;
	}
	
	public void setUser(int user)
	{
		this.user =  user;
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
	
	private int encounter;   
		
	
	public int getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(int encounter)
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
	
	private int towarehouse;   
		
	
	public int getTowarehouse()
	{
		return towarehouse;
	}
	
	public void setTowarehouse(int towarehouse)
	{
		this.towarehouse =  towarehouse;
	}
	
	private ProviderManager providerManager;
	
	private String prepaidCard;
	
	private int provider;

	public ProviderManager getProviderManager() {
		return providerManager;
	}

	public void setProviderManager(ProviderManager providerManager) {
		this.providerManager = providerManager;
	}

	public int getProvider() {
		return provider;
	}

	public void setProvider(int provider) {
		this.provider = provider;
	}
	
	private String paymentMethod;
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String execute() throws Exception
    {
        try{
        	
     	   DefaultSecurity ds = new DefaultSecurity();
       	   
       	   boolean matched = ds.checkRight(fname, aname);  
       	     
       	   if (matched == false) return "noprivilege";

        	Druginvoice druginvoice = druginvoiceManager.getDruginvoice(id);
			
			druginvoice.setNode(node);
	
			druginvoice.setTotalaftertax(totalaftertax);
	
			druginvoice.setVat(vat);
	
			druginvoice.setWarehouse(warehouseManager.getWarehouse(warehouse));
	
			druginvoice.setIdentity(identity);
	
			druginvoice.setDate(date);
	
			druginvoice.setUser(userManager.getUser(user));
	
			druginvoice.setPaymenttype(paymenttypeManager.getPaymenttype(paymenttype));
	
			druginvoice.setTotal(total);
	
			druginvoice.setInsurancenumber(insurancenumber);
	
			druginvoice.setExpireddate(expireddate);
	
			druginvoice.setInpatient(inpatient);
	
			druginvoice.setCode(code);
	
			druginvoice.setDoctor(doctor);
	
			druginvoice.setAddress(address);
	
			druginvoice.setEncounter(encounterManager.getEncounter(encounter));
	
			druginvoice.setType(type);
	
			druginvoice.setTowarehouse(warehouseManager.getWarehouse(towarehouse));
	
			druginvoice.setNode(node);
	
	
			druginvoice.setWarehouse(warehouseManager.getWarehouse(warehouse));
	
			druginvoice.setIdentity(identity);
	
			druginvoice.setDate(date);
	
			druginvoice.setUser(userManager.getUser(user));
	
			druginvoice.setPaymenttype(paymenttypeManager.getPaymenttype(paymenttype));
	
			druginvoice.setInsurancenumber(insurancenumber);
	
			druginvoice.setExpireddate(expireddate);
	
			druginvoice.setInpatient(inpatient);
	
			druginvoice.setCode(code);
	
			druginvoice.setDoctor(doctor);
	
			druginvoice.setAddress(address);
	
			druginvoice.setEncounter(encounterManager.getEncounter(encounter));
	
			druginvoice.setType(type);
			
			druginvoice.setPaymentMethod(paymentMethod);
			
			druginvoice.setPrepaidCard(prepaidCard);
			

			if (paymentMethod.equalsIgnoreCase("TU"))
			{
				druginvoice.setPrepaidCard(druginvoice.getEncounter().getPrepaidCard());
			}	
			
			druginvoice.setVat(vat);
			
			
			for(Druginvoicedetail dd: druginvoice.getDruginvoicedetails())
			{
				total += dd.getSubtotal();
			}
	
			totalaftertax = total*((vat+100)/100);
			
			druginvoice.setTotal(total);
			druginvoice.setTotalaftertax(totalaftertax);			
			
			druginvoice.setTowarehouse(warehouseManager.getWarehouse(towarehouse));
			
			druginvoice.setProvider(providerManager.getProvider(provider));				
			
        	druginvoiceManager.updateDruginvoice(druginvoice);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }

	public String getPrepaidCard() {
		return prepaidCard;
	}

	public void setPrepaidCard(String prepaidCard) {
		this.prepaidCard = prepaidCard;
	}	
}
