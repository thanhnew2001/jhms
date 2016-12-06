package com.ph.hms.action;

import java.sql.ResultSet;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;


import com.opensymphony.xwork.*;

public class GetPrescriptiondetailByEncounterAction extends ActionSupport {

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

	private PrescriptiondetailManager prescriptiondetailManager;

	public PrescriptiondetailManager getPrescriptiondetailManager() {
		return prescriptiondetailManager;
	}

	public void setPrescriptiondetailManager(
			PrescriptiondetailManager prescriptiondetailManager) {
		this.prescriptiondetailManager = prescriptiondetailManager;
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

	private Collection<Prescriptiondetail> prescriptiondetails;

	public Collection<Prescriptiondetail> getPrescriptiondetails() {
		return prescriptiondetails;
	}

	public void setPrescriptiondetails(
			Collection<Prescriptiondetail> prescriptiondetails) {
		this.prescriptiondetails = prescriptiondetails;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Collection<DrugGroup> druggroups;

	public Collection<DrugGroup> getDruggroups() {
		return druggroups;
	}

	public void setDruggroups(Collection<DrugGroup> druggroups) {
		this.druggroups = druggroups;
	}

	private HMSDataManager hmsDataManager;

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}

	private int druggroup;

	public int getDruggroup() {
		return druggroup;
	}

	public void setDruggroup(int druggroup) {
		this.druggroup = druggroup;
	}

	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	private List<Prescriptiondetail> pds;
	
	public List<Prescriptiondetail> getPds() {
		return pds;
	}

	public void setPds(List<Prescriptiondetail> pds) {
		this.pds = pds;
	}

	public String execute() throws Exception {
		try {

			i18n = i18nManager.geti18n();

			Map session = ActionContext.getContext().getSession();

			session.put("encounter_id", id);

			Encounter encounter = encounterManager.getEncounter(id);

			druggroups = (Collection<DrugGroup>) drugManager.getAllDrugGroups();

			if (encounter != null) {
				session.put("encounter_node", encounterManager.getEncounter(id)
						.getNode());
				
				//replace by pds
				prescriptiondetails = encounter.getPrescriptiondetails();
								
				pds = new ArrayList<Prescriptiondetail>();
				
				for(Prescriptiondetail p:prescriptiondetails)
				{
					total += p.getPrice()*p.getQuantity();
					pds.add(p);					
				}
				
				Collections.sort(pds);
			} 
			
			/*else {
				prescriptiondetails = (Collection<Prescriptiondetail>) prescriptiondetailManager
						.getAllPrescriptiondetails();
			}
			*/
			

			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}

	}

}
