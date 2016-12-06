package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class HistoryFormAction extends ActionSupport
{	
	public String fname = "history";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private History history;
	
	private int id;	
		
   
	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private Collection<History> historys;
	
	public Collection<History> getHistorys() {
		return historys;
	}

	public void setHistorys(Collection<History> historys) {
		this.historys = historys;
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
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
				
	private HistoryManager historyManager;
	
	public HistoryManager getHistoryManager() {
		return historyManager;
	}

	public void setHistoryManager(HistoryManager historyManager) {
		this.historyManager = historyManager;
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
	   
	   if( id == 0){
	   
	   boolean matched = ds.checkRight(fname, anameAdd);
	   
	   if (matched == false) return "noprivilege";
	   
	   historys = (Collection<History>)historyManager.getAllHistorys();
		
		
		clients = (Collection<Client>)clientManager.getAllClients();
		
		Date d = new Date();
		
		DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
		today = sdf.format(d).toString();
	
		return SUCCESS;
	   
	   } else {
		   
		   boolean matched = ds.checkRight(fname, anameEdit);
		   
		   if (matched == false) return "noprivilege";
		   
		   if (id > 0)
			   history = historyManager.getHistory(id);
        	
		   return SUCCESS;
	   }

        }
        catch(Exception e){
            System.out.println("Error History Form");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
