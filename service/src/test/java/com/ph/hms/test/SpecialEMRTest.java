package com.ph.hms.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ph.hms.Encounter;
import com.ph.hms.ServicegroupManager;
import com.ph.hms.cardmanagement.*;
import com.ph.hms.cardmanagement.hibernate.*;
import com.ph.hms.manager.EncounterManager;
import com.ph.hms.manager.IndicationdetailManager;
import com.ph.hms.manager.ReceiptManager;
import com.ph.hms.manager.ServiceManager;
import com.ph.hms.smarthealth.Concept;
import com.ph.hms.smarthealth.ConceptManager;
import com.ph.hms.smarthealth.ConceptName;
import com.ph.hms.smarthealth.GenericDao;
import com.ph.hms.specialemr.SpecialEMR;


public class SpecialEMRTest extends TestCase {
	
	private ApplicationContext ctx = null;

	private EncounterManager encounterManager = null;	
	
	private GenericDao genericDao;	
	
	
		
	public SpecialEMRTest() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        
	        encounterManager = (EncounterManager) ctx.getBean("encounterManager");
	        
	        genericDao = (GenericDao)ctx.getBean("genericDao");
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();

	    }

	    public void testCard()
	    {
	    	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
	    	Date d = new Date();	    	
	    	Date d1 = new Date();
	    	Date d2 = new Date();
			try
			{
				d = sdf.parse( "06/01/2010 12:00:00" ) ;
				d1 = sdf.parse( "01/01/2010 12:00:00" ) ;
				d2 = sdf.parse( "31/12/2010 12:00:00" ) ;
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			//Encounter encounter = new Encounter();
			
			//encounter = encounterManager.getEncounter(2);
				
			SpecialEMR se = new SpecialEMR();
			se.setName("BA bac si gia dinh");
			genericDao.save(se);
	    }
	    
	}
