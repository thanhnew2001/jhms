package com.ph.hms.smarthealth.action;

import java.util.Collection;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Service;
import com.ph.hms.ServiceManager;
import com.ph.hms.ServiceParam;
import com.ph.hms.Servicegroup;
import com.ph.hms.ServicegroupManager;
import com.ph.hms.cardmanagement.CardManager;
import com.ph.hms.cardmanagement.CardType;
import com.ph.hms.smarthealth.GenericDao;
import com.ph.hms.smarthealth.*;

public class ConceptClassAction extends ActionSupport {

	
	//property of manager
	private GenericDao genericDao;
	

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}
	
	private String action;
	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	//property of a param
	private int id;
	
	private String name;
	
	private String description;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//object to transfer
	private ConceptClass conceptClass;
	
	public ConceptClass getConceptClass() {
		return conceptClass;
	}

	public void setConceptClass(ConceptClass conceptClass) {
		this.conceptClass = conceptClass;
	}

	//list of object to be shown
	private Collection<ConceptClass> conceptClasses;

	public Collection<ConceptClass> getConceptClasses() {
		return conceptClasses;
	}

	public void setConceptClasses(Collection<ConceptClass> conceptClasses) {
		this.conceptClasses = conceptClasses;
	}
	
	//for details
		
	public String execute()
	{
		
		if(action==null) action = "";

		conceptClass = (ConceptClass)genericDao.get(ConceptClass.class, id);
		if (conceptClass==null)
			conceptClass = new ConceptClass();
		
		//do the same for details: name
	
				
		if(action.equalsIgnoreCase("save"))
		{	
			//setting property
			conceptClass.setName(name);
			conceptClass.setDescription(description);
			
			genericDao.saveOrUpdate(conceptClass);
		}
		
		//for details
		
		if(action.equalsIgnoreCase("delete"))
		{
			genericDao.delete(genericDao.get(ConceptClass.class, id));			
		}
		//for detail
		
		
		//reload a list of card type
		conceptClasses = genericDao.getAll(ConceptClass.class);

		if(!action.equalsIgnoreCase("delete"))
		{
			conceptClass = (ConceptClass)genericDao.get(ConceptClass.class, id);
		}

		return SUCCESS;	
		}
	
}
