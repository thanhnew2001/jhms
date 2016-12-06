package com.ph.hms.action;

import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class LabSaveAction extends ActionSupport {

	private ServiceManager serviceManager;
	
	private int serviceParamValueId;
	
	private String value;	
		
	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public int getServiceParamValueId() {
		return serviceParamValueId;
	}

	public void setServiceParamValueId(int serviceParamValueId) {
		this.serviceParamValueId = serviceParamValueId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private int saveOK;
	
	
	public int getSaveOK() {
		return saveOK;
	}

	public void setSaveOK(int saveOK) {
		this.saveOK = saveOK;
	}

	public String execute() throws Exception {
		try 
		{
			ServiceParamValue spv = serviceManager.getServiceParamValue(serviceParamValueId); 
			spv.setValue(value);	
			
			serviceManager.updateServiceParamValue(spv);		
			
			saveOK =1;
			
			return SUCCESS;
		} 
		catch (Exception e) 
		{
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			saveOK = 0;
			return ERROR;
		}
	}

}
