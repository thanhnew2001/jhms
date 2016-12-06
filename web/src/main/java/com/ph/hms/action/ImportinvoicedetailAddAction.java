package com.ph.hms.action;
import java.util.*;
import java.sql.ResultSet;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ImportinvoicedetailAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	private ImportinvoicedetailManager importinvoicedetailManager;
	
	public ImportinvoicedetailManager getImportinvoicedetailManager() {
		return importinvoicedetailManager;
	}

	public void setImportinvoicedetailManager(ImportinvoicedetailManager importinvoicedetailManager) {
		this.importinvoicedetailManager = importinvoicedetailManager;
	}	
	
	private Collection<Importinvoicedetail> importinvoicedetails;
	
	public Collection<Importinvoicedetail> getImportinvoicedetails() {
		return importinvoicedetails;
	}

	public void setImportinvoicedetails(Collection<Importinvoicedetail> importinvoicedetails) {
		this.importinvoicedetails = importinvoicedetails;
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

	
	
	private int importinvoice;   
		
	
	public int getImportinvoice()
	{
		return importinvoice;
	}
	
	public void setImportinvoice(int importinvoice)
	{
		this.importinvoice =  importinvoice;
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
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private double discount;   
		
	
	public double getDiscount()
	{
		return discount;
	}
	
	public void setDiscount(double discount)
	{
		this.discount =  discount;
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
	
	private int drug;   
		
	
	public int getDrug()
	{
		return drug;
	}
	
	public void setDrug(int drug)
	{
		this.drug =  drug;
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
	
	private String visano;
	
	public String getExpiredmonth() {
		return expiredmonth;
	}

	public void setExpiredmonth(String expiredmonth) {
		this.expiredmonth = expiredmonth;
	}

	public String getVisano() {
		return visano;
	}

	public void setVisano(String visano) {
		this.visano = visano;
	}	
	
	private HMSDataManager hmsDataManager;
	

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}

	public String execute() throws Exception
    {
        try{

			String code = importinvoicedetailManager.genCode("");
			
        	Importinvoicedetail importinvoicedetail = new Importinvoicedetail();
			
			
			importinvoicedetail.setImportinvoice(importinvoiceManager.getImportinvoice(importinvoice));
	
			importinvoicedetail.setQuantity(quantity);
	
			importinvoicedetail.setExpireddate(expireddate);
			
			importinvoicedetail.setExpiredmonth(expiredmonth);
	
			importinvoicedetail.setNode(node);
	
			importinvoicedetail.setDiscount(discount);
			
			importinvoicedetail.setPrice(price);

			if(subtotal != 0){
				importinvoicedetail.setSubtotal(subtotal);
			
			}else {
	
					if(discount != 0){
						importinvoicedetail.setSubtotal(price*quantity - price*quantity*discount);
					} else {
						importinvoicedetail.setSubtotal(price*quantity);
					}

			}
	
			importinvoicedetail.setDrug(drugManager.getDrug(drug));
	
			importinvoicedetail.setBatchnumber(batchnumber);
			if(visano == null || visano.equals(""))
			{
				importinvoicedetail.setVisaNo(visano);
			}
			
        	importinvoicedetailManager.addImportinvoicedetail(importinvoicedetail);
			
			id = importinvoicedetail.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi addImportInvoiceDetail");
            e.printStackTrace();
            return ERROR;
        }       
    }


}
