package com.ph.hms.action;
import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetImportinvoicedetailByImportinvoiceAction extends ActionSupport
{
	
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
		
	
	private ImportinvoicedetailManager importinvoicedetailManager;
	
	public ImportinvoicedetailManager getImportinvoicedetailManager() {
		return importinvoicedetailManager;
	}

	public void setImportinvoicedetailManager(ImportinvoicedetailManager importinvoicedetailManager) {
		this.importinvoicedetailManager = importinvoicedetailManager;
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

	
	private Collection<Importinvoicedetail> importinvoicedetails;
	
	public Collection<Importinvoicedetail> getImportinvoicedetails() {
		return importinvoicedetails;
	}

	public void setImportinvoicedetails(Collection<Importinvoicedetail> importinvoicedetails) {
		this.importinvoicedetails = importinvoicedetails;
	}	
	
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	private Importinvoicedetail imd;
	
	

public Importinvoicedetail getImd() {
		return imd;
	}

	public void setImd(Importinvoicedetail imd) {
		this.imd = imd;
	}

public String execute() throws Exception
{
   try{

   	   i18n = i18nManager.geti18n();	
   
	   Map session = ActionContext.getContext().getSession();
	   
	   session.put("importinvoice_id", id);
	   
	   Importinvoice importinvoice = importinvoiceManager.getImportinvoice(id);
	   
	   
		drugs = (Collection<Drug>)drugManager.getAllDrugs();		
		
		importinvoices = (Collection<Importinvoice>)importinvoiceManager.getAllImportinvoices();		
		
	   
	   if (importinvoice != null)
	   {
	   		session.put("importinvoice_node", importinvoiceManager.getImportinvoice(id).getNode());
			importinvoicedetails = importinvoice.getImportinvoicedetails();
			importinvoicedetails = new ArrayList<Importinvoicedetail>();
			for(Importinvoicedetail imd :  importinvoice.getImportinvoicedetails())
	   		{
				importinvoicedetails.add(imd);
	   		}
	   		
	   		Collections.sort((List<Importinvoicedetail>) importinvoicedetails);
	   		
	   }
	   else
	   {
		    importinvoicedetails = (Collection<Importinvoicedetail>)importinvoicedetailManager.getAllImportinvoicedetails();
		    importinvoicedetails = new ArrayList<Importinvoicedetail>();
			for(Importinvoicedetail imd :  importinvoicedetailManager.getAllImportinvoicedetails())
	   		{
				importinvoicedetails.add(imd);
	   		}
	   		
	   		Collections.sort((List<Importinvoicedetail>) importinvoicedetails);

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
