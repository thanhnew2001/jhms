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

public class ConceptAction extends ActionSupport {

	
	//property of manager
	private GenericDao genericDao;
	

	public GenericDao getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao genericDao) {
		this.genericDao = genericDao;
	}

	//property of a param
	private int id;
	
	private String shortName;
	
	private int conceptClassId;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	private String action;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	//object to transfer
	private Concept concept;
	
	public Concept getConcept() {
		return concept;
	}

	public void setConcept(Concept concept) {
		this.concept = concept;
	}	

		
	//list of object to be shown
	private Collection<Concept> concepts;
	private Collection<ConceptClass> conceptClasses;	

	public Collection<Concept> getConcepts() {
		return concepts;
	}

	public Collection<ConceptClass> getConceptClasses() {
		return conceptClasses;
	}
	
	public int getConceptClassId() {
		return conceptClassId;
	}

	public void setConceptClassId(int conceptClassId) {
		this.conceptClassId = conceptClassId;
	}

	public void setConcepts(Collection<Concept> concepts) {
		this.concepts = concepts;
	}

	public void setConceptClasses(Collection<ConceptClass> conceptClasses) {
		this.conceptClasses = conceptClasses;
	}

	//for details
	
	private int conceptNameId;
	
	public int getConceptNameId() {
		return conceptNameId;
	}

	public void setConceptNameId(int conceptNameId) {
		this.conceptNameId = conceptNameId;
	}

	private ConceptName conceptName;
	
	
	public ConceptName getConceptName() {
		return conceptName;
	}

	public void setConceptName(ConceptName conceptName) {
		this.conceptName = conceptName;
	}

	private String name;
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute()
	{
		
		if(action==null) action = "";

		concept = (Concept)genericDao.get(Concept.class, id);
		if (concept==null)
			concept = new Concept();
		
		//do the same for details: name
		conceptName = (ConceptName)genericDao.get(ConceptName.class, conceptNameId);
		if (conceptName==null)
			conceptName = new ConceptName();
	
				
		if(action.equalsIgnoreCase("save"))
		{	
			//setting property
			concept.setShortName(shortName);
			concept.setConceptClass((ConceptClass)genericDao.get(ConceptClass.class, conceptClassId));
			genericDao.saveOrUpdate(concept);
		}
		
		//for details
		if(action.equalsIgnoreCase("savedetail"))
		{	
			//setting property
			conceptName.setConcept(concept);	
			conceptName.setName(name);
			genericDao.saveOrUpdate(conceptName);
		}
		
		
		if(action.equalsIgnoreCase("delete"))
		{
			genericDao.delete(genericDao.get(Concept.class, id));			
		}
		//for detail
		if(action.equalsIgnoreCase("deletedetail"))
		{
			genericDao.delete(genericDao.get(ConceptName.class, conceptNameId));			
		}
		
		
		//reload a list of card type
		concepts = genericDao.getAll(Concept.class);
		conceptClasses = genericDao.getAll(ConceptClass.class);
		if(!action.equalsIgnoreCase("delete"))
		{
			concept = (Concept)genericDao.get(Concept.class, id);
		}
		 

		return SUCCESS;	
		}
	
}
