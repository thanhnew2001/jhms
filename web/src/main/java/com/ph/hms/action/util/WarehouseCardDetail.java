package com.ph.hms.action.util;

import java.util.Date;

import com.ph.hms.Drug;

public class WarehouseCardDetail 
{
	private Date date;
	private String customer;
	private String node;
	private int totalquantity;
	private String batchnumber;
	private String visanumber;
	private int type;
	private String code;
	
	private String expireddate;
	private String expiredmonth;
	
	private int drug;
	
	public int getDrug() {
		return drug;
	}
	public void setDrug(int drug) {
		this.drug = drug;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public int getTotalquantity() {
		return totalquantity;
	}
	public void setTotalquantity(int totalquantity) {
		this.totalquantity = totalquantity;
	}
	public String getBatchnumber() {
		return batchnumber;
	}
	public void setBatchnumber(String batchnumber) {
		this.batchnumber = batchnumber;
	}
	public String getVisanumber() {
		return visanumber;
	}
	public void setVisanumber(String visanumber) {
		this.visanumber = visanumber;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	private int remain;
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getExpireddate() {
		return expireddate;
	}
	public void setExpireddate(String expireddate) {
		this.expireddate = expireddate;
	}
	public String getExpiredmonth() {
		return expiredmonth;
	}
	public void setExpiredmonth(String expiredmonth) {
		this.expiredmonth = expiredmonth;
	}
	
	
}
