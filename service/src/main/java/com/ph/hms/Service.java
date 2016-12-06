
package com.ph.hms;

import java.util.*;

public class Service {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	private Servicegroup servicegroup;   
		
	
	public Servicegroup getServicegroup()
	{
		return servicegroup;
	}
	
	public void setServicegroup(Servicegroup servicegroup)
	{
		this.servicegroup =  servicegroup;
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
	
	private double insuranceprice;   
		
	
	public double getInsuranceprice()
	{
		return insuranceprice;
	}
	
	public void setInsuranceprice(double insuranceprice)
	{
		this.insuranceprice =  insuranceprice;
	}
	
	private Department department;   
		
	
	public Department getDepartment()
	{
		return department;
	}
	
	public void setDepartment(Department department)
	{
		this.department =  department;
	}
	
	private double min;
	
	private double max;

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}
	
	private BodyPart bodyPart;

	public BodyPart getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(BodyPart bodyPart) {
		this.bodyPart = bodyPart;
	}
	
	private String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	private Collection<ServiceParam> serviceParams;

	public Collection<ServiceParam> getServiceParams() {
		return serviceParams;
	}

	public void setServiceParams(Collection<ServiceParam> serviceParams) {
		this.serviceParams = serviceParams;
	}
	
	
	
}
