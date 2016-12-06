
package com.ph.hms;

import java.util.*;

public class Indicationdetail implements Comparable<Indicationdetail>{
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int compareTo(Indicationdetail o) {
		
		return this.id - o.id;
		
	}
	@Override
	public String toString() {
		return this.service.getNode();
	}
	private Encounter encounter;   
		
	
	public Encounter getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(Encounter encounter)
	{
		this.encounter =  encounter;
	}
	
	private Service service;   
		
	
	public Service getService()
	{
		return service;
	}
	
	public void setService(Service service)
	{
		this.service =  service;
	}
	
	private int quantity;   
		
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity =  quantity;
	}
	
	private double price;   
		
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price =  price;
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
	
	private String note;   
		
	
	public String getNote()
	{
		return note;
	}
	
	public void setNote(String note)
	{
		this.note =  note;
	}
	
	private String status;   
		
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status =  status;
	}
	
	private String paid;   
		
	
	public String getPaid()
	{
		return paid;
	}
	
	public void setPaid(String paid)
	{
		this.paid =  paid;
	}
	
	private String request;
	
	private String result;
	
	private String timedone;
	
	private String file1;
	
	private String file2;
	
	private String file3;
	
	private String file4;
	
	private User user;

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTimedone() {
		return timedone;
	}

	public void setTimedone(String timedone) {
		this.timedone = timedone;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}
	
	

	public String getFile4() {
		return file4;
	}

	public void setFile4(String file4) {
		this.file4 = file4;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String shortResult;

	public String getShortResult() {
		return shortResult;
	}

	public void setShortResult(String shortResult) {
		this.shortResult = shortResult;
	}
	
	private User indDoctor;

	public User getIndDoctor() {
		return indDoctor;
	}

	public void setIndDoctor(User indDoctor) {
		this.indDoctor = indDoctor;
	}
	
	private String file5;
	
	private String file6;
	
	private String file7;
	
	private String file8;

	public String getFile5() {
		return file5;
	}

	public void setFile5(String file5) {
		this.file5 = file5;
	}

	public String getFile6() {
		return file6;
	}

	public void setFile6(String file6) {
		this.file6 = file6;
	}

	public String getFile7() {
		return file7;
	}

	public void setFile7(String file7) {
		this.file7 = file7;
	}

	public String getFile8() {
		return file8;
	}

	public void setFile8(String file8) {
		this.file8 = file8;
	}
	
	private String note1;
	
	private String note2;
	
	private String note3;
	
	private String note4;
	
	private String note5;
	
	private String note6;
	
	private String note7;
	
	private String note8;

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getNote3() {
		return note3;
	}

	public void setNote3(String note3) {
		this.note3 = note3;
	}

	public String getNote4() {
		return note4;
	}

	public void setNote4(String note4) {
		this.note4 = note4;
	}

	public String getNote5() {
		return note5;
	}

	public void setNote5(String note5) {
		this.note5 = note5;
	}

	public String getNote6() {
		return note6;
	}

	public void setNote6(String note6) {
		this.note6 = note6;
	}

	public String getNote7() {
		return note7;
	}

	public void setNote7(String note7) {
		this.note7 = note7;
	}

	public String getNote8() {
		return note8;
	}

	public void setNote8(String note8) {
		this.note8 = note8;
	}
	
		
	private Collection<ServiceParamValue> serviceParamValues;

	public Collection<ServiceParamValue> getServiceParamValues() {
		return serviceParamValues;
	}

	public void setServiceParamValues(
			Collection<ServiceParamValue> serviceParamValues) {
		this.serviceParamValues = serviceParamValues;
	}
	
	
	


}
