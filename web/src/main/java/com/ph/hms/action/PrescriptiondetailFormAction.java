package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class PrescriptiondetailFormAction extends ActionSupport
{	
	public String fname = "prescriptiondetail";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Prescriptiondetail prescriptiondetail;
	
	private int id;	
		
   
	public Prescriptiondetail getPrescriptiondetail() {
		return prescriptiondetail;
	}

	public void setPrescriptiondetail(Prescriptiondetail prescriptiondetail) {
		this.prescriptiondetail = prescriptiondetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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
		
	
	private PrescriptiondetailManager prescriptiondetailManager;
	
	public PrescriptiondetailManager getPrescriptiondetailManager() {
		return prescriptiondetailManager;
	}

	public void setPrescriptiondetailManager(PrescriptiondetailManager prescriptiondetailManager) {
		this.prescriptiondetailManager = prescriptiondetailManager;
	}	
	
	private Collection<Prescriptiondetail> prescriptiondetails;
	
	public Collection<Prescriptiondetail> getPrescriptiondetails() {
		return prescriptiondetails;
	}

	public void setPrescriptiondetails(Collection<Prescriptiondetail> prescriptiondetails) {
		this.prescriptiondetails = prescriptiondetails;
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

	private List<Prescriptiondetail> pds = new ArrayList<Prescriptiondetail>();
	
	

	public List<Prescriptiondetail> getPds() {
		return pds;
	}

	public void setPds(List<Prescriptiondetail> pds) {
		this.pds = pds;
	}

	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
	   
	encounters = (Collection<Encounter>)encounterManager.getAllEncounters(null);
	
	prescriptiondetails = (Collection<Prescriptiondetail>)prescriptiondetailManager.getAllPrescriptiondetails();
	
	drugs = (Collection<Drug>)drugManager.getAllDrugs();
	
	if( id == 0) {
		
		boolean matched = ds.checkRight(fname, anameAdd);

		   if (matched == false) return "noprivilege";
		   
		code = prescriptiondetailManager.genCode("");
		
		Date d = new Date();
		
		DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
		today = sdf.format(d).toString();
		
		return SUCCESS;
		
	} else {
		boolean matched = ds.checkRight(fname, anameEdit);

		   if (matched == false) return "noprivilege";
	
		   prescriptiondetail = prescriptiondetailManager.getPrescriptiondetail(id);

        	Encounter e = prescriptiondetail.getEncounter();        	

        	for(Prescriptiondetail pd : e.getPrescriptiondetails())
        	{
        		pds.add(pd);
        	}
        	
        	Collections.sort(pds);
        	
          	return SUCCESS;
	}

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
