package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.management.loading.PrivateClassLoader;

import com.opensymphony.xwork.*;

public class ImportinvoiceFormAction extends ActionSupport
{	
	public String fname = "importinvoice";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Importinvoice importinvoice;
	
	private int id;	
		
   
	public Importinvoice getImportinvoice() {
		return importinvoice;
	}

	public void setImportinvoice(Importinvoice importinvoice) {
		this.importinvoice = importinvoice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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
	
	private ImportinvoiceManager importinvoiceManager;
	
	public ImportinvoiceManager getImportinvoiceManager() {
		return importinvoiceManager;
	}

	public void setImportinvoiceManager(ImportinvoiceManager importinvoiceManager) {
		this.importinvoiceManager = importinvoiceManager;
	}	
	
	private Collection<Importinvoice> importinvoices;
	
	public Collection<Importinvoice> getImportinvoices() {
		return importinvoices;
	}

	public void setImportinvoices(Collection<Importinvoice> importinvoices) {
		this.importinvoices = importinvoices;
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

	private double totalvat;
	
	private Collection<Importinvoicedetail> importinvoicedetails;

	private Importinvoicedetail imd;
	
	private ImportinvoicedetailManager importinvoicedetailManager;
	
	
	
	
	
	public ImportinvoicedetailManager getImportinvoicedetailManager() {
		return importinvoicedetailManager;
	}

	public void setImportinvoicedetailManager(
			ImportinvoicedetailManager importinvoicedetailManager) {
		this.importinvoicedetailManager = importinvoicedetailManager;
	}

	public Collection<Importinvoicedetail> getImportinvoicedetails() {
		return importinvoicedetails;
	}

	public void setImportinvoicedetails(
			Collection<Importinvoicedetail> importinvoicedetails) {
		this.importinvoicedetails = importinvoicedetails;
	}

	public Importinvoicedetail getImd() {
		return imd;
	}

	public void setImd(Importinvoicedetail imd) {
		this.imd = imd;
	}

	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
		
	importinvoices = (Collection<Importinvoice>)importinvoiceManager.getAllImportinvoices();
	
	
	users = (Collection<User>)userManager.getAllUsers();
	
	
	providers = (Collection<Provider>)providerManager.getAllProviders();
	
	
	warehouses = (Collection<Warehouse>)warehouseManager.getAllWarehouses();
	
	if( id == 0) {
		
		boolean matched = ds.checkRight(fname, anameAdd);

		if (matched == false) return "noprivilege";
		   
		code = importinvoiceManager.genCode("PN");
		
		Date d = new Date();
		
		DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
		today = sdf.format(d).toString();
		
		return SUCCESS;
		
	} else {
		boolean matched = ds.checkRight(fname, anameEdit);

		   if (matched == false) return "noprivilege";
	
        	importinvoice = importinvoiceManager.getImportinvoice(id);
        	
        	// sort
        	System.out.println("ImportInvoice lisl"+ importinvoice);
        	importinvoicedetails = new ArrayList<Importinvoicedetail>();
        	for(Importinvoicedetail imd :  importinvoice.getImportinvoicedetails())
        		{
        			importinvoicedetails.add(imd);

        		}
        		
        		Collections.sort((List<Importinvoicedetail>) importinvoicedetails);
        	
        	
        	totalvat = importinvoice.getTotal()*importinvoice.getVat()/100;
        	
        	return SUCCESS;
	}

  } catch(Exception e){
            System.out.println("Error ImportInvoice Form");
            e.printStackTrace();
            return ERROR;
        }       
    }

	public double getTotalvat() {
		return totalvat;
	}

	public void setTotalvat(double totalvat) {
		this.totalvat = totalvat;
	}	
}
