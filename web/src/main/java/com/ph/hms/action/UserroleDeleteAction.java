package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class UserroleDeleteAction extends ActionSupport
{
	public String fname = "userrole";
	public String aname = "delete";
	
	
	private UserroleManager userroleManager;
	
	public UserroleManager getUserroleManager() {
		return userroleManager;
	}

	public void setUserroleManager(UserroleManager userroleManager) {
		this.userroleManager = userroleManager;
	}	
	
	private Collection<Userrole> userroles;
	
	public Collection<Userrole> getUserroles() {
		return userroles;
	}

	public void setUserroles(Collection<Userrole> userroles) {
		this.userroles = userroles;
	}	
	
	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}	
	
	private Collection<User> users;
	
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
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

	
	private Userrole userrole;

	public Userrole getUserrole() {
		return userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}
	
	private int id;	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception
    {
        try{

		//checking role
	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);  
	     
	   if (matched == false) return "noprivilege";
	   
       userroleManager.deleteUserrole(id);
        	
       return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
