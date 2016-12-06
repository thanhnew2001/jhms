
package com.ph.hms;

import java.util.*;

public class Drug {

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
	
	private String unit;   
		
	
	public String getUnit()
	{
		return unit;
	}
	
	public void setUnit(String unit)
	{
		this.unit =  unit;
	}
	
	private String ingredient;   
		
	
	public String getIngredient()
	{
		return ingredient;
	}
	
	public void setIngredient(String ingredient)
	{
		this.ingredient =  ingredient;
	}
	
	private String indication;   
		
	
	public String getIndication()
	{
		return indication;
	}
	
	public void setIndication(String indication)
	{
		this.indication =  indication;
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
	
	private String insurance;   
		
	
	public String getInsurance()
	{
		return insurance;
	}
	
	public void setInsurance(String insurance)
	{
		this.insurance =  insurance;
	}
	
	private double companyprice;
	
	private String forprescription;

	public double getCompanyprice() {
		return companyprice;
	}

	public void setCompanyprice(double companyprice) {
		this.companyprice = companyprice;
	}

	public String getForprescription() {
		return forprescription;
	}

	public void setForprescription(String forprescription) {
		this.forprescription = forprescription;
	}
	
	private DrugGroup drugGroup;

	public DrugGroup getDrugGroup() {
		return drugGroup;
	}

	public void setDrugGroup(DrugGroup drugGroup) {
		this.drugGroup = drugGroup;
	}
	
	private String genericName;

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	
	
	private String methodUse;

	public String getMethodUse() {
		return methodUse;
	}

	public void setMethodUse(String methodUse) {
		this.methodUse = methodUse;
	}
	
	
	
	
}
