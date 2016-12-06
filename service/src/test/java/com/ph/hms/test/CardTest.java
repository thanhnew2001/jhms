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

import sun.net.www.content.text.Generic;

import com.ph.hms.cardmanagement.*;
import com.ph.hms.cardmanagement.hibernate.*;

import com.ph.hms.manager.ReceiptManager;
import com.ph.hms.manager.ServiceManager;
import com.ph.hms.smarthealth.GenericDao;


public class CardTest extends TestCase {
	
	private ApplicationContext ctx = null;

	private ServiceManager serviceManager = null;

	
	private ReceiptManager receiptManager = null;
	
	private CardManager cardManager = null;
	
	private GenericDao genericDao = null;
	
	public CardTest() {
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
	        serviceManager = null;
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

			CardType cardType = new CardType();
			cardType.setCode("LG ");
			cardType.setName("The lady card gold by generic");
				
			genericDao.save(cardType);
			
			Card card = new Card();
			card.setCode("LG20001");
			card.setCardType(cardType);
			card.setStartDate(d1);
			card.setEndDate(d2);
					
			genericDao.save(card);
			
			Privilege p1 = new Privilege();
			
			p1.setCardType(cardType);
				p1.setPercentDiscount(10);
			genericDao.save(p1);
			
			p1.setCardType(cardType);
			//p1.setServiceGroup(serviceGroupManager.getServicegroup(1));
			p1.setPercentDiscount(10);
			p1.setName("Giam 10% cho the golden card");
			genericDao.save(p1);
			
			System.out.println(cardManager.searchCardTypes("KT", 1, 1));
			
			//System.out.println(cardManager.searchPrivilegesByCardType(cardType, 100, 1));
		
			System.out.println(cardManager.getAllCardTypes());
			
			//now testing privilege detail
			PrivilegeDetail pd1 = new PrivilegeDetail();
			pd1.setPrivilege(p1);
			pd1.setService(serviceManager.getService(2));
			genericDao.save(pd1);
			
			PrivilegeDetail pd2 = new PrivilegeDetail();
			pd2.setPrivilege(p1);
			pd2.setService(serviceManager.getService(5));
			genericDao.save(pd2);
			
			List<PrivilegeDetail> pds2 = (List<PrivilegeDetail>)cardManager.getAllPrivilegeDetailsByService(serviceManager.getService(2), 0, 0);
			/*System.out.println(pds2.size());
			
			for(PrivilegeDetail pdetail: pds2)
			{
				System.out.println("abc");
			}
			System.out.println("privilege detail by privilege=");*/

			
			Privilege p5 = (Privilege)genericDao.get(Privilege.class, p1.getId());
			
			System.out.println("privilege 5="+p5);
			
			System.out.println("card="+cardManager.getCardByCode("LG20001", 0, 0));
			
			System.out.println("encounter"+cardManager.getEncountersByCard(cardManager.getCardByCode("LG20001", 0, 0)));
					
		/*	System.out.println(cardManager.searchPrivilegesByService(serviceManager.getService(2), 100, 1));
			System.out.println(cardManager.searchPrivilegesByServiceGroup(serviceGroupManager.getServicegroup(1), 100, 1));
	    */


	    }
	    


	}
