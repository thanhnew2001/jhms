package com.ph.hms.action;

import java.sql.ResultSet;
import java.util.Hashtable;
import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Client;
import com.ph.hms.ClientManager;
import com.ph.hms.HMSDataManager;
import com.ph.hms.action.util.I18nManager;


public class ClientChangePasswordAction extends ActionSupport{

	private String code;   
		
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
	}
	
	private I18nManager i18nManager;			
	
	public I18nManager getI18nManager() {
		return i18nManager;
	}
	
	public void setI18nManager(I18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}
	
	private String password;
	
	private Client client;
	
	public ClientManager clientManager;

	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	String newpassword;

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	private Hashtable<String, String> i18n;			
	
	public Hashtable<String, String> getI18n() {			  		   
		return i18n;
	}
	
	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}
	
	private String error;
	
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	private int id;
	
	
	
	public  int getId() {
		return id;
	}

	public  void setId(int id) {
		this.id = id;
	}

	private HMSDataManager hmsDataManager;
	
	
	public  HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public  void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}

	public String execute() throws Exception
    {
        try{
        	
        	ResultSet rs = hmsDataManager.getResultset("select id from client where code='"+code+"' and password='"+password+"'");
        	
        	while(rs.next())
        	{
        		int id = rs.getInt("id");
        		client = clientManager.getClient(id);        		
        	}
       	
        	if (client == null) {error = "username/password wrong !!"; return ERROR;}
        	
        	if (client.getPassword().equals(password))
        	{
	        	client.setPassword(newpassword);
	        	clientManager.updateClient(client);
	          	return SUCCESS;
        	}
        	else
        	{
        		return ERROR;
        	}
        	
        }
        catch(Exception e){
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
            return ERROR;
        }
       
    }

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
