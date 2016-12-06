package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DruginvoicedetailUpdateAction extends ActionSupport
{
	
	
	private DruginvoicedetailManager druginvoicedetailManager;
	
	public DruginvoicedetailManager getDruginvoicedetailManager() {
		return druginvoicedetailManager;
	}

	public void setDruginvoicedetailManager(DruginvoicedetailManager druginvoicedetailManager) {
		this.druginvoicedetailManager = druginvoicedetailManager;
	}	
	
	private Collection<Druginvoicedetail> druginvoicedetails;
	
	public Collection<Druginvoicedetail> getDruginvoicedetails() {
		return druginvoicedetails;
	}

	public void setDruginvoicedetails(Collection<Druginvoicedetail> druginvoicedetails) {
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

	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	private int druginvoice;   
		
	
	public int getDruginvoice()
	{
		return druginvoice;
	}
	
	public void setDruginvoice(int druginvoice)
	{
		this.druginvoice =  druginvoice;
	}
	
	private int drug;   
		
	
	public int getDrug()
	{
		return drug;
	}
	
	public void setDrug(int drug)
	{
		this.drug =  drug;
	}
	
	private int quantity;   
		
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity =  quantity;
	}
	
	private double price;   
		
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price =  price;
	}
	
	private double subtotal;   
		
	
	public double getSubtotal()
	{
		return subtotal;
	}
	
	public void setSubtotal(double subtotal)
	{
		this.subtotal =  subtotal;
	}
	
	private String batchnumber;   
		
	
	public String getBatchnumber()
	{
		return batchnumber;
	}
	
	public void setBatchnumber(String batchnumber)
	{
		this.batchnumber =  batchnumber;
	}
	
	private Date expireddate;   
		
	
	public Date getExpireddate()
	{
		return expireddate;
	}
	
	public void setExpireddate(Date expireddate)
	{
		this.expireddate =  expireddate;
	}
	
	private String expiredmonth;
	
	

	public String getExpiredmonth() {
		return expiredmonth;
	}

	public void setExpiredmonth(String expiredmonth) {
		this.expiredmonth = expiredmonth;
	}

	public String execute() throws Exception
    {
        try{

        	Druginvoicedetail druginvoicedetail = druginvoicedetailManager.getDruginvoicedetail(id);
			
			
			druginvoicedetail.setDruginvoice(druginvoiceManager.getDruginvoice(druginvoice));
	
			druginvoicedetail.setDrug(drugManager.getDrug(drug));
	
			druginvoicedetail.setQuantity(quantity);
			
			if(druginvoicedetail.getDruginvoice().getProvider()==null)
			{
				druginvoicedetail.setPrice(druginvoicedetail.getDrug().getPrice());
			}
			else
			{
				druginvoicedetail.setPrice(druginvoicedetail.getDrug().getCompanyprice());
			}
	
			druginvoicedetail.setSubtotal(druginvoicedetail.getQuantity()*druginvoicedetail.getPrice());
	
			druginvoicedetail.setBatchnumber(batchnumber);
	
			druginvoicedetail.setExpireddate(expireddate);
			
			druginvoicedetail.setExpiredmonth(expiredmonth);
	
			druginvoicedetail.setDruginvoice(druginvoiceManager.getDruginvoice(druginvoice));
	
			druginvoicedetail.setDrug(drugManager.getDrug(drug));
	
			druginvoicedetail.setQuantity(quantity);
	
			druginvoicedetail.setPrice(price);
	
			druginvoicedetail.setSubtotal(quantity*price);
	
			druginvoicedetail.setBatchnumber(batchnumber);
	
			druginvoicedetail.setExpireddate(expireddate);
	
			
        	druginvoicedetailManager.updateDruginvoicedetail(druginvoicedetail);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
