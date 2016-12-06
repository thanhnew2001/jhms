package com.ph.hms.action;
import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.text.*;


import com.opensymphony.xwork.*;

public class ReceiptdetailListAction extends ActionSupport
{
	public String fname = "receiptdetail";
	public String aname = "list";
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	

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


public String execute() throws Exception
{
   try{
	   i18n = i18nManager.geti18n();	

	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);
  
	     
	   if (matched == false) return "noprivilege";

       receiptdetails = (Collection<Receiptdetail>)receiptdetailManager.getAllReceiptdetails();
	   
	   
	receiptdetails = (Collection<Receiptdetail>)receiptdetailManager.getAllReceiptdetails();
	
	
	services = (Collection<Service>)serviceManager.getAllServices();
	
	
	drugs = (Collection<Drug>)drugManager.getAllDrugs();
	
	
	receipts = (Collection<Receipt>)receiptManager.getAllReceipts();
	
	
	doctors = (Collection<Doctor>)doctorManager.getAllDoctors();
	
	
		
		Date d = new Date();
	
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
		today = sdf.format(d).toString();
		
        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}	
}
