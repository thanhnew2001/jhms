
package com.ph.hms;

import java.util.*;

public class Exportcard {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Date date;   
		
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date =  date;
	}
	
	private User user;   
		
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user =  user;
	}
	
	private Warehouse warehouse;   
		
	
	public Warehouse getWarehouse()
	{
		return warehouse;
	}
	
	public void setWarehouse(Warehouse warehouse)
	{
		this.warehouse =  warehouse;
	}
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private String code;   
		
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
	}
	
	private Warehouse towarehouse;   
		
	
	public Warehouse getTowarehouse()
	{
		return towarehouse;
	}
	
	public void setTowarehouse(Warehouse towarehouse)
	{
		this.towarehouse =  towarehouse;
	}
	
		private Collection<Importcard> importcards;   
			
		
		public Collection<Importcard> getImportcards()
		{
			return importcards;
		}
		
		public void setImportcards(Collection<Importcard> importcards)
		{
			this.importcards =  importcards;
		}
		
		private Collection<Exportdetail> exportdetails;   
			
		
		public Collection<Exportdetail> getExportdetails()
		{
			return exportdetails;
		}
		
		public void setExportdetails(Collection<Exportdetail> exportdetails)
		{
			this.exportdetails =  exportdetails;
		}
		
}
