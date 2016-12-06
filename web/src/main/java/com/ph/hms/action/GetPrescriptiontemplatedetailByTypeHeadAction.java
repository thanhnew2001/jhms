package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetPrescriptiontemplatedetailByTypeHeadAction extends ActionSupport
{
	
	private PrescriptiontemplatedetailManager prescriptiontemplatedetailManager;
	
	public PrescriptiontemplatedetailManager getPrescriptiontemplatedetailManager() {
		return prescriptiontemplatedetailManager;
	}

	public void setPrescriptiontemplatedetailManager(PrescriptiontemplatedetailManager prescriptiontemplatedetailManager) {
		this.prescriptiontemplatedetailManager = prescriptiontemplatedetailManager;
	}	
	
	private Collection<Prescriptiontemplatedetail> prescriptiontemplatedetails;
	
	public Collection<Prescriptiontemplatedetail> getPrescriptiontemplatedetails() {
		return prescriptiontemplatedetails;
	}

	public void setPrescriptiontemplatedetails(Collection<Prescriptiontemplatedetail> prescriptiontemplatedetails) {
		this.prescriptiontemplatedetails = prescriptiontemplatedetails;
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
	
	private PrescriptiontemplateManager prescriptiontemplateManager;
	
	public PrescriptiontemplateManager getPrescriptiontemplateManager() {
		return prescriptiontemplateManager;
	}

	public void setPrescriptiontemplateManager(PrescriptiontemplateManager prescriptiontemplateManager) {
		this.prescriptiontemplateManager = prescriptiontemplateManager;
	}	
	
	private Collection<Prescriptiontemplate> prescriptiontemplates;
	
	public Collection<Prescriptiontemplate> getPrescriptiontemplates() {
		return prescriptiontemplates;
	}

	public void setPrescriptiontemplates(Collection<Prescriptiontemplate> prescriptiontemplates) {
		this.prescriptiontemplates = prescriptiontemplates;
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
	
	
	
	
public String execute() throws Exception
{
   try{
   	   i18n = i18nManager.geti18n();	
	   
	   if (flag!=null && flag.equalsIgnoreCase("filter")) {
			
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");					
						
				
				return SUCCESS;
		}

		if (con != null)
		{
			if (con.equalsIgnoreCase("") )
			{
				prescriptiontemplatedetails = (Collection<Prescriptiontemplatedetail>)prescriptiontemplatedetailManager.filter(typehead);
			}
	
			else if (con.equalsIgnoreCase("All"))
			{
				prescriptiontemplatedetails = (Collection<Prescriptiontemplatedetail>)prescriptiontemplatedetailManager.filterAll(typehead);
			}
			else
			{
				prescriptiontemplatedetails = (Collection<Prescriptiontemplatedetail>)prescriptiontemplatedetailManager.filterByCon(con, typehead);
			}
		}
		else
		{
			prescriptiontemplatedetails = (Collection<Prescriptiontemplatedetail>)prescriptiontemplatedetailManager.filter(typehead);
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
