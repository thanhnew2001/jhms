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
import com.ph.hms.smarthealth.GenericDao;
import com.unitedcoders.demo.PersonService;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;



public class TestWS extends TestCase {
	
	private ApplicationContext ctx = null;

	private PersonService personService;
	
	private GenericDao genericDao;
	
	 public TestWS() {
	        // Should put in a parent class that extends TestCase
	        String[] paths = {"META-INF/beans.xml"};
	        ctx = new ClassPathXmlApplicationContext(paths);
	        personService = (PersonService)ctx.getBean("personService");
	        
	    }

	    protected void setUp() throws Exception {
	        super.setUp();
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	    }


	    public void testSort()
	    {
	    	//personService.greetPerson("Nguyen Ngoc Thanh");
	    	//System.out.println(genericDao.getAll(Client.class));
	    	
	    }
	    
	 

	}
