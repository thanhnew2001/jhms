package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class DruginvoiceFormAction extends ActionSupport
{	
	public String fname = "druginvoice";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Druginvoice druginvoice;
		
	public Druginvoice getDruginvoice() {
		return druginvoice;
	}

	public void setDruginvoice(Druginvoice druginvoice) {
		this.druginvoice = druginvoice;
	}

	private int id;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}	
	
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


	private ProviderManager providerManager;
	
	
	public ProviderManager getProviderManager() {
		return providerManager;
	}

	public void setProviderManager(ProviderManager providerManager) {
		this.providerManager = providerManager;
	}

	private Collection<Provider> providers; 
	
	
	
	public Collection<Provider> getProviders() {
		return providers;
	}

	public void setProviders(Collection<Provider> providers) {
		this.providers = providers;
	}

	private double totalvat;
	
	public double getTotalvat() {
		return totalvat;
	}

	public void setTotalvat(double totalvat) {
		this.totalvat = totalvat;
	}
	
	private Collection<Druginvoicedetail> druginvoicedetails;
	
		
	public Collection<Druginvoicedetail> getDruginvoicedetails() {
		return druginvoicedetails;
	}

	public void setDruginvoicedetails(
			Collection<Druginvoicedetail> druginvoicedetails) {
		this.druginvoicedetails = druginvoicedetails;
	}

	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();		

		paymenttypes = (Collection<Paymenttype>)paymenttypeManager.getAllPaymenttypes();
		
		users = (Collection<User>)userManager.getAllUsers();
		
		warehouses = (Collection<Warehouse>)warehouseManager.getAllWarehouses();
		
		//action to AddForm or EditForm
		if( id == 0){	//AddForm
			
			boolean matched = ds.checkRight(fname, anameAdd);
	
			if (matched == false) return "noprivilege";
		
			Date d = new Date();
			
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
			today = sdf.format(d).toString();
			
			
		} else {	//EditForm
			
			boolean matched = ds.checkRight(fname, anameEdit);
	
			if (matched == false) return "noprivilege";
			
	        druginvoice = druginvoiceManager.getDruginvoice(id);
	        	
	        totalvat = druginvoice.getTotal()*druginvoice.getVat()/100;
	        
	        druginvoicedetails =  new ArrayList<Druginvoicedetail>();
	        
	        for(Druginvoicedetail di: druginvoice.getDruginvoicedetails())
	        {
	        	druginvoicedetails.add(di);
	        }
	        
	        Collections.sort((List<Druginvoicedetail>) druginvoicedetails);

		}
        	
        	return SUCCESS;

     }
     catch(Exception e){
        System.out.println("Loi drug invoice Form action");
        e.printStackTrace();
        return ERROR;
     }       
    }

		
}
