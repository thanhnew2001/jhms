package com.ph.hms.action;

import java.lang.reflect.Array;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetIndicationdetailByEncounterAction extends ActionSupport {

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

	private IndicationdetailManager indicationdetailManager;

	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
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

	private ServicegroupManager servicegroupManager;
	private Collection<Servicegroup> servicegroups;

	public ServicegroupManager getServicegroupManager() {
		return servicegroupManager;
	}

	public void setServicegroupManager(ServicegroupManager servicegroupManager) {
		this.servicegroupManager = servicegroupManager;
	}

	public Collection<Servicegroup> getServicegroups() {
		return servicegroups;
	}

	public void setServicegroups(Collection<Servicegroup> servicegroups) {
		this.servicegroups = servicegroups;
	}

	private Collection<Serpackage> serpackages;
	private SerpackageManager serpackageManager;

	public Collection<Serpackage> getSerpackages() {
		return serpackages;
	}

	public void setSerpackages(Collection<Serpackage> serpackages) {
		this.serpackages = serpackages;
	}

	public SerpackageManager getSerpackageManager() {
		return serpackageManager;
	}

	public void setSerpackageManager(SerpackageManager serpackageManager) {
		this.serpackageManager = serpackageManager;
	}

	private List<Indicationdetail> ids;



	public List<Indicationdetail> getIds() {
		return ids;
	}

	public void setIds(List<Indicationdetail> ids) {
		this.ids = ids;
	}
	private double total;
	
	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String execute() throws Exception {
		try {

			i18n = i18nManager.geti18n();

			Map session = ActionContext.getContext().getSession();

			session.put("encounter_id", id);

			Encounter encounter = encounterManager.getEncounter(id);

			ids = new ArrayList<Indicationdetail>();

			for (Indicationdetail indicationdetail : encounter.getIndicationdetails()) {
				total = total += indicationdetail.getPrice()*indicationdetail.getQuantity();
				ids.add(indicationdetail);

			}

		
			Collections.sort(ids);

			services = (Collection<Service>) serviceManager.getAllServices();

			encounters = (Collection<Encounter>) encounterManager
					.getAllEncounters(null);

			servicegroups = servicegroupManager.getAllServicegroups();
			serpackages = serpackageManager.getAllSerpackages();

			if (encounter != null) {
				session.put("encounter_node", encounterManager.getEncounter(id)
						.getNode());
			} 
		
			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}

	}
}
