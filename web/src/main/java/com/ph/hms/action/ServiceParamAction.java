package com.ph.hms.action;

import java.util.Collection;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Service;
import com.ph.hms.ServiceManager;
import com.ph.hms.ServiceParam;

public class ServiceParamAction extends ActionSupport {

	private int serviceParamId;
	
	private ServiceParam serviceParam;
	
	private Collection<ServiceParam> serviceParams;
	
	private int serviceId;
	
	private Service service;
	
	private ServiceManager serviceManager;
	
	private String action;	
	
	
	public int getServiceParamId() {
		return serviceParamId;
	}


	public void setServiceParamId(int serviceParamId) {
		this.serviceParamId = serviceParamId;
	}


	public ServiceParam getServiceParam() {
		return serviceParam;
	}


	public void setServiceParam(ServiceParam serviceParam) {
		this.serviceParam = serviceParam;
	}


	public Collection<ServiceParam> getServiceParams() {
		return serviceParams;
	}


	public void setServiceParams(Collection<ServiceParam> serviceParams) {
		this.serviceParams = serviceParams;
	}


	public int getServiceId() {
		return serviceId;
	}


	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public ServiceManager getServiceManager() {
		return serviceManager;
	}


	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}

	//property of a param
	private String name;
	private String min;
	private String max;
	private String unit;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}
	
	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	public String execute()
	{
		
		if(action==null) action = "";

		serviceParam = serviceManager.getServiceParam(serviceParamId);
		if (serviceParam==null)
			serviceParam = new ServiceParam();
		
		System.out.println("serviceParamId="+serviceParamId);

		
		if(action.equalsIgnoreCase("save"))
		{			
			serviceParam.setName(name);
			serviceParam.setMin(min);
			serviceParam.setMax(max);
			serviceParam.setUnit(unit);
			serviceParam.setService(serviceManager.getService(serviceId));
			
			if(serviceParamId>0)
			{
				serviceManager.updateServiceParam(serviceParam);
				System.out.println("name="+serviceParam.getName());
				System.out.println("updating");
				
			}
			else
			{
				serviceManager.addServiceParam(serviceParam);
			}
		}
		
		if(action.equalsIgnoreCase("delete"))
		{
			serviceManager.deleteServiceParam(serviceParamId);
		}
		
		//reload service from db
		service = serviceManager.getService(serviceId);

		return SUCCESS;
	}
	
}
