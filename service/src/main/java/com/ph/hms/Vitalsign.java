
package com.ph.hms;

import java.util.*;

public class Vitalsign {

	private int id;
	
	public int getId() {
		return id;
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
	
	private String time;   
		
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time =  time;
	}
	
	private int pulse;   
		
	
	public int getPulse()
	{
		return pulse;
	}
	
	public void setPulse(int pulse)
	{
		this.pulse =  pulse;
	}
	
	private int pressureh;   
		
	
	public int getPressureh()
	{
		return pressureh;
	}
	
	public void setPressureh(int pressureh)
	{
		this.pressureh =  pressureh;
	}
	
	private int pressurel;   
		
	
	public int getPressurel()
	{
		return pressurel;
	}
	
	public void setPressurel(int pressurel)
	{
		this.pressurel =  pressurel;
	}
	
	private double temparature;   
		
	
	public double getTemparature()
	{
		return temparature;
	}
	
	public void setTemparature(double temparature)
	{
		this.temparature =  temparature;
	}
	
	private int breath;   
		
	
	public int getBreath()
	{
		return breath;
	}
	
	public void setBreath(int breath)
	{
		this.breath =  breath;
	}
	
	private int sbo2;

	public int getSbo2() {
		return sbo2;
	}

	public void setSbo2(int sbo2) {
		this.sbo2 = sbo2;
	}
	
	private int height;
	
	private int weight;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	private double bmi;	
	
	
	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}


	private int head;


	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}
	
	

	
}
