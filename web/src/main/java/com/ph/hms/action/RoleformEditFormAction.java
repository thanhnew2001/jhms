package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import com.opensymphony.xwork.*;

public class RoleformEditFormAction extends ActionSupport
{	
	public String fname = "roleform";
	public String aname = "update";
	
	private Roleform roleform;
	
	private int id;	
		
   
	public Roleform getRoleform() {
		return roleform;
	}

	public void setRoleform(Roleform roleform) {
		this.roleform = roleform;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
	
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


	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);
  
	     
	   if (matched == false) return "noprivilege";

			
	roleforms = (Collection<Roleform>)roleformManager.getAllRoleforms();
	
	
	roles = (Collection<Role>)roleManager.getAllRoles();
	
	
        	roleform = roleformManager.getRoleform(id);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
