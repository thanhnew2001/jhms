package com.ph.hms.test;

import java.text.DateFormat;
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
import com.ph.hms.manager.ReceiptManager;
public class Test2 extends TestCase {
	
	private ApplicationContext ctx = null;

	private EncounterManager encounterManager = null;
	
	private ReceiptManager receiptManager = null;
	
	 public Test2() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        encounterManager = (EncounterManager) ctx.getBean("encounterManager");
	        receiptManager = (ReceiptManager)ctx.getBean("receiptManager");
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	        encounterManager = null;
	        receiptManager = null;
	    }

	  /*  public void testSaveRecord() throws Exception {
	       
	    	Collection<Encounter> encounters = encounterManager.searchEncounterForDrug("thanh");
	    	//Collection<Encounter> encounters = encounterManager.getEncounterByClientId(5);
	    	
	    	System.out.println(encounters.size());
	        
	    	Encounter encounter;
	    		    	
	    	for(Encounter e:encounters)
	    	{
	    		System.out.println(e.getId());
	    	}
	    	
	        //assertEquals(encounter.getId(), 1);
	    }*/
	    
	   /* public void testEncounter() throws Exception
	    {
	    	Encounter e = encounterManager.getEncounter(145);
	    	
	    	e.setEncounterType(2);
	    	
	    	Collection<Encounter> encounters = encounterManager.getEncounterByType(2);
	    	
	    	assertEquals(encounters.size(), 1);
	    	
	    	
	    	
	    }*/
	    
	    
	    public void testSort()
	    {
	    	Encounter enc = new Encounter();
	    	
	    	//encounterManager.addEncounter(enc);
	    	
	    	enc.setAdvise("advise");
	    	
	    	encounterManager.addEncounter(enc);
	    	
	    	Encounter e = encounterManager.getEncounter(89);	    	
	    	
	    	Collection<Prescriptiondetail> prescriptiondetails = e.getPrescriptiondetails();
	    	
	    	
	    	for(Prescriptiondetail pd: prescriptiondetails)
	    	{
	    		System.out.println(pd.getId());	    		
	    	}
	    	
	    	e.setInitialdiagnosis("xxxxxxxxxxxxxxx");
	    	e.setAdvise("cua basc si");
	    	encounterManager.updateEncounter(e);
	    	
	    	System.out.print("hey");
	    	
	    	//assertEquals(encounters.size(), 1);	
	    }
	    
	    public void testEncounter()
	    {
	    	Encounter enc = new Encounter();
	    
	    	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
	    	Date d = new Date();
			try
			{
				d = sdf.parse( "06/01/2010 12:00:00" ) ;
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		
	    	
	    	Collection<Encounter> encs = encounterManager.searchEncounterForDrug("", d);
	    	
	    	encs = encounterManager.searchEncounterForIndicationdetail("", d);
	    	for(Encounter en:encs)
	    	{
	    		System.out.println(en);
	    		System.out.println(en.getPrescriptiondetails());
	    	}
	    	
	    	
	    }
	    
	    public void testReceiptManager()
	    {	    	
	    	ArrayList<Receipt> receipts = (ArrayList<Receipt>)receiptManager.getReceiptByPrepaidCard("VI001");
	    	
	    	for(Receipt r:receipts)
	    	{
	    		System.out.println(r.getPrepaidCard());
	    	}
	    	
	    	System.out.println(encounterManager.getTotalPaidOfPrepaidCard("VI001"));
	    	
	    }
	    

	}
