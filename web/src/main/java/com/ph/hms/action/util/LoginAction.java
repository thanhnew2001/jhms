package com.ph.hms.action.util;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class LoginAction extends ActionSupport
{
	private UserManager userManager;	
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
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

	
	private String username;
	
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

public String execute() throws Exception
{
   	try{
   
   	   i18n = i18nManager.geti18n();	
   	   
       
       Map session = ActionContext.getContext().getSession();
   	   
   	   session.put("user", null);
	   
       User user = userManager.getUserByUsernameAndPassword(username, password);
       System.out.println("tyfryd7ydrikyfrtkydr"+ user.getDepartment());
       if (user == null) return "noprivilege";
       
       session.put("user", user);
       
       if (user.getRoom() !=null)
       {  
       session.put("selectedroom", user.getRoom());
       }
       
       
       if (user.getDepartment()!=null)
       {  
    	   System.out.println("tyfryd7ydrikyfrtkydr"+user.getDepartment());
       session.put("selecteddepartment", user.getDepartment());
          
       }
       
       if (user.getWarehouse()!=null)
       {    	   
       session.put("selectedwarehouse", user.getWarehouse());
      
       }
       
       if(user.getRoom()!=null)
       {
    	   return "room";
       }
       
       if(user.getDepartment()!=null)
       {
    	   return "department";
       }
       if(user.getWarehouse()!=null)
       {
    	   return "warehouse";
       }
       
        return SUCCESS;

     }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}	
}
