package com.ph.hms.action;
import java.util.*;
import java.sql.ResultSet;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ViewRecordAction extends ActionSupport
{
	
	private ClientManager clientManager;
	
	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}	
	
	private HMSDataManager hmsDataManager;	
	
	
	public  HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public  void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}
	
	private Client client;	
	
	
	private String txtcode;
	
	private String txtphone;
	
	private String txtemail;
	
	private String txtpassword;
	
	
	
	
public  String getTxtcode() {
		return txtcode;
	}

	public  void setTxtcode(String txtcode) {
		this.txtcode = txtcode;
	}

	public  String getTxtphone() {
		return txtphone;
	}

	public  void setTxtphone(String txtphone) {
		this.txtphone = txtphone;
	}

	public  String getTxtemail() {
		return txtemail;
	}

	public  void setTxtemail(String txtemail) {
		this.txtemail = txtemail;
	}

	public  String getTxtpassword() {
		return txtpassword;
	}

	public  void setTxtpassword(String txtpassword) {
		this.txtpassword = txtpassword;
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

	
	private String msg;
	
	private int id;
	

	public int getId() {
			return id;
		}
	
	public void setId(int id) {
			this.id = id;
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

public String execute() throws Exception
{
   try{
	   
	   i18n = i18nManager.geti18n();	
	   System.out.println(id);
	   
	   if (!(id>0))
	   {
			String sql = "select id from client where (code = '"+txtcode+"' or phone='"+txtphone+"' or email='"+txtemail+"' ) and password='"+txtpassword+"'";
			
		
			ResultSet rs = hmsDataManager.getResultset(sql);
			while (rs.next())
			{
				id = rs.getInt("id");		
				
			}
	   }
	   
		if (id > 0) client = clientManager.getClient(id);
		
		encounters = encounterManager.getEncounterByClientId(id);
		
        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}

public  Client getClient() {
	return client;
}

public  void setClient(Client client) {
	this.client = client;
}	
}
