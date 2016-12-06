
package com.ph.hms;

import java.util.*;

public class Prescriptiondetail implements Comparable<Prescriptiondetail> {

	private int id;
	
	public int getId() {
		return id;
	}

	public int compareTo(Prescriptiondetail o) {
		
		return this.id - o.id;
		
	}

	public void setId(int id) {
		this.id = id;
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
	
	private Drug drug;   
		
	
	public Drug getDrug()
	{
		return drug;
	}
	
	public void setDrug(Drug drug)
	{
		this.drug =  drug;
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
	
	private String unit;   
		
	
	public String getUnit()
	{
		return unit;
	}
	
	public void setUnit(String unit)
	{
		this.unit =  unit;
	}
	
	private int timeuse;   
		
	
	public int getTimeuse()
	{
		return timeuse;
	}
	
	public void setTimeuse(int timeuse)
	{
		this.timeuse =  timeuse;
	}
	
	private double quantityuse;   
		
	public double getQuantityuse() {
		return quantityuse;
	}

	public void setQuantityuse(double quantityuse) {
		this.quantityuse = quantityuse;
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
	
	private double price;   
		
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price =  price;
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
	
	private User indDoctor;

	public User getIndDoctor() {
		return indDoctor;
	}

	public void setIndDoctor(User indDoctor) {
		this.indDoctor = indDoctor;
	}
	
	private String usageDescription;

	public String getUsageDescription() {
		return usageDescription;
	}

	public void setUsageDescription(String usageDescription) {
		this.usageDescription = usageDescription;
	}
	
	private String howtouse;

	public String getHowtouse() {
		return howtouse;
	}

	public void setHowtouse(String howtouse) {
		this.howtouse = howtouse;
	}

	private double morning;
	
	private double afternoon;
	
	private double evening;
	
	private double night;

	public double getMorning() {
		return morning;
	}

	public void setMorning(double morning) {
		this.morning = morning;
	}

	public double getAfternoon() {
		return afternoon;
	}

	public void setAfternoon(double afternoon) {
		this.afternoon = afternoon;
	}

	public double getEvening() {
		return evening;
	}

	public void setEvening(double evening) {
		this.evening = evening;
	}

	public double getNight() {
		return night;
	}

	public void setNight(double night) {
		this.night = night;
	}
	
	

}
