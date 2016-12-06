package com.ph.hms.action;
import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.text.*;


import com.opensymphony.xwork.*;

public class ClientListAction extends ActionSupport
{
	public String fname = "client";
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
	

	private ClientManager clientManager;
	
	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}	
	
	private Collection<Client> clients;
	
	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}	
	
	private PaymenttypeManager paymenttypeManager;
	
	public PaymenttypeManager getPaymenttypeManager() {
		return paymenttypeManager;
	}

	public void setPaymenttypeManager(PaymenttypeManager paymenttypeManager) {
		this.paymenttypeManager = paymenttypeManager;
	}	
	
	private Collection<Paymenttype> paymenttypes;
	
	public Collection<Paymenttype> getPaymenttypes() {
		return paymenttypes;
	}

	public void setPaymenttypes(Collection<Paymenttype> paymenttypes) {
		this.paymenttypes = paymenttypes;
	}	
	
	private OccupationManager occupationManager;
	
	public OccupationManager getOccupationManager() {
		return occupationManager;
	}

	public void setOccupationManager(OccupationManager occupationManager) {
		this.occupationManager = occupationManager;
	}	
	
	private Collection<Occupation> occupations;
	
	public Collection<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(Collection<Occupation> occupations) {
		this.occupations = occupations;
	}	
	
	private WardManager wardManager;
	
	public WardManager getWardManager() {
		return wardManager;
	}

	public void setWardManager(WardManager wardManager) {
		this.wardManager = wardManager;
	}	
	
	private Collection<Ward> wards;
	
	public Collection<Ward> getWards() {
		return wards;
	}

	public void setWards(Collection<Ward> wards) {
		this.wards = wards;
	}	
	
	private EthnicManager ethnicManager;
	
	public EthnicManager getEthnicManager() {
		return ethnicManager;
	}

	public void setEthnicManager(EthnicManager ethnicManager) {
		this.ethnicManager = ethnicManager;
	}	
	
	private Collection<Ethnic> ethnics;
	
	public Collection<Ethnic> getEthnics() {
		return ethnics;
	}

	public void setEthnics(Collection<Ethnic> ethnics) {
		this.ethnics = ethnics;
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


public String execute() throws Exception
{
   try{
	   i18n = i18nManager.geti18n();	

	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);  
	     
	   if (matched == false) return "noprivilege";

       clients = (Collection<Client>)clientManager.getAllClients();
	   
	   
	clients = (Collection<Client>)clientManager.getAllClients();
	
	
	paymenttypes = (Collection<Paymenttype>)paymenttypeManager.getAllPaymenttypes();
	
	
	occupations = (Collection<Occupation>)occupationManager.getAllOccupations();
	
	
	wards = (Collection<Ward>)wardManager.getAllWards();
	
	
	ethnics = (Collection<Ethnic>)ethnicManager.getAllEthnics();
	
	
		
		Date d = new Date();
	
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
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
