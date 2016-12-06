package com.ph.hms.action;

import com.ph.hms.*;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.DrugManager;
import com.ph.hms.HMSDataManager;
import com.ph.hms.action.util.I18nManager;
import com.ph.hms.action.util.WarehouseCardDetail;

public class WarehouseCardAction extends ActionSupport 
{
	private int drugId;
	private Date startdate;
	private Date enddate;
	private HMSDataManager hmsDataManager;
	private DrugManager drugManager;
	private Collection<WarehouseCardDetail> warehouseCardDetails;
	private int warehouseId;
	private int tondau;
	private int ton;
	private Drug drug;
	private Collection<DrugGroup> druggroups;
	private int tongnhap;
	private int tongxuat;
	
	private String action;
	
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getDrugId() {
		return drugId;
	}

	public void setDrugId(int drugId) {
		this.drugId = drugId;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}

	public DrugManager getDrugManager() {
		return drugManager;
	}

	public void setDrugManager(DrugManager drugManager) {
		this.drugManager = drugManager;
	}

	public Collection<WarehouseCardDetail> getWarehouseCardDetails() {
		return warehouseCardDetails;
	}

	public void setWarehouseCardDetails(
			Collection<WarehouseCardDetail> warehouseCardDetails) {
		this.warehouseCardDetails = warehouseCardDetails;
	}

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public int getTondau() {
		return tondau;
	}

	public void setTondau(int tondau) {
		this.tondau = tondau;
	}

	public int getTon() {
		return ton;
	}

