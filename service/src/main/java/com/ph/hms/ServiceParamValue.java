
package com.ph.hms;

import java.util.*;

public class ServiceParamValue {

	private int id;
	
	private Indicationdetail indicationdetail;
	
	private ServiceParam serviceParam;
	
	private String value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Indicationdetail getIndicationdetail() {
		return indicationdetail;
	}

	public void setIndicationdetail(Indicationdetail indicationdetail) {
		this.indicationdetail = indicationdetail;
	}

	public ServiceParam getServiceParam() {
		return serviceParam;
	}

	public void setServiceParam(ServiceParam serviceParam) {
		this.serviceParam = serviceParam;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
