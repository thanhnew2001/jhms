package com.ph.hms.action.util;

import java.sql.ResultSet;
import java.util.ArrayList;

import antlr.collections.List;


import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Druginvoice;
import com.ph.hms.DruginvoiceManager;
import com.ph.hms.EncounterManager;
import com.ph.hms.HMSDataManager;
import com.ph.hms.Receipt;
import com.ph.hms.ReceiptManager;

public class PrepaidCardTransactionDetailAction extends ActionSupport {

	private String prepaidCard;
	
	public String getPrepaidCard() {
		return prepaidCard;
	}

	public void setPrepaidCard(String prepaidCard) {
		this.prepaidCard = prepaidCard;
	}
	
	private ArrayList<Receipt> receipts;
	
	private ArrayList<Druginvoice> druginvoices;
	
	public ArrayList<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(ArrayList<Receipt> receipts) {
		this.receipts = receipts;
	}

	public ArrayList<Druginvoice> getDruginvoices() {
		return druginvoices;
	}

	public void setDruginvoices(ArrayList<Druginvoice> druginvoices) {
		this.druginvoices = druginvoices;
	}
	
	private ReceiptManager receiptManager;
	
	private DruginvoiceManager druginvoiceManager;
	
	private EncounterManager encounterManager;
	
	
	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}

	public DruginvoiceManager getDruginvoiceManager() {
		return druginvoiceManager;
	}

	public void setDruginvoiceManager(DruginvoiceManager druginvoiceManager) {
		this.druginvoiceManager = druginvoiceManager;
	}
	
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}
	
	private double totalPaid;
	
	
	
	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	private I18nManager i18nManager;
	
	

	public I18nManager getI18nManager() {
		return i18nManager;
	}

	public void setI18nManager(I18nManager manager) {
		i18nManager = manager;
	}
	
	private double remain;
	
	

	public double getRemain() {
		return remain;
	}

	public void setRemain(double remain) {
		this.remain = remain;
	}

	public String execute() throws Exception {
		
		receipts = (ArrayList<Receipt>)receiptManager.getReceiptByPrepaidCard(prepaidCard);
		
		druginvoices = (ArrayList<Druginvoice>)druginvoiceManager.getDruginvoiceByPrepaidCard(prepaidCard);
		
		totalPaid = encounterManager.getTotalPaidOfPrepaidCard(prepaidCard);
		
		remain = 1000000 - totalPaid;
						
		return SUCCESS;
	}
}
