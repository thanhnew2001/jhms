package com.ph.hms.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import java.sql.ResultSet;


import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.HMSDataManager;
import com.ph.hms.Importinvoice;
import com.ph.hms.ImportinvoiceManager;
import com.ph.hms.Provider;
import com.ph.hms.ProviderManager;
import com.ph.hms.User;
import com.ph.hms.UserManager;
import com.ph.hms.Warehouse;
import com.ph.hms.WarehouseManager;
import com.ph.hms.action.util.I18nManager;

public class ImportinvoiceFilterByMonthAction extends ActionSupport 
{
	
	private ImportinvoiceManager importinvoiceManager;
	
	public ImportinvoiceManager getImportinvoiceManager() {
		return importinvoiceManager;
	}

	public void setImportinvoiceManager(ImportinvoiceManager importinvoiceManager) {
		this.importinvoiceManager = importinvoiceManager;
	}
	
	
	private HMSDataManager hmsDataManager;
	
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

	
	private String typehead;	

	public String getTypehead() {
		return typehead;
	}

	public void setTypehead(String typehead) {
		this.typehead = typehead;
	}
	
	private String con;	
	
	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	private String warehouse;

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}
	
	private String date;
	
public  String getDate() {
		return date;
	}

	public  void setDate(String date) {
		this.date = date;
	}
	
	private String year;
	
	private String month;
public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

public String execute() throws Exception
{
   try
   {
	   i18n = i18nManager.geti18n();
	   
	   Map session = ActionContext.getContext().getSession();
	   
	   User user = (User)session.get("user");
	   
	   importinvoices = new ArrayList<Importinvoice>();
	   
	   String query = "select id " +
	   		"from importinvoice " +
	   		"where YEAR(importinvoice.date) = " + year + " and " +
	   				"MONTH(importinvoice.date) = " + month + " and " +
	   				"user = " + user.getId() +
	   		" order by importinvoice.date desc";
	   
	   ResultSet rs = hmsDataManager.getResultset(query);
	   
	   
	   while(rs.next())
	   {
		   importinvoices.add(importinvoiceManager.getImportinvoice(rs.getInt("id")));
		   
	   }
	   
	   /*
   	   i18n = i18nManager.geti18n();	
	   
	   if (flag!=null && flag.equalsIgnoreCase("filter")) {
			
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");					
						
				importinvoices = (Collection<Importinvoice>)importinvoiceManager.filterByWarehouseDateType( warehouseManager.getWarehouse (Integer.parseInt(warehouse)),  sdf.parse( date + " 12:00:00" ),  type );;
				
				
				return SUCCESS;
		}

		if (con != null)
		{
			if (con.equalsIgnoreCase("") )
			{
				importinvoices = (Collection<Importinvoice>)importinvoiceManager.filter(typehead);
			}
	
			else if (con.equalsIgnoreCase("All"))
			{
				importinvoices = (Collection<Importinvoice>)importinvoiceManager.filterAll(typehead);
			}
			else
			{
				importinvoices = (Collection<Importinvoice>)importinvoiceManager.filterByCon(con, typehead);
			}
		}
		else
		{
			importinvoices = (Collection<Importinvoice>)importinvoiceManager.filter(typehead);
		}
		
		
		Collection<Importinvoice> tmpimportinvoices = (ArrayList<Importinvoice>)importinvoiceManager.getAllImportinvoices();
   		
		   importinvoices = new ArrayList<Importinvoice>();
	       
		   	Map session = ActionContext.getContext().getSession();
			   
			User user = (User)session.get("user");
			
			Warehouse warehouse = user.getWarehouse();
			
			if (warehouse !=null && tmpimportinvoices!=null)
			{
			       for(Importinvoice d:tmpimportinvoices)
			       {
			    	   if(d.getWarehouse().getId() == warehouse.getId())
			    		   importinvoices.add(d);
			       }
			}
			*/
			

		return SUCCESS;

   }
    catch(Exception e)
    {
        System.out.println("Loi gi gi do");
        e.printStackTrace();
        return ERROR;
    }
       
}

public HMSDataManager getHmsDataManager() {
	return hmsDataManager;
}

public void setHmsDataManager(HMSDataManager hmsDataManager) {
	this.hmsDataManager = hmsDataManager;
}	
}
