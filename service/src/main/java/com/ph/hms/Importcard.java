
package com.ph.hms;

import java.util.*;

public class Importcard {

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
	
	private Warehouse fromwarehouse;   
		
	
	public Warehouse getFromwarehouse()
	{
		return fromwarehouse;
	}
	
	public void setFromwarehouse(Warehouse fromwarehouse)
	{
		this.fromwarehouse =  fromwarehouse;
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
	
	private User user;   
		
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user =  user;
	}
	
	private Exportcard exportcard;   
		
	
	public Exportcard getExportcard()
	{
		return exportcard;
	}
	
	public void setExportcard(Exportcard exportcard)
	{
		this.exportcard =  exportcard;
	}
	
		private Collection<Importdetail> importdetails;   
			
		
		public Collection<Importdetail> getImportdetails()
		{
			return importdetails;
		}
		
		public void setImportdetails(Collection<Importdetail> importdetails)
		{
			this.importdetails =  importdetails;
		}
		
}
