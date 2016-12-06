package com.ph.hms.action;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.sql.ResultSet;
import java.util.*;

import com.opensymphony.xwork.*;

public class ReceiptEditFormAction extends ActionSupport {
	public String fname = "receipt";
	public String aname = "update";

	private Receipt receipt;

	private int id;

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private ReceiptManager receiptManager;

	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}

	private Collection<Receipt> receipts;

	public Collection<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Collection<Receipt> receipts) {
		this.receipts = receipts;
	}

	private PaymenttypeManager paymenttypeManager;

	public PaymenttypeManager getPaymenttypeManager() {
		return paymenttypeManager;
	}

	public void setPaymenttypeManager(PaymenttypeManager paymenttypeManager) {
		this.paymenttypeManager = paymenttypeManager;
	}

	private Collection<Paymenttype> paymenttypes;

	public Collection<Paymenttype> getPaymenttypes() {
		return paymenttypes;
	}

	public void setPaymenttypes(Collection<Paymenttype> paymenttypes) {
		this.paymenttypes = paymenttypes;
	}

	private EncounterManager encounterManager;

	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}

	private Collection<Encounter> encounters;

	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
	}

	private UserManager userManager;

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	private Collection<User> users;

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	private Hashtable<String, String> i18n;

	public Hashtable<String, String> getI18n() {
		return i18n;
	}

	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}

	private I18nManager i18nManager;

	public I18nManager getI18nManager() {
		return i18nManager;
	}

	public void setI18nManager(I18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}

	private double percentDiscount;

	private HMSDataManager hmsDataManager;

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}

	private Collection<Receiptdetail> receiptdetails;

	public Collection<Receiptdetail> getReceiptdetails() {
		return receiptdetails;
	}

	public void setReceiptdetails(Collection<Receiptdetail> receiptdetails) {
		this.receiptdetails = receiptdetails;
	}

	public String execute() throws Exception {

		try {

			i18n = i18nManager.geti18n();

			DefaultSecurity ds = new DefaultSecurity();

			boolean matched = ds.checkRight(fname, aname);

			if (matched == false)
				return "noprivilege";

			receipts = (Collection<Receipt>) receiptManager.getAllReceipts();

			paymenttypes = (Collection<Paymenttype>) paymenttypeManager
					.getAllPaymenttypes();

			// encounters =
			// (Collection<Encounter>)encounterManager.getAllEncounters(null);

			users = (Collection<User>) userManager.getAllUsers();

			receipt = receiptManager.getReceipt(id);
			
			receiptdetails = new ArrayList<Receiptdetail>();

			for (Receiptdetail rd : receipt.getReceiptdetails()) {
				receiptdetails.add(rd);
			}

			Collections.sort((List<Receiptdetail>) receiptdetails);

			// tinh khuyen mai (tam thoi de nhu vay)
			/*
			 * String promotionCode = receipt.getEncounter().getPromotionCode();
			 * promotionCode = promotionCode.substring(0, 2);
			 * System.out.println(promotionCode); String q =
			 * "select * from encounter where promotionCode like '%" +
			 * "promotionCode" + "%' and client = " + receipt.getEncounter();
			 * ResultSet rs = hmsDataManager.getResultset(q); int i = 0;
			 * while(rs.next()) { i++; }
			 * 
			 * if(i==0) { percentDiscount = 0; } else { rs = hmsDataManager }
			 */

			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}
	}

	public double getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(double percentDiscount) {
		this.percentDiscount = percentDiscount;
	}
}
