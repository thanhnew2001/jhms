
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Receipt;

public interface ReceiptManager {

	String ID = ReceiptManager.class.getName();
	
	public void addReceipt(Receipt receipt);
	
	public void updateReceipt(Receipt receipt);
	
	public void deleteReceipt(int id);
	
	public Receipt getReceipt(int id);
	
	public Collection<Receipt> getAllReceipts();
	
	public Collection<Receipt> filter(String typehead);
	
	public Collection<Receipt> filterAll(String typehead);
	
	public Collection<Receipt> filterByCon(String con, String typehead);
	
	public Collection<Receipt> filterByDate( Date date );
	
	public String genCode(String formula);
	
	public Collection<Receipt> getReceiptByPrepaidCard(String prepaidCard);

}
