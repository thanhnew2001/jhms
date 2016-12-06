
package com.ph.hms;

import java.util.*;

public class District {

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
	
	private Province province;   
		
	
	public Province getProvince()
	{
		return province;
	}
	
	public void setProvince(Province province)
	{
		this.province =  province;
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
