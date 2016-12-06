package com.ph.hms.action;
import com.opensymphony.xwork.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import java.text.*;

public class ServiceAddFormAction extends ActionSupport
{
	public String fname = "service";
	public String aname = "add";
	
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

	private Collection<BodyPart> bodyParts;	
	
	
	public Collection<BodyPart> getBodyParts() {
		return bodyParts;
	}

	public void setBodyParts(Collection<BodyPart> bodyParts) {
		this.bodyParts = bodyParts;
	}
	
	private IndicationdetailManager indicationdetailManager;	
	

	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}

	public String execute() throws Exception
	{ 
	
	try{		
		   i18n = i18nManager.geti18n();	
		   
		   DefaultSecurity ds = new DefaultSecurity();
		   
		   boolean matched = ds.checkRight(fname, aname);
	  
			 
		   if (matched == false) return "noprivilege";
		   
		   code = serviceManager.genCode("");
		   
			
	services = (Collection<Service>)serviceManager.getAllServices();
	
	
	servicegroups = (Collection<Servicegroup>)servicegroupManager.getAllServicegroups();
	
	
	departments = (Collection<Department>)departmentManager.getAllDepartments();
	
	bodyParts = (Collection<BodyPart>)indicationdetailManager.getAllBodyParts();
	
	
			
			Date d = new Date();
		
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
			today = sdf.format(d).toString();
		
			return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }
       
    }

	
}
