package com.ph.hms.action;

import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.text.*;

import com.opensymphony.xwork.*;

public class IndicationdetailListAction extends ActionSupport {
	public String fname = "indicationdetail";
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

	private IndicationdetailManager indicationdetailManager;

	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}

	private Collection<Indicationdetail> indicationdetails;

	public Collection<Indicationdetail> getIndicationdetails() {
		return indicationdetails;
	}

	public void setIndicationdetails(
			Collection<Indicationdetail> indicationdetails) {
		this.indicationdetails = indicationdetails;
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

	public String execute() throws Exception {
		try {
			i18n = i18nManager.geti18n();

			DefaultSecurity ds = new DefaultSecurity();

			boolean matched = ds.checkRight(fname, aname);  
		     
			   if (matched == false) return "noprivilege";

			Map session = ActionContext.getContext().getSession();

			Department department = (Department) session
					.get("selecteddepartment");

			indicationdetails = (List<Indicationdetail>)indicationdetailManager.getAllIndicationdetails(department);


			Date d = new Date();

			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			today = sdf.format(d).toString();
			
			/*int checkupservicegroup = Integer.valueOf(i18n
					.get("checkupservicegroup"));
		
			for(Indicationdetail id:indicationdetails)
			{
				if (id.getService().getServicegroup().getId() == checkupservicegroup)
				{
					indicationdetails.remove(id);
				}				
			}*/

			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}

	}
}
