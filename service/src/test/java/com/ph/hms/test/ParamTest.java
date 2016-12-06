package com.ph.hms.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.sql.rowset.serial.SerialArray;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.ph.hms.*;
import com.ph.hms.manager.IndicationdetailManager;
import com.ph.hms.manager.ReceiptManager;
import com.ph.hms.manager.ServiceManager;
public class ParamTest extends TestCase {
	
	private ApplicationContext ctx = null;

	private ServiceManager serviceManager = null;
	
	private IndicationdetailManager indicationdetailManager = null;
	
	private ReceiptManager receiptManager = null;
	
	 public ParamTest() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	        serviceManager = (ServiceManager) ctx.getBean("serviceManager");
	        indicationdetailManager = (IndicationdetailManager)ctx.getBean("indicationdetailManager");
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	        indicationdetailManager = null;
	        serviceManager = null;
	    }

	 
	  
	    public void testParam()
	    {
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

		
			Service service = new Service();
			
			service.setNode("service 1");
			serviceManager.addService(service);
			
			ServiceParam param1 = new ServiceParam();
			
			param1.setName("param1");
			param1.setMin("0");
			param1.setMax("100");
			param1.setUnit("g/l");
			param1.setService(service);
			serviceManager.addServiceParam(param1);	  
			
			
			ServiceParam param2 = new ServiceParam();
			
			param2.setName("param2");
			param2.setMin("40");
			param2.setMax("100");
			param2.setUnit("ml");
			param2.setService(service);
			
			
			serviceManager.addServiceParam(param2);	    			
	    	//System.out.println(serviceManager.getService(804).getServiceParams());
	    	
	    	Indicationdetail ind = indicationdetailManager.getIndicationdetail(2);
	    	
	    	ind.setService(serviceManager.getService(804));
	    	
	    	indicationdetailManager.updateIndicationdetail(ind);
	    	
	    	Collection<ServiceParam> serviceParams = ind.getService().getServiceParams();
	    	
	    	for(ServiceParam sp: serviceParams)
	    	{
	    		ServiceParamValue spv = new ServiceParamValue();
	    		spv.setIndicationdetail(ind);
	    		spv.setServiceParam(sp);
	    		
	    		spv.setValue("39");
	    		
	    		serviceManager.addServiceParamValue(spv);
	    		
	    	}
	    	
	    	ServiceParam sp = serviceManager.getServiceParam(1);
	    	sp.setName("new name 2");
	    	serviceManager.updateServiceParam(sp);
	    	
	    	System.out.println(serviceManager.getServiceParamValuesByIndicationdetail(ind));
	    	
	    	ServiceParamValue spv = serviceManager.getServiceParamValue(55);
	    	spv.setValue("99999");
	    	serviceManager.updateServiceParamValue(spv);
	    }
	    


	}
