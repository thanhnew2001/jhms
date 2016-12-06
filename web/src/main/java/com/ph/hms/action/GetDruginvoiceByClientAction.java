package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetDruginvoiceByClientAction extends ActionSupport
{
	
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
		
		private ClientManager clientManager;
			
		public ClientManager getClientManager() {
			return clientManager;
		}
		
		public void setClientManager(ClientManager clientManager) {
			this.clientManager = clientManager;
		}	
		
		private Collection<Client> clients;
		
		public Collection<Client> getClients() {
			return clients;
		}
	
		public void setClients(Collection<Client> clients) {
			this.clients = clients;
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
		
	
	private DruginvoiceManager druginvoiceManager;
	
	public DruginvoiceManager getDruginvoiceManager() {
		return druginvoiceManager;
	}

	public void setDruginvoiceManager(DruginvoiceManager druginvoiceManager) {
		this.druginvoiceManager = druginvoiceManager;
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

	
	private Collection<Druginvoice> druginvoices;
	
	public Collection<Druginvoice> getDruginvoices() {
		return druginvoices;
	}

	public void setDruginvoices(Collection<Druginvoice> druginvoices) {
		this.druginvoices = druginvoices;
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
	   
	   session.put("client_id", id);
	   
	   Client client = clientManager.getClient(id);
	   
	   
		paymenttypes = (Collection<Paymenttype>)paymenttypeManager.getAllPaymenttypes();		
		
		clients = (Collection<Client>)clientManager.getAllClients();		
		
		encounters = (Collection<Encounter>)encounterManager.getAllEncounters(null);		
		
		users = (Collection<User>)userManager.getAllUsers();		
		
		warehouses = (Collection<Warehouse>)warehouseManager.getAllWarehouses();		
		
	   
	   if (client != null)
	   {
	   		session.put("client_node", clientManager.getClient(id).getNode());
			druginvoices = client.getDruginvoices();
	   }
	   else
	   {
		    druginvoices = (Collection<Druginvoice>)druginvoiceManager.getAllDruginvoices();
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
