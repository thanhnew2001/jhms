package com.ph.hms.action;
import java.util.*;
import java.text.*;

import org.springframework.web.servlet.mvc.ParameterizableViewController;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class IndicationdetailAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	private IndicationdetailManager indicationdetailManager;
	
	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}	
	
	private Collection<Indicationdetail> indicationdetails;
	
	public Collection<Indicationdetail> getIndicationdetails() {
		return indicationdetails;
	}

	public void setIndicationdetails(Collection<Indicationdetail> indicationdetails) {
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
	
	private int serpackage;
	private SerpackageManager serpackageManager;

	public int getSerpackage() {
		return serpackage;
	}

	public void setSerpackage(int serpackage) {
		this.serpackage = serpackage;
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

	
	
	private int encounter;   
		
	
	public int getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(int encounter)
	{
		this.encounter =  encounter;
	}
	
	private int service;   
		
	
	public int getService()
	{
		return service;
	}
	
	public void setService(int service)
	{
		this.service =  service;
	}
	
	private int quantity;   
		
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity =  quantity;
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
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private String note;   
		
	
	public String getNote()
	{
		return note;
	}
	
	public void setNote(String note)
	{
		this.note =  note;
	}
	
	private String status;   
		
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status =  status;
	}
	
	private String paid;   
		
	
	public String getPaid()
	{
		return paid;
	}
	
	public void setPaid(String paid)
	{
		this.paid =  paid;
	}
	

private String request;
	
	private String result;
	
	private String timedone;
	
	private String file1;
	

	
	private int user;


	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTimedone() {
		return timedone;
	}

	public void setTimedone(String timedone) {
		this.timedone = timedone;
	}

	private String file2;
	private String file3;
	private String file4;
	private String file5;
	private String file6;
	private String file7;
	private String file8;
	
	
	
	
	public String getFile5() {
		return file5;
	}

	public void setFile5(String file5) {
		this.file5 = file5;
	}

	public String getFile6() {
		return file6;
	}

	public void setFile6(String file6) {
		this.file6 = file6;
	}

	public String getFile7() {
		return file7;
	}

	public void setFile7(String file7) {
		this.file7 = file7;
	}

	public String getFile8() {
		return file8;
	}

	public void setFile8(String file8) {
		this.file8 = file8;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	private String note1;
	private String note2;
	private String note3;
	private String note4;
	private String note5;
	private String note6;
	private String note7;
	private String note8;
	
	
	
	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getNote3() {
		return note3;
	}

	public void setNote3(String note3) {
		this.note3 = note3;
	}

	public String getNote4() {
		return note4;
	}

	public void setNote4(String note4) {
		this.note4 = note4;
	}

	public String getNote5() {
		return note5;
	}

	public void setNote5(String note5) {
		this.note5 = note5;
	}

	public String getNote6() {
		return note6;
	}

	public void setNote6(String note6) {
		this.note6 = note6;
	}

	public String getNote7() {
		return note7;
	}

	public void setNote7(String note7) {
		this.note7 = note7;
	}

	public String getNote8() {
		return note8;
	}

	public void setNote8(String note8) {
		this.note8 = note8;
	}

	public String execute() throws Exception
    {
        try{

        	Map session = ActionContext.getContext().getSession();
        	
        	User user = (User)session.get("user");
        	
			String code = indicationdetailManager.genCode("CD");
			        	
			
        	//assign logged in user as indication doctor
			Encounter enc = encounterManager.getEncounter(encounter);
			enc.setUser(user);
			encounterManager.updateEncounter(enc);
			
			if(service != 0)
			{				
				Indicationdetail indicationdetail = new Indicationdetail();
				
				indicationdetail.setEncounter(enc);
		
				indicationdetail.setService(serviceManager.getService(service));
		
				indicationdetail.setQuantity(quantity);
										
				indicationdetail.setPrice(indicationdetail.getService().getPrice());
		
				indicationdetail.setNode(node);
		
				indicationdetail.setNote(note);
		
				indicationdetail.setStatus(status);
		
				indicationdetail.setPaid("N");
				
				indicationdetail.setRequest(request);
				
				indicationdetail.setResult("");
				
				indicationdetail.setFile1(file1);
				
				indicationdetail.setFile2(file2);
				
				indicationdetail.setFile3(file3);
				
				indicationdetail.setFile4(file4);
				
				indicationdetail.setFile5(file5);
				
				indicationdetail.setFile6(file6);
				
				indicationdetail.setFile7(file7);
				
				indicationdetail.setFile8(file8);
				
				indicationdetail.setNote1(note1);
				
				indicationdetail.setNote2(note2);
				
				indicationdetail.setNote3(note3);
				
				indicationdetail.setNote4(note4);
				
				indicationdetail.setNote5(note5);
				
				indicationdetail.setNote6(note6);
				
				indicationdetail.setNote7(note7);
				
				indicationdetail.setNote8(note8);
				
				indicationdetail.setTimedone(timedone);		
				
				//indicationdetail.setUser(user);
				
	        	indicationdetailManager.addIndicationdetail(indicationdetail);	    
	        	
	        	//now if the service is Lab test, add Service Param to it
	        	//can not add
	        	Service svc = serviceManager.getService(service);
	        	if(svc.getServicegroup().getId()<20)
	        	{
	        		for(ServiceParam sp: svc.getServiceParams())
	        		{
	        			ServiceParamValue spv = new ServiceParamValue();
	        			spv.setIndicationdetail(indicationdetail);
	        			spv.setServiceParam(sp);
	        			spv.setValue("");
	        			serviceManager.addServiceParamValue(spv);
	        		}
	        	}
	        				
				id = indicationdetail.getId();
			}
			
			
			if(serpackage > 0)
			{
				System.out.println("Them chi dinh goi dich vu");
				
				Serpackage ser = serpackageManager.getSerpackage(serpackage);
				for (Packagedetail packagedetail: ser.getPackagedetails())
				{
										
					Indicationdetail ind = new Indicationdetail();
					
					ind.setService(serviceManager.getService(packagedetail.getService().getId()));
					
					ind.setPrice(ind.getService().getPrice());
					
					ind.setQuantity(1);
					
					ind.setStatus("NEW");
					
					ind.setPaid("N");
					
					ind.setEncounter(enc);
					
					indicationdetailManager.addIndicationdetail(ind);	
					
					id = ind.getId();
				}			
			}
			
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	public String getFile4() {
		return file4;
	}

	public void setFile4(String file4) {
		this.file4 = file4;
	}

	public SerpackageManager getSerpackageManager() {
		return serpackageManager;
	}

	public void setSerpackageManager(SerpackageManager serpackageManager) {
		this.serpackageManager = serpackageManager;
	}	
}
