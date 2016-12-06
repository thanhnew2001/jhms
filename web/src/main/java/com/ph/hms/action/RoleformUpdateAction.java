package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class RoleformUpdateAction extends ActionSupport
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

	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	private int role;   
		
	
	public int getRole()
	{
		return role;
	}
	
	public void setRole(int role)
	{
		this.role =  role;
	}
	
	private String form;   
		
	
	public String getForm()
	{
		return form;
	}
	
	public void setForm(String form)
	{
		this.form =  form;
	}
	
	private String listable;   
		
	
	public String getListable()
	{
		return listable;
	}
	
	public void setListable(String listable)
	{
		this.listable =  listable;
	}
	
	private String addable;   
		
	
	public String getAddable()
	{
		return addable;
	}
	
	public void setAddable(String addable)
	{
		this.addable =  addable;
	}
	
	private String updatable;   
		
	
	public String getUpdatable()
	{
		return updatable;
	}
	
	public void setUpdatable(String updatable)
	{
		this.updatable =  updatable;
	}
	
	private String deletable;   
		
	
	public String getDeletable()
	{
		return deletable;
	}
	
	public void setDeletable(String deletable)
	{
		this.deletable =  deletable;
	}
	
	
	public String execute() throws Exception
    {
        try{

        	Roleform roleform = roleformManager.getRoleform(id);
			
			
			roleform.setRole(roleManager.getRole(role));
	
			roleform.setForm(form);
	
			roleform.setListable(listable);
	
			roleform.setAddable(addable);
	
			roleform.setUpdatable(updatable);
	
			roleform.setDeletable(deletable);
	
			roleform.setRole(roleManager.getRole(role));
	
			roleform.setForm(form);
	
			roleform.setListable(listable);
	
			roleform.setAddable(addable);
	
			roleform.setUpdatable(updatable);
	
			roleform.setDeletable(deletable);
	
			
        	roleformManager.updateRoleform(roleform);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
