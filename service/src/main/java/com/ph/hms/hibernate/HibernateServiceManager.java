
package com.ph.hms.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ph.hms.Indicationdetail;
import com.ph.hms.Service;
import com.ph.hms.ServiceParam;
import com.ph.hms.ServiceParamValue;
import com.ph.hms.manager.ServiceManager;


public class HibernateServiceManager extends HibernateDaoSupport implements ServiceManager
{
public void addService( Service service )
{
getHibernateTemplate().saveOrUpdate( service );

	Session session = getSession();


	try{
		session.saveOrUpdate(service);
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}

}

public void updateService( Service service )
{
	Session session = getSession();


	try{
		session.saveOrUpdate(service);
		session.flush();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
}


public void deleteService( int id )
{

Object service = getHibernateTemplate().get( Service.class, Integer.valueOf(id) );
getHibernateTemplate().delete( service );
}

public Service getService( int id )
{
	Session session = getSession();

	
	Service service = new Service();
	
	try
	{
		service = (Service)session.get(Service.class, Integer.valueOf(id));
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	return service;
}

public Collection<Service> getAllServices()
{
	Session session = getSession();

	
	Collection<Service> services = new ArrayList<Service>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Service.class);
		
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		services = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return services;

}

public Collection<Service> filter(String typehead)
{
	Session session = getSession();

	
	Collection<Service> services = new ArrayList<Service>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Service.class);
		
		criteria.add(Expression.like("node", typehead + "%"));
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		services = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return services;
}

public Collection<Service> filterAll(String typehead)
{
	return getHibernateTemplate().find( "from Service c where c.node like ? or c.servicegroup like ? or c.price like ? or c.insuranceprice like ? or c.department like ?  order by id desc ",    new Object[]{ typehead, typehead, typehead, typehead, typehead });
}

public Collection<Service> filterByCon(String con, String typehead)
{
	Session session = getSession();

	
	Collection<Service> services = new ArrayList<Service>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Service.class);
		
		criteria.add(Expression.like(con, typehead));
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		services = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return services;
}


public String genCode(String formula)
{

	List l = getHibernateTemplate().find("select max(c.id) from Service c");
	
	int currentCode = 0;
	
	if (l != null)
	{
		Integer i = (Integer)l.get(0);
		if (i != null)
		{
			currentCode = i.intValue();	
		}
	}
	
	currentCode++;
	
	String seq = "";
	
	if (currentCode>0 && currentCode<10)
	{
		seq = "00000" + currentCode;
	}
	else if (currentCode>=10 && currentCode<100)
	{
		seq = "0000" + currentCode;
	}
	else if (currentCode>=100 && currentCode<1000)
	{
		seq = "000" + currentCode;
	}
	else if (currentCode>=1000 && currentCode<10000)
	{
		seq = "00" + currentCode;
	}
	else if (currentCode>=10000 && currentCode<100000)
	{
		seq = "0" + currentCode;
	}
	else if (currentCode>=10000 && currentCode<100000)
	{
		seq = ""+ currentCode;
	}
	

	Date date = new Date();
	
	String year = String.valueOf(date.getYear());

	return (formula + year + seq);
}

public void addServiceParam(ServiceParam serviceParam) {
	Session session = getSession();
	try{
		session.saveOrUpdate(serviceParam);
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
}

public void deleteServiceParam(int id) {
	ServiceParam sp = (ServiceParam)getHibernateTemplate().get(ServiceParam.class, id);
	getHibernateTemplate().delete(sp);
	
}

public Collection<ServiceParam> getAllServiceParams() {
	return getHibernateTemplate().find("from ServiceParam");
}

public ServiceParam getServiceParam(int id) {
	return (ServiceParam)getHibernateTemplate().get(ServiceParam.class, id);

}

public Collection<ServiceParam> searchServiceParam(String typehead) {
	return getHibernateTemplate().find("from ServiceParam where name like = '%"+typehead+"%'");
}

public void updateServiceParam(ServiceParam serviceParam) {
	getHibernateTemplate().saveOrUpdate(serviceParam);
}


//param value
public void addServiceParamValue(ServiceParamValue serviceParamValue) {
	Session session = getSession();
	try{
		session.saveOrUpdate(serviceParamValue);
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	
}

public void deleteServiceParamValue(int id) {
	ServiceParamValue sp = (ServiceParamValue)getHibernateTemplate().get(ServiceParamValue.class, id);
	getHibernateTemplate().delete(sp);
	
}

public Collection<ServiceParam> getAllServiceParamValues() {
	return getHibernateTemplate().find("from ServiceParamValue");
}

public ServiceParamValue getServiceParamValue(int id) {
	return (ServiceParamValue)getHibernateTemplate().get(ServiceParamValue.class, id);

}


public void updateServiceParamValue(ServiceParamValue serviceParamValue) {
	getHibernateTemplate().saveOrUpdate(serviceParamValue);
	
}

public Collection<ServiceParamValue> getServiceParamValuesByIndicationdetail(
		Indicationdetail indicationdetail) {
	
	String sql = "from ServiceParamValue spv where spv.indicationdetail.id= "+indicationdetail.getId();
	return getHibernateTemplate().find(sql);
}



}
