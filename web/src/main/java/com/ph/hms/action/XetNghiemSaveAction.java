package com.ph.hms.action;

import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class XetNghiemSaveAction extends ActionSupport {

	private IndicationdetailManager indicationdetailManager;

	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}

	private UserManager userManager;

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	private ServiceManager serviceManager;

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	private EncounterManager encounterManager;

	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
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

	private String action;
	
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	private String result;


	public String getResult() {
		return result;
	}

	public void setResult(String result) 
	{
		
		this.result = result;
	}

	private String saveOK;
	
	
	public String getSaveOK() {
		return saveOK;
	}

	public void setSaveOK(String saveOK) {
		this.saveOK = saveOK;
	}
	private String file1;

	
	
	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}
	
	
	public String execute() throws Exception {
		try {

				saveOK = "0";
			
				Map session = ActionContext.getContext().getSession();
			
				Indicationdetail indicationdetail = indicationdetailManager.getIndicationdetail(id);
				
						
				
				//System.out.println(id);
				//result = result.replaceAll("\n", "<br/>");
				//System.out.println(result);
				
				if(result != null)
				{
					result = result.replaceAll("blank", "&nbsp;");
					result = result.replaceAll("kytuva", "&");
				
					indicationdetail.setResult(result);	
					/*
					String[] splited = result.split("->");
					
					System.out.println(splited.length);
					
					
					if(splited.length > 1)
					{
						String tmp = "";
						for(int i =1; i<splited.length; i++)
						{
							String[] subspl = splited[i].split(":");
							tmp += "->" + subspl[0];
							
							for(int j = subspl[0].length(); j<40; j++)
							{
								tmp += "&nbsp;";
							}
							
							
							tmp += "&nbsp;&nbsp;" + subspl[1] + "<br>";							
						}
						indicationdetail.setResult(tmp);	
					}
					else
					{
						indicationdetail.setResult(result);	
					}	
					//
					//indicationdetail.setResult(result);
					*/
				}
				
				
				
				indicationdetail.setFile1(file1);

				indicationdetail.setUser((User) session.get("user"));
	
				indicationdetailManager.updateIndicationdetail(indicationdetail);
				
				//Service s = indicationdetail.getService();
				//s.setMax(max);
				//s.setMin(min);
				
				//serviceManager.updateService(s);
				
				saveOK = "1";	
				return SUCCESS;


		} catch (Exception e) {
			
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}
	}

}
