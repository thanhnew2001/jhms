package com.ph.hms.action;
import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.text.*;


import com.opensymphony.xwork.*;

public class DruginvoiceListAction extends ActionSupport
{
	public String fname = "druginvoice";
	public String aname = "list";
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	
	
	private String curYear;
	
	public String getCurYear() {
		return today;
	}

	public void setCurYear(String year) {
		this.curYear = year;
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
	
	private Collection<Provider> providers;
	
	

public ProviderManager getProviderManager() {
		return providerManager;
	}

	public void setProviderManager(ProviderManager providerManager) {
		this.providerManager = providerManager;
	}

	public Collection<Provider> getProviders() {
		return providers;
	}

	public void setProviders(Collection<Provider> providers) {
		this.providers = providers;
	}

public String execute() throws Exception
{
   try{
	   i18n = i18nManager.geti18n();	

	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);
  
	     
	   if (matched == false) return "noprivilege";

       Collection<Druginvoice> tmpdruginvoices = (ArrayList<Druginvoice>)druginvoiceManager.getAllDruginvoices();
       
       druginvoices = new ArrayList<Druginvoice>();
       
	   	Map session = ActionContext.getContext().getSession();
		   
		User user = (User)session.get("user");
		
		Warehouse warehouse = user.getWarehouse();
		
		if (warehouse !=null && tmpdruginvoices!=null)
		{
		       for(Druginvoice d:tmpdruginvoices)
		       {
		    	   if(d.getWarehouse().getId() == warehouse.getId())
		    		   druginvoices.add(d);
		       }
		}
    	   

		
	/*paymenttypes = (Collection<Paymenttype>)paymenttypeManager.getAllPaymenttypes();
	
	encounters = (Collection<Encounter>)encounterManager.getAllEncounters(null);
	
	users = (Collection<User>)userManager.getAllUsers();
	*/
  	
	warehouses = (Collection<Warehouse>)warehouseManager.getAllWarehouses();
	
	providers = (Collection<Provider>)providerManager.getAllProviders();
		
		Date d = new Date();
	
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		today = sdf.format(d).toString();
		
	    Calendar cal=Calendar.getInstance();
	    curYear = Integer.toString(cal.get(Calendar.YEAR));
        System.out.println(curYear);

	     
	    for(Warehouse w:warehouses)
		{
			if(w != null)
				System.out.println(w.getNode());
		}
        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}	
}
