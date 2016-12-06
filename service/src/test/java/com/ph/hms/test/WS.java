package com.ph.hms.test;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.unitedcoders.demo.PersonService;
import com.unitedcoders.demo.PersonServiceImpl;


public class WS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();


    	factory.setServiceClass(PersonServiceImpl.class);
    	factory.setAddress("http://localhost:8080/personService?wsdl");
    	
    	System.out.println(factory);
    	PersonService personService = (PersonService) factory.create();

    	//personService.greetPerson("nguyen ngoc thanh");
    	
    	
    	System.exit(0);


	}

}
