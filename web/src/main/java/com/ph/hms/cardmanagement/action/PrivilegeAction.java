package com.ph.hms.cardmanagement.action;

import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Service;
import com.ph.hms.ServiceManager;
import com.ph.hms.ServiceParam;
import com.ph.hms.Servicegroup;
import com.ph.hms.ServicegroupManager;
import com.ph.hms.cardmanagement.CardManager;
import com.ph.hms.cardmanagement.CardType;
import com.ph.hms.cardmanagement.Privilege;
import com.ph.hms.cardmanagement.PrivilegeDetail;

public class PrivilegeAction extends ActionSupport {

	private int cardTypeId;
	private int privilegeId;
	
	private CardManager cardManager;
	private ServiceManager serviceManager;
	private ServicegroupManager servicegroupManager;
	
	private CardType cardType;
	private Privilege privilege;
	
	private String name;
	private int percentDiscount;
		
	private Collection<Service> services;
	private Collection<Servicegroup> serviceGroups;
	
	private Collection<Integer> serviceIds;
	private Collection<Integer> serviceGroupIds;
	
	private String action;
	
	

	public int getCardTypeId() {
		return cardTypeId;
	}

	public void setCardTypeId(int cardTypeId) {
		this.cardTypeId = cardTypeId;
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	public CardManager getCardManager() {
		return cardManager;
	}

	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}

	public ServiceManager getServiceManager() {
		return serviceManager;
	}

	public void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public ServicegroupManager getServicegroupManager() {
		return servicegroupManager;
	}

	public void setServicegroupManager(ServicegroupManager servicegroupManager) {
		this.servicegroupManager = servicegroupManager;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPercentDiscount() {
		return percentDiscount;
	}

	public void setPercentDiscount(int percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public Collection<Service> getServices() {
		return services;
	}

	public void setServices(Collection<Service> services) {
		this.services = services;
	}

	public Collection<Servicegroup> getServiceGroups() {
		return serviceGroups;
	}

	public void setServiceGroups(Collection<Servicegroup> serviceGroups) {
		this.serviceGroups = serviceGroups;
	}

	public Collection<Integer> getServiceIds() {
		return serviceIds;
	}

	public void setServiceIds(Collection<Integer> serviceIds) {
		this.serviceIds = serviceIds;
	}

	public Collection<Integer> getServiceGroupIds() {
		return serviceGroupIds;
	}

	public void setServiceGroupIds(Collection<Integer> serviceGroupIds) {
		this.serviceGroupIds = serviceGroupIds;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	private Collection<String> selectedList = new HashSet<String>();;
		

	public Collection<String> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(Collection<String> selectedList) {
		this.selectedList = selectedList;
	}

	public String execute()
	{
		
		if(action==null) action = "";

		privilege = cardManager.getPrivilege(privilegeId);
		if (privilege==null)
			privilege = new Privilege();
		
		if(action.equalsIgnoreCase("save"))
		{			
			privilege.setName(name);
			privilege.setPercentDiscount(percentDiscount);
			privilege.setCardType(cardManager.getCardType(cardTypeId));
			
			///////////////loop through service/servicegroup list/////////////
			//remove details before adding
			for(PrivilegeDetail _pd:privilege.getPrivilegeDetails())
			{
				cardManager.deletePrivilegeDetail(_pd.getId());
			}
			for (String serviceGroupId: selectedList)
			{
				Servicegroup sg = servicegroupManager.getServicegroup(Integer.valueOf(serviceGroupId));
				PrivilegeDetail pd = new PrivilegeDetail();
				pd.setPrivilege(privilege);
				pd.setServiceGroup(sg);
				
				cardManager.addPrivilegeDetail(pd);
				privilege.getPrivilegeDetails().add(pd);
			}
						
			if(privilegeId>0)
			{
				cardManager.updatePrivilege(privilege);
			}
			else
			{
				cardManager.addPrivilege(privilege);
			}
		}
		
		if(action.equalsIgnoreCase("delete"))
		{
			cardManager.deletePrivilege(privilegeId);
		}
		
		//reload service from db
		privilege = cardManager.getPrivilege(privilegeId);
		cardType = cardManager.getCardType(cardTypeId);
		services = serviceManager.getAllServices();
		serviceGroups = servicegroupManager.getAllServicegroups();

		return SUCCESS;
	}
	
}
