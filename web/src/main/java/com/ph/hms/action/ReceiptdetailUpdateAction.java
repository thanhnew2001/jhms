package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ReceiptdetailUpdateAction extends ActionSupport
{
	
	
	private ReceiptdetailManager receiptdetailManager;
	
	public ReceiptdetailManager getReceiptdetailManager() {
		return receiptdetailManager;
	}

	public void setReceiptdetailManager(ReceiptdetailManager receiptdetailManager) {
		this.receiptdetailManager = receiptdetailManager;
	}	
	
	private Collection<Receiptdetail> receiptdetails;
	
	public Collection<Receiptdetail> getReceiptdetails() {
		return receiptdetails;
	}

	public void setReceiptdetails(Collection<Receiptdetail> receiptdetails) {
		this.receiptdetails = receiptdetails;
	}	
	
	private ServiceManager serviceManager;
	
	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}	
	
	private Collection<Service> services;
	
	public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
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
	
	private ReceiptManager receiptManager;
	
	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}	
	
	private Collection<Receipt> receipts;
	
	public Collection<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Collection<Receipt> receipts) {
		this.receipts = receipts;
	}	
	
	private DoctorManager doctorManager;
	
	public DoctorManager getDoctorManager() {
		return doctorManager;
	}

	public void setDoctorManager(DoctorManager doctorManager) {
		this.doctorManager = doctorManager;
	}	
	
	private Collection<Doctor> doctors;
	
	public Collection<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Collection<Doctor> doctors) {
		this.doctors = doctors;
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
	
	
	private int receipt;   
		
	
	public int getReceipt()
	{
		return receipt;
	}
	
	public void setReceipt(int receipt)
	{
		this.receipt =  receipt;
	}
	
	private int service;   
		
	
	public int getService()
	{
		return service;
	}
	
	public void setService(int service)
	{
		this.service =  service;
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
	
	private String cancel;   
		
	
	public String getCancel()
	{
		return cancel;
	}
	
	public void setCancel(String cancel)
	{
		this.cancel =  cancel;
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
	
	private double percentdiscount;   
		
	
	public double getPercentdiscount()
	{
		return percentdiscount;
	}
	
	public void setPercentdiscount(double percentdiscount)
	{
		this.percentdiscount =  percentdiscount;
	}
	
	private int inddoctor;   
		
	
	public int getInddoctor()
	{
		return inddoctor;
	}
	
	public void setInddoctor(int inddoctor)
	{
		this.inddoctor =  inddoctor;
	}
	
	private double childunder6;   
		
	
	public double getChildunder6()
	{
		return childunder6;
	}
	
	public void setChildunder6(double childunder6)
	{
		this.childunder6 =  childunder6;
	}
	
	private double actualpay;   
		
	
	public double getActualpay()
	{
		return actualpay;
	}
	
	public void setActualpay(double actualpay)
	{
		this.actualpay =  actualpay;
	}
	
	private int exedoctor;   
		
	
	public int getExedoctor()
	{
		return exedoctor;
	}
	
	public void setExedoctor(int exedoctor)
	{
		this.exedoctor =  exedoctor;
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
	
	private double discount;   
		
	
	public double getDiscount()
	{
		return discount;
	}
	
	public void setDiscount(double discount)
	{
		this.discount =  discount;
	}
	
	private double insurancepay;   
		
	
	public double getInsurancepay()
	{
		return insurancepay;
	}
	
	public void setInsurancepay(double insurancepay)
	{
		this.insurancepay =  insurancepay;
	}
	
	private String note;
	
	
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String execute() throws Exception
    {
        try{

        	Receiptdetail receiptdetail = receiptdetailManager.getReceiptdetail(id);
			
			
			receiptdetail.setReceipt(receiptManager.getReceipt(receipt));
	
			receiptdetail.setService(serviceManager.getService(service));
	
			receiptdetail.setQuantity(quantity);
	
			receiptdetail.setPrice(price);
	
			receiptdetail.setCancel(cancel);
	
			receiptdetail.setDrug(drugManager.getDrug(drug));
	
			receiptdetail.setPercentdiscount(percentdiscount);
	
			receiptdetail.setInddoctor(doctorManager.getDoctor(inddoctor));
	
			receiptdetail.setChildunder6(childunder6);
	
			receiptdetail.setActualpay(actualpay);
	
			receiptdetail.setExedoctor(doctorManager.getDoctor(exedoctor));
	
			receiptdetail.setSubtotal(subtotal);
	
			receiptdetail.setDiscount(discount);
	
			receiptdetail.setInsurancepay(insurancepay);
	
			receiptdetail.setReceipt(receiptManager.getReceipt(receipt));
	
			receiptdetail.setService(serviceManager.getService(service));
	
			receiptdetail.setQuantity(quantity);
			
			receiptdetail.setNote(note);
	
			receiptdetail.setPrice(price);
	
			receiptdetail.setCancel(cancel);
	
			receiptdetail.setDrug(drugManager.getDrug(drug));
	
			receiptdetail.setPercentdiscount(percentdiscount);
	
			receiptdetail.setInddoctor(doctorManager.getDoctor(inddoctor));
	
			receiptdetail.setChildunder6(childunder6);
	
			receiptdetail.setActualpay(actualpay);
	
			receiptdetail.setExedoctor(doctorManager.getDoctor(exedoctor));
			receiptdetail.setDiscount(discount);
	
			receiptdetail.setSubtotal(receiptdetail.getPrice()*receiptdetail.getQuantity() - receiptdetail.getDiscount());			
	
			
	
			receiptdetail.setInsurancepay(insurancepay);
	
			
        	receiptdetailManager.updateReceiptdetail(receiptdetail);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
