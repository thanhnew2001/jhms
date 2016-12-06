package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ImportinvoiceAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	
	
	private String type;   
		
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type =  type;
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
	
	private int provider;   
		
	
	public int getProvider()
	{
		return provider;
	}
	
	public void setProvider(int provider)
	{
		this.provider =  provider;
	}
	
	private int remain;   
		
	
	public int getRemain()
	{
		return remain;
	}
	
	public void setRemain(int remain)
	{
		this.remain =  remain;
	}
	
	private int totalexport;   
		
	
	public int getTotalexport()
	{
		return totalexport;
	}
	
	public void setTotalexport(int totalexport)
	{
		this.totalexport =  totalexport;
	}
	
	private int fromwarehouse;   
		
	
	public int getFromwarehouse()
	{
		return fromwarehouse;
	}
	
	public void setFromwarehouse(int fromwarehouse)
	{
		this.fromwarehouse =  fromwarehouse;
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
	
	private int user;   
		
	
	public int getUser()
	{
		return user;
	}
	
	public void setUser(int user)
	{
		this.user =  user;
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
	
	private int warehouse;   
		
	
	public int getWarehouse()
	{
		return warehouse;
	}
	
	public void setWarehouse(int warehouse)
	{
		this.warehouse =  warehouse;
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
	
	private Date date;   
		
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date =  date;
	}
	
	private int druginvoice;
	
	public  int getDruginvoice() {
		return druginvoice;
	}
	
	private DruginvoiceManager druginvoiceManager;	
	

	public  DruginvoiceManager getDruginvoiceManager() {
		return druginvoiceManager;
	}

	public  void setDruginvoiceManager(
			DruginvoiceManager druginvoiceManager) {
		this.druginvoiceManager = druginvoiceManager;
	}

	public  void setDruginvoice(int druginvoice) {
		this.druginvoice = druginvoice;
	}
	
	private ImportinvoicedetailManager importinvoicedetailManager;	
	
	
	public  ImportinvoicedetailManager getImportinvoicedetailManager() {
		return importinvoicedetailManager;
	}

	public  void setImportinvoicedetailManager(
			ImportinvoicedetailManager importinvoicedetailManager) {
		this.importinvoicedetailManager = importinvoicedetailManager;
	}
	

	public String execute() throws Exception
    {
        try{

			String code = importinvoiceManager.genCode("PN");
			
        	Importinvoice importinvoice = new Importinvoice();
			
			
			importinvoice.setType(type);
	
			importinvoice.setTotalaftertax(totalaftertax);
	
			importinvoice.setVat(vat);
	
			importinvoice.setProvider(providerManager.getProvider(provider));
	
			importinvoice.setRemain(remain);
	
			importinvoice.setTotalexport(totalexport);
	
			importinvoice.setFromwarehouse(warehouseManager.getWarehouse(fromwarehouse));
	
			importinvoice.setNode(node);
	
			importinvoice.setUser(userManager.getUser(user));
			
			importinvoice.setTotal(total);
	
			importinvoice.setWarehouse(warehouseManager.getWarehouse(warehouse));
	
			importinvoice.setCode(code);
	
			importinvoice.setDate(date);
			
			Druginvoice di = new Druginvoice();
			
			if (druginvoice > 0 && di != null)
			{
				di = druginvoiceManager.getDruginvoice(druginvoice);
				di.setTotalaftertax(totalaftertax);
				
				importinvoice.setDruginvoice(di);
			}
	
			importinvoiceManager.addImportinvoice(importinvoice);
			
			id = importinvoice.getId();
			
			

			//now add druginvoice detail to import invoice 
			if (druginvoice > 0 && di != null)
			{
				for (Druginvoicedetail did: di.getDruginvoicedetails())
				{
					Importinvoicedetail iid = new Importinvoicedetail();
					iid.setImportinvoice(importinvoice);
					iid.setDrug(did.getDrug());
					iid.setBatchnumber(did.getBatchnumber());
					iid.setExpireddate(did.getExpireddate());
					iid.setExpiredmonth(did.getExpiredmonth());
					iid.setQuantity(did.getQuantity());
					iid.setPrice(did.getPrice());
					iid.setSubtotal(did.getSubtotal());
					
					importinvoicedetailManager.addImportinvoicedetail(iid);
				}
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
