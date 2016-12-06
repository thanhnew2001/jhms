package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetRoleformByRoleAction extends ActionSupport
{
	
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
		
	
	private RoleformManager roleformManager;
	
	public RoleformManager getRoleformManager() {
		return roleformManager;
	}

	public void setRoleformManager(RoleformManager roleformManager) {
		this.roleformManager = roleformManager;
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

	
	private Collection<Roleform> roleforms;
	
	public Collection<Roleform> getRoleforms() {
		return roleforms;
	}

	public void setRoleforms(Collection<Roleform> roleforms) {
		this.roleforms = roleforms;
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

   	   i18n = i18nManager.geti18n();	
   
	   Map session = ActionContext.getContext().getSession();
	   
	   session.put("role_id", id);
	   
	   Role role = roleManager.getRole(id);
	   
	   
		roles = (Collection<Role>)roleManager.getAllRoles();		
		
	   
	   if (role != null)
	   {
	   		session.put("role_node", roleManager.getRole(id).getNode());
			roleforms = role.getRoleforms();
	   }
	   else
	   {
		    roleforms = (Collection<Roleform>)roleformManager.getAllRoleforms();
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
