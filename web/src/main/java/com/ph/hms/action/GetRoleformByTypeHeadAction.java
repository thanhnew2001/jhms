package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetRoleformByTypeHeadAction extends ActionSupport
{
	
	private RoleformManager roleformManager;
	
	public RoleformManager getRoleformManager() {
		return roleformManager;
	}

	public void setRoleformManager(RoleformManager roleformManager) {
		this.roleformManager = roleformManager;
	}	
	
	private Collection<Roleform> roleforms;
	
	public Collection<Roleform> getRoleforms() {
		return roleforms;
	}

	public void setRoleforms(Collection<Roleform> roleforms) {
		this.roleforms = roleforms;
	}	
	
	private RoleManager roleManager;
	
	public RoleManager getRoleManager() {
		return roleManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}	
	
	private Collection<Role> roles;
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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

	
	private String typehead;	

	public String getTypehead() {
		return typehead;
	}

	public void setTypehead(String typehead) {
		this.typehead = typehead;
	}
	
	private String con;	
	
	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
	
public String execute() throws Exception
{
   try{
   	   i18n = i18nManager.geti18n();	
	   
	   if (flag!=null && flag.equalsIgnoreCase("filter")) {
			
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");					
						
				
				return SUCCESS;
		}

		if (con != null)
		{
			if (con.equalsIgnoreCase("") )
			{
				roleforms = (Collection<Roleform>)roleformManager.filter(typehead);
			}
	
			else if (con.equalsIgnoreCase("All"))
			{
				roleforms = (Collection<Roleform>)roleformManager.filterAll(typehead);
			}
			else
			{
				roleforms = (Collection<Roleform>)roleformManager.filterByCon(con, typehead);
			}
		}
		else
		{
			roleforms = (Collection<Roleform>)roleformManager.filter(typehead);
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
