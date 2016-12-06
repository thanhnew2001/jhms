
package com.ph.hms;

import java.util.*;

public class Exportproposal {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	private Warehouse fromwarehouse;   
		
	
	public Warehouse getFromwarehouse()
	{
		return fromwarehouse;
	}
	
	public void setFromwarehouse(Warehouse fromwarehouse)
	{
		this.fromwarehouse =  fromwarehouse;
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
	
	private String status;   
		
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status =  status;
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
	
		private Collection<Importcard> importcards;   
			
		
		public Collection<Importcard> getImportcards()
		{
			return importcards;
		}
		
		public void setImportcards(Collection<Importcard> importcards)
		{
			this.importcards =  importcards;
		}
		
		private Collection<Exportproposaldetail> exportproposaldetails;   
			
		
		public Collection<Exportproposaldetail> getExportproposaldetails()
		{
			return exportproposaldetails;
		}
		
		public void setExportproposaldetails(Collection<Exportproposaldetail> exportproposaldetails)
		{
			this.exportproposaldetails =  exportproposaldetails;
		}
		
}
