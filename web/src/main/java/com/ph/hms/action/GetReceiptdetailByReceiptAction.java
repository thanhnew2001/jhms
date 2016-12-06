package com.ph.hms.action;
import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetReceiptdetailByReceiptAction extends ActionSupport
{
	
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
		
	
	private ReceiptdetailManager receiptdetailManager;
	
	public ReceiptdetailManager getReceiptdetailManager() {
		return receiptdetailManager;
	}

	public void setReceiptdetailManager(ReceiptdetailManager receiptdetailManager) {
		this.receiptdetailManager = receiptdetailManager;
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

	
	private Collection<Receiptdetail> receiptdetails;
	
	public Collection<Receiptdetail> getReceiptdetails() {
		return receiptdetails;
	}

	public void setReceiptdetails(Collection<Receiptdetail> receiptdetails) {
		this.receiptdetails = receiptdetails;
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
	   
	   session.put("receipt_id", id);
	   
	   Receipt receipt = receiptManager.getReceipt(id);
	   
	   
		services = (Collection<Service>)serviceManager.getAllServices();		
		
		drugs = (Collection<Drug>)drugManager.getAllDrugs();		
		
		receipts = (Collection<Receipt>)receiptManager.getAllReceipts();		
		
		doctors = (Collection<Doctor>)doctorManager.getAllDoctors();		
		
	   
	   if (receipt != null)
	   {
	   		session.put("receipt_node", receiptManager.getReceipt(id).getNode());
			receiptdetails = new ArrayList<Receiptdetail>();
			
			for(Receiptdetail rd: receipt.getReceiptdetails())
			{
				receiptdetails.add(rd);
			}
	   }
	   
	   Collections.sort((List<Receiptdetail>) receiptdetails);
	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}	
}
