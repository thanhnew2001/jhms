
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Exportcard;
import com.ph.hms.Warehouse;

public interface ExportcardManager {

	String ID = ExportcardManager.class.getName();
	
	public void addExportcard(Exportcard exportcard);
	
	public void updateExportcard(Exportcard exportcard);
	
	public void deleteExportcard(int id);
	
	public Exportcard getExportcard(int id);
	
	public Collection<Exportcard> getAllExportcards();
	
	public Collection<Exportcard> filter(String typehead);
	
	public Collection<Exportcard> filterAll(String typehead);
	
	public Collection<Exportcard> filterByCon(String con, String typehead);
	
	public Collection<Exportcard> filterByDateWarehouse( Date date, Warehouse warehouse );
	
	public String genCode(String formula);
	
	

}
