
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Indicationdetail;
import com.ph.hms.Service;
import com.ph.hms.ServiceParam;
import com.ph.hms.ServiceParamValue;

public interface ServiceManager {

	String ID = ServiceManager.class.getName();
	
	public void addService(Service service);
	
	public void updateService(Service service);
	
	public void deleteService(int id);
	
	public Service getService(int id);
	
	public Collection<Service> getAllServices();
	
	public Collection<Service> filter(String typehead);
	
	public Collection<Service> filterAll(String typehead);
	
	public Collection<Service> filterByCon(String con, String typehead);
		
	public String genCode(String formula);
	
	//this is for param
	
	public void addServiceParam(ServiceParam serviceParam);
	
	public void updateServiceParam(ServiceParam serviceParam);
	
	public void deleteServiceParam(int id);
	
	public ServiceParam getServiceParam(int id);
	
	public Collection<ServiceParam> getAllServiceParams();
	
	public Collection<ServiceParam> searchServiceParam(String typehead);


	public void addServiceParamValue(ServiceParamValue serviceParamValue);
	
	public void updateServiceParamValue(ServiceParamValue serviceParamValue);
	
	public void deleteServiceParamValue(int id);
	
	public ServiceParamValue getServiceParamValue(int id);

	public Collection<ServiceParamValue> getServiceParamValuesByIndicationdetail(Indicationdetail ind);


}
