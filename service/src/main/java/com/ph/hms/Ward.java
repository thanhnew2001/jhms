
package com.ph.hms;

import java.util.*;

public class Ward {

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
	
	private District district;   
		
	
	public District getDistrict()
	{
		return district;
	}
	
	public void setDistrict(District district)
	{
		this.district =  district;
	}
	
	private float lon;
	
	private float lat;

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}
	
	
	
}
