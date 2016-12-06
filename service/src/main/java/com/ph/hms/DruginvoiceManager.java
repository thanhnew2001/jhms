
package com.ph.hms;

import java.util.*;

public interface DruginvoiceManager {

	String ID = DruginvoiceManager.class.getName();
	
	public void addDruginvoice(Druginvoice druginvoice);
	
	public void updateDruginvoice(Druginvoice druginvoice);
	
	public void deleteDruginvoice(int id);
	
	public Druginvoice getDruginvoice(int id);
	
	public Collection<Druginvoice> getAllDruginvoices();
	
	public Collection<Druginvoice> filter(String typehead);
	
	public Collection<Druginvoice> filterAll(String typehead);
	
	public Collection<Druginvoice> filterByCon(String con, String typehead);
	
	public Collection<Druginvoice> filterByWarehouseDateType( Warehouse warehouse, Date date, String type );
	
	public String genCode(String formula);
	
	public Collection<Druginvoice> getNotImportedDruginvoices();
		
	public Collection<Druginvoice> getDruginvoiceByPrepaidCard(String prepaidCard);
	
	public Collection<Druginvoice> getDrugInvoiceWithTax(String tax, Warehouse warehouse, Date date, String type);
	
	public Collection<Druginvoice> getDrugInvoiceByMonthWithTax(String month, String year, String tax, Warehouse warehouse);
	
}