	public void setTon(int ton) {
		this.ton = ton;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	private String tax;
	
	private Warehouse warehouse;
	private WarehouseManager warehouseManager;
	private String batchnumber;

	
	public String execute() throws Exception
	{
		String q1="White", q="white";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		tongnhap = 0;
		tongxuat = 0;
		
		
		try
		{
			if(action!=null && action.equalsIgnoreCase("search"))
			{
				//System.out.println("")
				//druggroups
				druggroups = drugManager.getAllDrugGroups();
				
				return "search";
			}
			
			i18n = i18nManager.geti18n();
			
			System.out.println("bat dau");
			
			
			
			String s = sdf.format(startdate);
			String e = sdf.format(enddate);
			
			
			drug = drugManager.getDrug(drugId);
			warehouse = warehouseManager.getWarehouse(warehouseId);
	
			if (tax.equalsIgnoreCase(""))
			{
				q1 = "select " +
				"(select if( sum( quantity ) is null, 0, sum( quantity ) ) " +
				"from importinvoice iv inner join importinvoicedetail id on iv.id = id.importinvoice " +
				"where id.drug = " + drugId + " " +
				"and warehouse =  " + warehouseId + " " +
	
				"and iv.date < '" + s + "') " + 
				"- " +
				"(select if( sum( quantity ) is null, 0, sum( quantity ) ) " +
				"from druginvoice dv inner join druginvoicedetail dd on dv.id = dd.druginvoice " +
				"where dd.drug = " + drugId + " " +
				"and warehouse = " + warehouseId + " " +
			
				"and dv.date < '" + s + "') " + 
				"as tondau";
			}
			else
			{
				q1 = "select " +
						"(select if( sum( quantity ) is null, 0, sum( quantity ) ) " +
						"from importinvoice iv inner join importinvoicedetail id on iv.id = id.importinvoice " +
						"where id.drug = " + drugId + " " +
						"and warehouse =  " + warehouseId + " " +
						"and tax =  '" + tax + "' " +
						"and iv.date < '" + s + "') " + 
						"- " +
						"(select if( sum( quantity ) is null, 0, sum( quantity ) ) " +
						"from druginvoice dv inner join druginvoicedetail dd on dv.id = dd.druginvoice " +
						"where dd.drug = " + drugId + " " +
						"and warehouse = " + warehouseId + " " +
						"and tax = ' " + tax + " '" +
						"and dv.date < '" + s + "') " + 
						"as tondau";
			}
			
			ResultSet rs = hmsDataManager.getResultset(q1);
		
			if(rs.next())
			{
				tondau = rs.getInt("tondau");
			}
			
			System.out.println(rs.getInt("tondau"));
			
			System.out.println("Xong kq 1");
			
			ton = tondau;
			
			if(tax.equalsIgnoreCase(""))
			{
				q = "select customer,drug, batchnumber, visanumber, totalquantity, tDate, 0 as Nhap, code " +
				"from export_wcard where drug = " + drugId + " " +
				"and tDate between '" + s + "' and '" + e + "' " +  
				"and warehouse = " + warehouseId + " " +
				
				"UNION " +
				
				"select provider.node as customer, drug, batchnumber, visanumber, totalquantity, tDate, 1 as Nhap, code " +
				"from import_wcard inner join " +
				"provider " +
				"on import_wcard.customer = provider.id " +
				"where drug = " + drugId + " " +
				"and tDate between '" + s + "' and '" + e + "' " +
				
				"order by tDate";
			}
			else
			{
				q = "select customer,drug, batchnumber, visanumber, totalquantity, tDate, 0 as Nhap, code " +
						"from export_wcard where drug = " + drugId + " " +
						"and tDate between '" + s + "' and '" + e + "' " +  
						"and warehouse = " + warehouseId + " " +
						"and tax =  '"+ tax + "' " +
						"UNION " +
						
						"select provider.node as customer, drug, batchnumber, visanumber, totalquantity, tDate, 1 as Nhap, code " +
						"from import_wcard inner join " +
						"provider " +
						"on import_wcard.customer = provider.id " +
						"where drug = " + drugId + " " +
						"and tDate between '" + s + "' and '" + e + "' " +
						"and tax = '"+ tax + "' " +
						"order by tDate";
			}
			rs = hmsDataManager.getResultset(q);
			warehouseCardDetails = new ArrayList<WarehouseCardDetail>();
			System.out.println("bat dau sql"+ q );
			while(rs.next())
			{
				WarehouseCardDetail wd = new WarehouseCardDetail();
				wd.setCustomer(rs.getString("customer"));
				wd.setDrug(drugId);
				wd.setBatchnumber(rs.getString("batchnumber"));
				if(rs.getString("visanumber") != null)
				{
					wd.setVisanumber(rs.getString("visanumber"));
				}
				wd.setTotalquantity(rs.getInt("totalquantity"));
				wd.setDate(rs.getDate("tDate"));
				wd.setType(rs.getInt("Nhap"));
				
				if(wd.getType() == 1)
				{
					ton = ton + wd.getTotalquantity();
					tongnhap += wd.getTotalquantity();
				}
				else
				{
					ton = ton - wd.getTotalquantity();
					tongxuat += wd.getTotalquantity();
				}
				
				wd.setRemain(ton);
				wd.setCode(rs.getString("code"));
				/*
				if(rs.getDate("expireddate") != null)
				{
					wd.setExpireddate(sdf1.format(rs.getDate("expireddate")));
				}
				
				if(rs.getString("expiredmonth") != null)
				{
					wd.setExpiredmonth(rs.getString("expiredmonth"));
				}
				*/
				
				
				warehouseCardDetails.add(wd);				
			}
			
			System.out.println("Xong kq 2");
			
			System.out.println(q);
			System.out.println(warehouseCardDetails.size());

		}
		catch(Exception e)
		{
			System.out.println(q1);
			System.out.println(q);
			System.out.println("bi loi roi ku");
			
			e.printStackTrace();
			return ERROR;
		}
		
					
		
		
		
		
		
		return SUCCESS;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public WarehouseManager getWarehouseManager() {
		return warehouseManager;
	}

	public void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}

	

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	

	public String getBatchnumber() {
		return batchnumber;
	}

	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}

	public Collection<DrugGroup> getDruggroups() {
		return druggroups;
	}

	public void setDruggroups(Collection<DrugGroup> druggroups) {
		this.druggroups = druggroups;
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

	public int getTongnhap() {
		return tongnhap;
	}

	public void setTongnhap(int tongnhap) {
		this.tongnhap = tongnhap;
	}

	public int getTongxuat() {
		return tongxuat;
	}

	public void setTongxuat(int tongxuat) {
		this.tongxuat = tongxuat;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
}
