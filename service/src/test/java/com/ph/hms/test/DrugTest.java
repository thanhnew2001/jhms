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
import com.ph.hms.manager.ReceiptManager;
public class DrugTest extends TestCase {
	
	private ApplicationContext ctx = null;

	private DruginvoiceManager druginvoiceManager = null;
	
	private WarehouseManager warehouseManager = null;
	
	private ReceiptManager receiptManager = null;
	
	 public DrugTest() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        druginvoiceManager = (DruginvoiceManager) ctx.getBean("druginvoiceManager");
	        warehouseManager = (WarehouseManager)ctx.getBean("warehouseManager");
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	        druginvoiceManager = null;
	        receiptManager = null;
	    }

	 
	  
	    public void testDruginvoiceTax()
	    {
	    	Druginvoice di = new Druginvoice();
	    
	    	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
	    	Date d = new Date();	    	
	    	Date d1 = new Date();
	    	Date d2 = new Date();
			try
			{
				d = sdf.parse( "06/01/2010 12:00:00" ) ;
				d1 = sdf.parse( "06/02/2010 12:00:00" ) ;
				d2 = sdf.parse( "06/12/2009 12:00:00" ) ;
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}

			di.setTax("Y");
			di.setDate(d2);
			di.setPaymentMethod("TT");
			di.setWarehouse(warehouseManager.getWarehouse(1));
			
	    	druginvoiceManager.addDruginvoice(di);
			//ArrayList<Druginvoice> dis1 = (ArrayList<Druginvoice>)druginvoiceManager.getDrugInvoiceWithTax("Y", warehouseManager.getWarehouse(1), d, null);
		
			//ArrayList<Druginvoice> dis2 = (ArrayList<Druginvoice>)druginvoiceManager.getDrugInvoiceWithTax("N", warehouseManager.getWarehouse(1), d, null);
			
			/*assertEquals(dis1.size(), 3);
			assertEquals(dis2.size(), 0);
			*/
	    	
	    	ArrayList<Druginvoice> dis1 = (ArrayList<Druginvoice>)druginvoiceManager.getDrugInvoiceByMonthWithTax("1", "2010", "", warehouseManager.getWarehouse(1));
	    	ArrayList<Druginvoice> dis2 = (ArrayList<Druginvoice>)druginvoiceManager.getDrugInvoiceByMonthWithTax("12", "2009", "Y", warehouseManager.getWarehouse(1));
	    	ArrayList<Druginvoice> dis3 = (ArrayList<Druginvoice>)druginvoiceManager.getDrugInvoiceByMonthWithTax("12", "2009", "N", warehouseManager.getWarehouse(1));
	    	
	    	System.out.println("all="+dis1);
	    	
	    	System.out.println("y="+dis2);
	    	
	    	System.out.println("n="+dis3);
	    	
	    }
	    


	}
