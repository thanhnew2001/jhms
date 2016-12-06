package com.ph.hms.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ph.hms.cardmanagement.CardManager;
import com.ph.hms.manager.ReceiptManager;
import com.ph.hms.manager.ServiceManager;
import com.ph.hms.smarthealth.Concept;
import com.ph.hms.smarthealth.ConceptName;
import com.ph.hms.smarthealth.GenericDao;


public class ConceptTest extends TestCase {
	
	private ApplicationContext ctx = null;

	private ServiceManager serviceManager = null;
	
		
	private ReceiptManager receiptManager = null;
	
	private CardManager cardManager = null;
	
		
	private GenericDao genericDao;	
		
	public ConceptTest() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        serviceManager = (ServiceManager) ctx.getBean("serviceManager");
	        
	        cardManager = (CardManager)ctx.getBean("cardManager");
	        
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

		
			Concept concept = new Concept();
			concept.setShortName("concept 1");
			genericDao.save(concept);
			
			ConceptName conceptName = new ConceptName();
			conceptName.setConcept(concept);
			conceptName.setLocale("vn");
			conceptName.setName("ten 1 concept 1");
			
			genericDao.save(conceptName);
			
			System.out.println(genericDao.getAll(Concept.class));
			
			System.out.println(genericDao.getAll(ConceptName.class));
			
			
			System.out.println(genericDao.search(ConceptName.class, "name", "concept 1", 10, 1));
			

	    }
	    
	}
