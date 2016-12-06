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
import com.ph.hms.manager.ImportinvoiceManager;
import com.ph.hms.manager.ReceiptManager;
public class ImportinvoiceTest extends TestCase {
	
	private ApplicationContext ctx = null;

	private ImportinvoiceManager importinvoiceManager = null;
	
	private WarehouseManager warehouseManager = null;
	
	private ReceiptManager receiptManager = null;
	
	 public ImportinvoiceTest() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        importinvoiceManager = (ImportinvoiceManager) ctx.getBean("importinvoiceManager");
	        warehouseManager = (WarehouseManager)ctx.getBean("warehouseManager");
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	        importinvoiceManager = null;
	        receiptManager = null;
	    }

	 
	  
	    public void testImportinvoiceTax()
	    {
	    	Importinvoice di = new Importinvoice();
	    
	    	DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");	
	    	Date d = new Date();
	    	Date d1 = new Date();
	    	Date d2 = new Date();
	    	
			try
			{
				d = sdf.parse( "06/01/2011 12:00:00" ) ;				
				d1 = sdf.parse( "06/11/2011 12:00:00" ) ;				
				d2 = sdf.parse( "06/07/2010 12:00:00" ) ;
			}
			catch (Exception e) {
				// TODO: handle exception
			}

			di.setTax("Y");
			di.setDate(d2);
			
			di.setWarehouse(warehouseManager.getWarehouse(1));
			
	    	importinvoiceManager.addImportinvoice(di);
	    	
	    	ArrayList<Importinvoice> dis1 = (ArrayList<Importinvoice>)importinvoiceManager.getImportinvoiceByMonthWithTax("1", "2011", "", warehouseManager.getWarehouse(1));
	    	ArrayList<Importinvoice> dis2 = (ArrayList<Importinvoice>)importinvoiceManager.getImportinvoiceByMonthWithTax("11", "2011", "Y", warehouseManager.getWarehouse(1));
	    	ArrayList<Importinvoice> dis3 = (ArrayList<Importinvoice>)importinvoiceManager.getImportinvoiceByMonthWithTax("7", "2010", "Y", warehouseManager.getWarehouse(2));
	    	
	    	System.out.println("all="+dis1);
	    	
	    	System.out.println("y="+dis2);
	    	
	    	System.out.println("n="+dis3);
			
			
	    }
	    


	}
