package com.ph.hms.test;

import java.util.List;

import junit.framework.TestCase;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import contactus.ContactUsService;
import contactus.Message;

public class ContactUsServiceIntegrationTest extends TestCase {

	public void testGetMessageAsString() throws Exception {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		factory.setServiceClass(ContactUsService.class);
		factory.setAddress("http://localhost:8080/cxf-webservices-1.0/webservices/contactus/");
		ContactUsService client = (ContactUsService) factory.create();
		
		String response = client.getMessagesAsString();
		System.out.println("Received response from webservice: " + response);
		
		assertTrue(response.contains("Wheeler"));
	}
	
	public void testGetMessage() {
		//lookup client
	 /*   ClassPathXmlApplicationContext context 
        = new ClassPathXmlApplicationContext(new String[] {"META-INF/beans.xml"});
*/
	    String[] paths = {"META-INF/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(paths);
        
	    ContactUsService client = (ContactUsService)ctx.getBean("contactUsServiceClient");
	    List<Message> messages = client.getMessages();
	    assertEquals(2, messages.size());
	    assertEquals("Willie", messages.get(0).getFirstName());
		
	}

}