
package com.ph.hms;

import java.util.*;

public class Roleform {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Role role;   
		
	
	public Role getRole()
	{
		return role;
	}
	
	public void setRole(Role role)
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
	
}
