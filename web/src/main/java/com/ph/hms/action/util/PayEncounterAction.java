package com.ph.hms.action.util;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Druginvoice;
import com.ph.hms.DruginvoiceManager;
import com.ph.hms.Encounter;
import com.ph.hms.EncounterManager;
import com.ph.hms.Receipt;
import com.ph.hms.ReceiptManager;
import com.ph.hms.ReceiptdetailManager;

public class PayEncounterAction extends ActionSupport {

	private int encounterid;

	private EncounterManager encounterManager;

	private ReceiptManager receiptManager;

	private ReceiptdetailManager receiptdetailManager;

	private DruginvoiceManager druginvoiceManager;

	public int getEncounterid() {
		return encounterid;
	}

	public void setEncounterid(int encounterid) {
		this.encounterid = encounterid;
	}

	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}

	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}

	public ReceiptdetailManager getReceiptdetailManager() {
		return receiptdetailManager;
	}

	public void setReceiptdetailManager(
			ReceiptdetailManager receiptdetailManager) {
		this.receiptdetailManager = receiptdetailManager;
	}

	public DruginvoiceManager getDruginvoiceManager() {
		return druginvoiceManager;
	}

	public void setDruginvoiceManager(DruginvoiceManager druginvoiceManager) {
		this.druginvoiceManager = druginvoiceManager;
	}

	public String execute() {

		Encounter encounter = encounterManager.getEncounter(encounterid);

		//creating 1 receipt
		Receipt receipt = new Receipt();

		receipt.setEncounter(encounter);

		receiptManager.addReceipt(receipt);

		//creating 1 druginvoice

		Druginvoice druginvoice = new Druginvoice();

		druginvoice.setEncounter(encounter);

		druginvoiceManager.addDruginvoice(druginvoice);

		return SUCCESS;

	}
}
