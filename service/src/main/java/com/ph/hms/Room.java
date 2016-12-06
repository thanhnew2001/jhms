
package com.ph.hms;

import java.util.*;

public class Room {

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
	
	private Department department;   
		
	
	public Department getDepartment()
	{
		return department;
	}
	
	public void setDepartment(Department department)
	{
		this.department =  department;
	}
	
	private String doctor;   
		
	
	public String getDoctor()
	{
		return doctor;
	}
	
	public void setDoctor(String doctor)
	{
		this.doctor =  doctor;
	}
	
}
