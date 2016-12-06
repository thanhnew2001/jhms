
package com.ph.hms.hibernate;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ph.hms.*;
import com.ph.hms.manager.ClientManager;

public class HibernateClientManager extends HibernateDaoSupport implements ClientManager
{
public void addClient( Client client )
{

	Session session = getSession();

	try{
		session.saveOrUpdate(client);
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}

}

public void updateClient( Client client )
{
	Session session = getSession();


	try{
		session.saveOrUpdate(client);
		session.flush();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
}


public void deleteClient( int id )
{

Object client = getHibernateTemplate().get( Client.class, Integer.valueOf(id) );
getHibernateTemplate().delete( client );
}

public Client getClient( int id )
{
	Session session = getSession();

	
	Client client = new Client();
	
	try
	{
		client = (Client)session.get(Client.class, Integer.valueOf(id));
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	return client;
}

public Collection<Client> getAllClients()
{
	Session session = getSession();

	
	Collection<Client> clients = new ArrayList<Client>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Client.class);
		
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		criteria.addOrder(Order.desc("id"));
		
		clients = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return clients;

}

public Collection<Client> filter(String typehead)
{
	Session session = getSession();

	
	Collection<Client> clients = new ArrayList<Client>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Client.class);
		
		criteria.add(Expression.like("node", typehead + "%"));
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		criteria.addOrder(Order.desc("id"));
		
		clients = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return clients;
}

public Collection<Client> filterAll(String typehead)
{
	return getHibernateTemplate().find( "from Client c where c.paymenttype like ? or c.maritalstatus like ? or c.age like ? or c.birthday like ? or c.sex like ? or c.node like ? or c.createddate like ? or c.code like ? or c.insurancenumber like ? or c.expireddate like ? or c.joineddate like ? or c.oversea like ? or c.address like ? or c.ward like ? or c.motherfather like ? or c.ethnic like ? or c.occupation like ? or c.password like ? or c.education like ? or c.company like ? or c.phone like ?  order by id desc ",    new Object[]{ typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead, typehead });
}

public Collection<Client> filterByCon(String con, String typehead)
{
	Session session = getSession();

	
	Collection<Client> clients = new ArrayList<Client>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Client.class);
		
		criteria.add(Expression.like(con, typehead));
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id")); criteria.addOrder(Order.desc("id"));
		
		clients = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return clients;
}


public String genCode(String formula)
{

	List l = getHibernateTemplate().find("select max(c.id) from Client c");
	
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
	

	
public Collection<Client> filterByCreateddate( Date createddate )
	{
	Session session = getSession();

	
	Collection<Client> clients = new ArrayList<Client>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Client.class);
		
		
		criteria.add(Expression.eq("createddate", createddate)); 
		
		criteria.addOrder(Order.desc("id"));

		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id")); criteria.addOrder(Order.desc("id"));
		
		clients = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return clients;

}

//********************Family Member***************************
public void addFamilyMember( FamilyMember familyMember )
{

	Session session = getSession();


	try{
		session.saveOrUpdate(familyMember);
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}

}

public void updateFamilyMember( FamilyMember familyMember )
{
	Session session = getSession();


	try{
		session.saveOrUpdate(familyMember);
		session.flush();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
}


public void deleteFamilyMember( int id )
{

Object familyMember = getHibernateTemplate().get( FamilyMember.class, Integer.valueOf(id) );
getHibernateTemplate().delete( familyMember );
}

public FamilyMember getFamilyMember( int id )
{
	Session session = getSession();

	
	FamilyMember familyMember = new FamilyMember();
	
	try
	{
		familyMember = (FamilyMember)session.get(FamilyMember.class, Integer.valueOf(id));
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	return familyMember;
}

public Collection<FamilyMember> getAllFamilyMembers()
{
	Session session = getSession();

	
	Collection<FamilyMember> familyMembers = new ArrayList<FamilyMember>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(FamilyMember.class);
		
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		criteria.addOrder(Order.desc("id"));
		
		familyMembers = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return familyMembers;

}


}
