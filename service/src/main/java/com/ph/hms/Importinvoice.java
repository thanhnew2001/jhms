
package com.ph.hms;

import java.util.*;

public class Importinvoice {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private String tax;
	
	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	private String type;   
		
	
	public String getType()
	{
		return type;
	}
	
	public void setType(String type)
	{
		this.type =  type;
	}
	
	private double totalaftertax;   
		
	
	public double getTotalaftertax()
	{
		return totalaftertax;
	}
	
	public void setTotalaftertax(double totalaftertax)
	{
		this.totalaftertax =  totalaftertax;
	}
	
	private double vat;   
		
	
	public double getVat()
	{
		return vat;
	}
	
	public void setVat(double vat)
	{
		this.vat =  vat;
	}
	
	private Provider provider;   
		
	
	public Provider getProvider()
	{
		return provider;
	}
	
	public void setProvider(Provider provider)
	{
		this.provider =  provider;
	}
	
	private int remain;   
		
	
	public int getRemain()
	{
		return remain;
	}
	
	public void setRemain(int remain)
	{
		this.remain =  remain;
	}
	
	private int totalexport;   
		
	
	public int getTotalexport()
	{
		return totalexport;
	}
	
	public void setTotalexport(int totalexport)
	{
		this.totalexport =  totalexport;
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
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
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
	
	private double total;   
		
	
	public double getTotal()
	{
		return total;
	}
	
	public void setTotal(double total)
	{
		this.total =  total;
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
	
	private String code;   
		
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
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
	
		private Collection<Importinvoicedetail> importinvoicedetails;   
			
		
		public Collection<Importinvoicedetail> getImportinvoicedetails()
		{
			return importinvoicedetails;
		}
		
		public void setImportinvoicedetails(Collection<Importinvoicedetail> importinvoicedetails)
		{
			this.importinvoicedetails =  importinvoicedetails;
		}
		
		private Druginvoice druginvoice;

		public  Druginvoice getDruginvoice() {
			return druginvoice;
		}

		public  void setDruginvoice(Druginvoice druginvoice) {
			this.druginvoice = druginvoice;
		}
		
		
		
}
