
package com.ph.hms;

import java.util.*;

public class Warehouse {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
		private Collection<Importinvoice> importinvoices;   
			
		
		public Collection<Importinvoice> getImportinvoices()
		{
			return importinvoices;
		}
		
		public void setImportinvoices(Collection<Importinvoice> importinvoices)
		{
			this.importinvoices =  importinvoices;
		}
		
}
