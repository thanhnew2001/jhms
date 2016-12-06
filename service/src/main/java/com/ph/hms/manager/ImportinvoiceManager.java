
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Importinvoice;
import com.ph.hms.Warehouse;

public interface ImportinvoiceManager {

	String ID = ImportinvoiceManager.class.getName();
	
	public void addImportinvoice(Importinvoice importinvoice);
	
	public void updateImportinvoice(Importinvoice importinvoice);
	
	public void deleteImportinvoice(int id);
	
	public Importinvoice getImportinvoice(int id);
	
	public Collection<Importinvoice> getAllImportinvoices();
	
	public Collection<Importinvoice> filter(String typehead);
	
	public Collection<Importinvoice> filterAll(String typehead);
	
	public Collection<Importinvoice> filterByCon(String con, String typehead);
	
	public Collection<Importinvoice> filterByWarehouseDateType( Warehouse warehouse, Date date, String type );
	
	public String genCode(String formula);
	
	public Collection<Importinvoice> getImportinvoiceWithTax(String tax, Warehouse warehouse, Date date, String type );

	public Collection<Importinvoice> getImportinvoiceByMonthWithTax(String month, String year, String tax, Warehouse warehouse);


}
