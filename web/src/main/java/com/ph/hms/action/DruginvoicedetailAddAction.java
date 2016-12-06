package com.ph.hms.action;

import java.util.*;
import java.sql.ResultSet;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DruginvoicedetailAddAction extends ActionSupport {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private DruginvoicedetailManager druginvoicedetailManager;

	public DruginvoicedetailManager getDruginvoicedetailManager() {
		return druginvoicedetailManager;
	}

	public void setDruginvoicedetailManager(
			DruginvoicedetailManager druginvoicedetailManager) {
		this.druginvoicedetailManager = druginvoicedetailManager;
	}

	private Collection<Druginvoicedetail> druginvoicedetails;

	public Collection<Druginvoicedetail> getDruginvoicedetails() {
		return druginvoicedetails;
	}

	public void setDruginvoicedetails(
			Collection<Druginvoicedetail> druginvoicedetails) {
		this.druginvoicedetails = druginvoicedetails;
	}

	private DrugManager drugManager;

	public DrugManager getDrugManager() {
		return drugManager;
	}

	public void setDrugManager(DrugManager drugManager) {
		this.drugManager = drugManager;
	}

	private Collection<Drug> drugs;

	public Collection<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Collection<Drug> drugs) {
		this.drugs = drugs;
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

	private int druginvoice;

	public int getDruginvoice() {
		return druginvoice;
	}

	public void setDruginvoice(int druginvoice) {
		this.druginvoice = druginvoice;
	}

	private int drug;

	public int getDrug() {
		return drug;
	}

	public void setDrug(int drug) {
		this.drug = drug;
	}

	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	private double subtotal;

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	private String batchnumber;

	public String getBatchnumber() {
		return batchnumber;
	}

	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}

	private Date expireddate;

	public Date getExpireddate() {
		return expireddate;
	}

	public void setExpireddate(Date expireddate) {
		this.expireddate = expireddate;
	}
	
	private String expiredmonth;

	public String getExpiredmonth() {
		return expiredmonth;
	}

	public void setExpiredmonth(String expiredmonth) {
		this.expiredmonth = expiredmonth;
	}

	public String execute() throws Exception {
		try {

			String code = druginvoicedetailManager.genCode("");

			Druginvoicedetail druginvoicedetail = new Druginvoicedetail();

			druginvoicedetail.setDruginvoice(druginvoiceManager
					.getDruginvoice(druginvoice));

			druginvoicedetail.setDrug(drugManager.getDrug(drug));
			
			if (druginvoicedetail.getDrug().getForprescription().equalsIgnoreCase("N")){
				return "nodrug";				
			}

			druginvoicedetail.setQuantity(quantity);
			
			if(druginvoicedetail.getDruginvoice().getProvider()!=null)
			{
				
				druginvoicedetail.setPrice(druginvoicedetail.getDrug().getCompanyprice());
			}
			else
			{
				druginvoicedetail.setPrice(druginvoicedetail.getDrug().getPrice());
			}
	
			
			druginvoicedetail.setSubtotal(druginvoicedetail.getQuantity()*druginvoicedetail.getPrice());

			druginvoicedetail.setBatchnumber(batchnumber);

			druginvoicedetail.setExpireddate(expireddate);
			
			druginvoicedetail.setExpiredmonth(expiredmonth);
			
			if (batchnumber != null) //user tu chon so lo va so date
			{
				druginvoicedetailManager
				.addDruginvoicedetail(druginvoicedetail); //only add if in-stock

				id = druginvoicedetail.getId();

				return SUCCESS;
			}

			//get batchnumber

			String sql = "select  batchnumber, expireddate, expiredmonth sum(if(quantity is null, 0, quantity)) as nhap , (select sum(quantity) from druginvoicedetail dd where dd.drug=d.drug and dd.batchnumber=d.batchnumber) as xuat, "
					+ " sum(if(quantity is null, 0,quantity)) - (select if(sum(quantity) is null, 0, sum(quantity)) from druginvoicedetail dd where dd.drug=d.drug and dd.batchnumber=d.batchnumber) as ton"
					+ " from importinvoicedetail d inner join importinvoice i on i.id=d.importinvoice"
					+ " where warehouse = "
					+ druginvoiceManager.getDruginvoice(druginvoice)
							.getWarehouse().getId()
					+ " and drug="
					+ druginvoicedetail.getDrug().getId()
					+ " group by  batchnumber, expireddate, expiredmonth order by expireddate";

			ResultSet rs = druginvoicedetailManager.getResultset(sql);

			List<Batchnumber> batchnumbers = new ArrayList<Batchnumber>();

			while (rs.next()) {

				if (rs.getInt("ton") > quantity)
				{
					Batchnumber bn = new Batchnumber();
					bn.setBatchnumber(rs.getString("batchnumber"));
					bn.setExpireddate(rs.getDate("expireddate"));
					bn.setExpireddate(rs.getDate("expiredmonth"));
					bn.setRemain(rs.getInt("ton"));					
					batchnumbers.add(bn);
					break;
				}				
				
			}

			if (batchnumbers.size() > 0) {
				Batchnumber bn = batchnumbers.get(0);

				druginvoicedetail.setBatchnumber(bn.getBatchnumber());
				druginvoicedetail.setExpireddate(bn.getExpireddate());
				if(druginvoicedetail.getDruginvoice().getProvider()!=null)
				{
					
					druginvoicedetail.setPrice(druginvoicedetail.getDrug().getCompanyprice());
				}
				else
				{
					druginvoicedetail.setPrice(druginvoicedetail.getDrug().getPrice());
				}
				
				
				druginvoicedetailManager
						.addDruginvoicedetail(druginvoicedetail); //only add if in-stock

			} //if size
			else
				return "nodrug";

			id = druginvoicedetail.getId();

			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}
	}

	
}
