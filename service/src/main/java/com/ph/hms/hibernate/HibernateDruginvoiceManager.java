
package com.ph.hms.hibernate;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ph.hms.Druginvoice;
import com.ph.hms.DruginvoiceManager;
import com.ph.hms.Warehouse;
import com.ph.hms.manager.HMSDataManager;

public class HibernateDruginvoiceManager extends HibernateDaoSupport implements DruginvoiceManager
{
	
	public Collection<Druginvoice> getDruginvoiceByPrepaidCard(String prepaidCard) 
	{
		Query query = null;
		Collection<Druginvoice> druginvoices = new HashSet<Druginvoice>();
		Session session = getSession();
		
		String sql = "select druginvoice from Druginvoice as druginvoice where druginvoice.prepaidCard='"+prepaidCard+"'";
				
		try 
		{
			query = session.createQuery(sql);
			query.setMaxResults(100);
			druginvoices = query.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		return druginvoices;
	}

	
public void addDruginvoice( Druginvoice druginvoice )
{

	Session session = getSession();


	try{
		session.beginTransaction();
		session.saveOrUpdate(druginvoice);
		session.beginTransaction().commit();
		session.flush();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}

}

public void updateDruginvoice( Druginvoice druginvoice )
{
	Session session = getSession();


	try{
		session.beginTransaction();
		session.saveOrUpdate(druginvoice);
		session.beginTransaction().commit();
		
		session.flush();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
}


public void deleteDruginvoice( int id )
{

Object druginvoice = getHibernateTemplate().get( Druginvoice.class, Integer.valueOf(id) );
getHibernateTemplate().delete( druginvoice );
}

public Druginvoice getDruginvoice( int id )
{
	Session session = getSession();

	
	Druginvoice druginvoice = new Druginvoice();
	
	try
	{
		druginvoice = (Druginvoice)session.get(Druginvoice.class, Integer.valueOf(id));
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	return druginvoice;
}

public Collection<Druginvoice> getAllDruginvoices()
{
	Session session = getSession();

	
	Collection<Druginvoice> druginvoices = new ArrayList<Druginvoice>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Druginvoice.class);
				
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		druginvoices = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return druginvoices;

}

public Collection<Druginvoice> filter(String typehead)
{
	Session session = getSession();

	
	Collection<Druginvoice> druginvoices = new ArrayList<Druginvoice>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Druginvoice.class);
		
		criteria.add(Expression.like("node", typehead + "%"));
				
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		druginvoices = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return druginvoices;
}

public Collection<Druginvoice> filterAll(String typehead)
{
	return getHibernateTemplate().find( "from Druginvoice c where c.node like ? or c.totalaftertax like ? or c.vat like ? or c.warehouse like ? or c.identity like ? or c.date like ? or c.user like ? or c.paymenttype like ? or c.total like ? or c.insurancenumber like ? or c.expireddate like ? or c.inpatient like ? or c.code like ? or c.doctor like ? or c.address like ? or c.encounter like ? or c.type like ? or c.towarehouse like ? order by id desc ",    new Object[]{ typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead });
	
	
	/*Collection<Druginvoice> druginvoices = new ArrayList<Druginvoice>();
	Session session = getSession();

	try
	{
		Statement stm =  session.connection().createStatement();
		String sql = "select d.id from druginvoice d where client in " +
				"(select id from client c where c.code like '%"+typehead+"%' or c.node like '%"+typehead+"%' )" +
				" or provider in " +
				"(select id from provider p where p.address like '%"+typehead+"%' or p.phone like '%"+typehead+"%') ";
				 
		System.out.println(sql);
		
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next())
		{			
			druginvoices.add(getDruginvoice(rs.getInt("id")));
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return druginvoices;
*/	
}

public Collection<Druginvoice> filterByCon(String con, String typehead)
{
	Session session = getSession();

	
	Collection<Druginvoice> druginvoices = new ArrayList<Druginvoice>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Druginvoice.class);
		
		criteria.add(Expression.like(con, typehead));
		
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		druginvoices = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return druginvoices;
}


public String genCode(String formula)
{

	List l = getHibernateTemplate().find("select max(c.id) from Druginvoice c");
	
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
	

	
public Collection<Druginvoice> filterByWarehouseDateType( Warehouse warehouse, Date date, String type )
	{
	Session session = getSession();

	
	Collection<Druginvoice> druginvoices = new ArrayList<Druginvoice>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Druginvoice.class);
		
		
		criteria.add(Expression.eq("warehouse", warehouse)); 
	
	
		criteria.add(Expression.eq("date", date)); 
	
	
		criteria.add(Expression.eq("type", type)); 

		criteria.addOrder(Order.desc("id"));

		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		druginvoices = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return druginvoices;

}

private HMSDataManager hmsDataManager;



public  HMSDataManager getHmsDataManager() {
	return hmsDataManager;
}

public  void setHmsDataManager(HMSDataManager hmsDataManager) {
	this.hmsDataManager = hmsDataManager;
}

public Collection<Druginvoice> getNotImportedDruginvoices() 
{
	Collection<Druginvoice > druginvoices = new ArrayList<Druginvoice>();
	
	try
	{
		
		ResultSet rs = hmsDataManager.getResultset("select id from druginvoice where type='NB' and id not in (select druginvoice from importinvoice)");
		
		while (rs.next())
		{
			druginvoices.add(getDruginvoice(rs.getInt("id")));
		}
		
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	return druginvoices;	

}




public Collection<Druginvoice> getDrugInvoiceWithTax(String tax,
		Warehouse warehouse, Date date, String type) {
	
	//this method get all drug invoice with and without tax
	//tax = Y or N, warehouse = null or not null, date = null or not null, type = NB or HB
	
	Session session = getSession();

	
	Collection<Druginvoice> druginvoices = new ArrayList<Druginvoice>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Druginvoice.class);
		
		if(tax!=null)
			criteria.add(Expression.eq("tax", tax)); 		
		
		if(warehouse!=null)
		criteria.add(Expression.eq("warehouse", warehouse)); 
	
		if(date!=null)
		criteria.add(Expression.eq("date", date)); 
	
		if(type!=null)
		criteria.add(Expression.eq("type", type)); 

		criteria.addOrder(Order.desc("id"));

		//criteria.setMaxResults(50); 
		
		druginvoices = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return druginvoices;

}

public Collection<Druginvoice> getDrugInvoiceByMonthWithTax(String month, String year, String tax, Warehouse warehouse) {
	
	//this method get all drug invoice with and without tax
	//tax = Y or N, warehouse = null or not null, date = null or not null, type = NB or HB
	
	String q = "";
	
	if (tax.equalsIgnoreCase(""))
		q= "from Druginvoice d where month(date)="+month+" and year(date)="+year;
	else
		q= "from Druginvoice d where month(date)="+month+" and year(date)="+year+" and tax='"+tax+"'";
	
	if(warehouse!=null)
		q+=" and d.warehouse.id="+warehouse.getId();
		
	
	return  getHibernateTemplate().find(q);		
				

}
	

}
