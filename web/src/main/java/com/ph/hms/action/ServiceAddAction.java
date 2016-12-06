package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ServiceAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	private ServicegroupManager servicegroupManager;
	
	public ServicegroupManager getServicegroupManager() {
		return servicegroupManager;
	}

	public void setServicegroupManager(ServicegroupManager servicegroupManager) {
		this.servicegroupManager = servicegroupManager;
	}	
	
	private Collection<Servicegroup> servicegroups;
	
	public Collection<Servicegroup> getServicegroups() {
		return servicegroups;
	}

	public void setServicegroups(Collection<Servicegroup> servicegroups) {
		this.servicegroups = servicegroups;
	}	
	
	private DepartmentManager departmentManager;
	
	public DepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}	
	
	private Collection<Department> departments;
	
	public Collection<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Collection<Department> departments) {
		this.departments = departments;
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

	
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private int servicegroup;   
		
	
	public int getServicegroup()
	{
		return servicegroup;
	}
	
	public void setServicegroup(int servicegroup)
	{
		this.servicegroup =  servicegroup;
	}
	
	private double price;   
		
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price =  price;
	}
	
	private double insuranceprice;   
		
	
	public double getInsuranceprice()
	{
		return insuranceprice;
	}
	
	public void setInsuranceprice(double insuranceprice)
	{
		this.insuranceprice =  insuranceprice;
	}
	
	private int department;   
		
	
	public int getDepartment()
	{
		return department;
	}
	
	public void setDepartment(int department)
	{
		this.department =  department;
	}
	
	private int bodyPart;	

	
	public int getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(int bodyPart) {
		this.bodyPart = bodyPart;
	}


	private IndicationdetailManager indicationdetailManager;
	
	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}

	private double min;
	
	private double max;
	
	
	
	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public String execute() throws Exception
    {
        try{

			String code = serviceManager.genCode("");
			
        	Service service = new Service();
			
			
			service.setNode(node);
	
			service.setServicegroup(servicegroupManager.getServicegroup(servicegroup));
	
			service.setPrice(price);
	
			service.setInsuranceprice(insuranceprice);
	
			service.setDepartment(departmentManager.getDepartment(department));
	
			service.setBodyPart(indicationdetailManager.getBodyPart(bodyPart));
			
			service.setMin(min);
			
			service.setMax(max);
			
        	serviceManager.addService(service);
			
			id = service.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
