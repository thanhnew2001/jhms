package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetImportinvoiceByWarehouseAction extends ActionSupport
{
	
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
		
	
	private ImportinvoiceManager importinvoiceManager;
	
	public ImportinvoiceManager getImportinvoiceManager() {
		return importinvoiceManager;
	}

	public void setImportinvoiceManager(ImportinvoiceManager importinvoiceManager) {
		this.importinvoiceManager = importinvoiceManager;
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

	
	private Collection<Importinvoice> importinvoices;
	
	public Collection<Importinvoice> getImportinvoices() {
		return importinvoices;
	}

	public void setImportinvoices(Collection<Importinvoice> importinvoices) {
		this.importinvoices = importinvoices;
	}	
	
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	

public String execute() throws Exception
{
   try{

   	   i18n = i18nManager.geti18n();	
   
	   Map session = ActionContext.getContext().getSession();
	   
	   session.put("warehouse_id", id);
	   
	   Warehouse warehouse = warehouseManager.getWarehouse(id);
	   
	   
		users = (Collection<User>)userManager.getAllUsers();		
		
		providers = (Collection<Provider>)providerManager.getAllProviders();		
		
		warehouses = (Collection<Warehouse>)warehouseManager.getAllWarehouses();		
		
	   
	   if (warehouse != null)
	   {
	   		session.put("warehouse_node", warehouseManager.getWarehouse(id).getNode());
			importinvoices = warehouse.getImportinvoices();
	   }
	   else
	   {
		    importinvoices = (Collection<Importinvoice>)importinvoiceManager.getAllImportinvoices();
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
