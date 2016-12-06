package com.ph.hms.cardmanagement;

import com.ph.hms.Service;
import com.ph.hms.Servicegroup;

public class PrivilegeDetail {

	private int id;
	
	private Privilege privilege;
	
	private Service service;
	
	private Servicegroup serviceGroup;

	public Servicegroup getServiceGroup() {
		return serviceGroup;
	}

	public void setServiceGroup(Servicegroup serviceGroup) {
		this.serviceGroup = serviceGroup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}
}

