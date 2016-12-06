package com.ph.hms.action;

import java.util.*;
import java.sql.ResultSet;
import java.text.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DruginvoiceFilterByMonthAction extends ActionSupport 
{
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

	private String warehouse;

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private HMSDataManager hmsDataManager;

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
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
	private String tax;
	

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
	private Druginvoice dg;

	
	public Druginvoice getDg() {
		return dg;
	}

	public void setDg(Druginvoice dg) {
		this.dg = dg;
	}

	public String execute() throws Exception {
		try {
			i18n = i18nManager.geti18n();
			   
			Map session = ActionContext.getContext().getSession();
		   
			User user = (User)session.get("user");
			
			druginvoices = new ArrayList<Druginvoice>();
			System.out.println("druginvoicefilterBy Month before select");
			System.out.println(month);

			
			String query = "select id " +
	   		"from druginvoice " +
	   		"where YEAR(druginvoice.date) = " + year + " and " +
	   				"MONTH(druginvoice.date) = " + month + " and " +
	   				"druginvoice.tax = '" + tax + "' and " +
	   				"user = " + user.getId() +
	   		" order by druginvoice.date desc";
			
			System.out.println(query);
			ResultSet rs = hmsDataManager.getResultset(query);
			
			while(rs.next())
			{
				druginvoices.add(druginvoiceManager.getDruginvoice(rs.getInt("id")));
	
			}
			System.out.println("druginvoicefilterBy Month after select");
			/*
			if (flag != null && flag.equalsIgnoreCase("filter")) {

				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

				druginvoices = (Collection<Druginvoice>) druginvoiceManager
						.filterByWarehouseDateType(warehouseManager
								.getWarehouse(Integer.parseInt(warehouse)), sdf
								.parse(date + " 12:00:00"), type);
				;
				return SUCCESS;
			}
			

			if (flag != null && flag.equalsIgnoreCase("notimported")) {

				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

				ResultSet rs = hmsDataManager
						.getResultset("select id from druginvoice where type='NB' and id not in (select if(druginvoice is null, 0, druginvoice) from importinvoice)");

				druginvoices = new ArrayList<Druginvoice>();

				while (rs.next()) {
					druginvoices.add(druginvoiceManager.getDruginvoice(rs
							.getInt("id")));
					System.out.println("in while" + druginvoices.size());
				}

				return SUCCESS;
			}

			if (con != null) {
				if (con.equalsIgnoreCase("")) {
					druginvoices = (Collection<Druginvoice>) druginvoiceManager
							.filter(typehead);
				}

				else if (con.equalsIgnoreCase("All")) {
					druginvoices = (Collection<Druginvoice>) druginvoiceManager
							.filterAll(typehead);
				} else {
					druginvoices = (Collection<Druginvoice>) druginvoiceManager
							.filterByCon(con, typehead);
				}
			} else {
				druginvoices = (Collection<Druginvoice>) druginvoiceManager
						.filter(typehead);
			}

			Collection<Druginvoice> tmpdruginvoices = (ArrayList<Druginvoice>) druginvoiceManager
					.getAllDruginvoices();

			druginvoices = new ArrayList<Druginvoice>();

			Map session = ActionContext.getContext().getSession();

			User user = (User) session.get("user");

			Warehouse warehouse = user.getWarehouse();

			if (warehouse != null && tmpdruginvoices != null) {
				for (Druginvoice d : tmpdruginvoices) {
					if (d.getWarehouse().getId() == warehouse.getId())
						druginvoices.add(d);
				}
			}
			*/

			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Error DruginvoiceFilterByMonth");
			e.printStackTrace();
			return ERROR;
		}

	}

}
