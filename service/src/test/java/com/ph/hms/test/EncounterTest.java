package com.ph.hms.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.ph.hms.*;
import com.ph.hms.manager.EncounterManager;
import com.ph.hms.manager.IndicationdetailManager;
public class EncounterTest extends TestCase {
	
	private ApplicationContext ctx = null;

	private EncounterManager encounterManager = null;
	
	private DepartmentManager departmentManager = null;
	
	private IndicationdetailManager indicationdetailManager = null;
	
	private RoomManager roomManager = null;
	
	private SolvingManager solvingManager = null;
	
	 public EncounterTest() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        encounterManager = (EncounterManager) ctx.getBean("encounterManager");
	        indicationdetailManager = (IndicationdetailManager)ctx.getBean("indicationdetailManager");
	        departmentManager = (DepartmentManager)ctx.getBean("departmentManager");
	        solvingManager = (SolvingManager)ctx.getBean("solvingManager");
	        
	        roomManager = (RoomManager)ctx.getBean("roomManager");
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	        encounterManager = null;
	        indicationdetailManager = null;
	    }
	  
	    public void testEncounterByIndication()
	    {
	    	
	    	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
	    	Date d = new Date();	    	
	    	Date d1 = new Date();
	    	Date d2 = new Date();
	    	
			try {
				d = sdf.parse( "06/07/2010 12:00:00" ) ;
				d1 = sdf.parse( "06/02/2010 12:00:00" ) ;
				d2 = sdf.parse( "06/12/2009 12:00:00" ) ;				

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			    	
	    	Collection<Encounter> encounters =  encounterManager.searchEncounterForIndicationdetail(departmentManager.getDepartment(1), null, "NEW", "NGUYEN");
	    	
	    	//System.out.println(encounters);	    	
	    	
	    	Collection<Encounter> encounters2 = encounterManager.searchEncounterForEncounter(roomManager.getRoom(1), null, solvingManager.getSolving(3), "le");
	    	
	    	System.out.println(encounters2);
	    	
	    	encounters2 = encounterManager.searchEncounterForEncounter(roomManager.getRoom(2), null, solvingManager.getSolving(3), "nguyen");
	    	
	    	System.out.println(encounters2);
	    	
	    	encounters2 = encounterManager.searchEncounterForEncounter(roomManager.getRoom(3), null, solvingManager.getSolving(3), "tran");
	    	
	    	System.out.println(encounters2);
	    
	    	
	    	// Get current size of heap in bytes
	    	long heapSize = Runtime.getRuntime().totalMemory();
	    	
	    	System.out.println(heapSize);

	    	// Get maximum size of heap in bytes. The heap cannot grow beyond this size.
	    	// Any attempt will result in an OutOfMemoryException.
	    	long heapMaxSize = Runtime.getRuntime().maxMemory();
	    	
	    	System.out.println(heapMaxSize);

	    	// Get amount of free memory within the heap in bytes. This size will increase
	    	// after garbage collection and decrease as new objects are created.
	    	long heapFreeSize = Runtime.getRuntime().freeMemory();
	    	
	    	System.out.println(heapFreeSize);
	    	
	    	
	    	    	
	    }
	
	}
