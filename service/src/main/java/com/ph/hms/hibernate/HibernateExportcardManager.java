
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

import com.ph.hms.Exportcard;
import com.ph.hms.Warehouse;
import com.ph.hms.manager.ExportcardManager;


public class HibernateExportcardManager extends HibernateDaoSupport implements ExportcardManager
{
public void addExportcard( Exportcard exportcard )
{
getHibernateTemplate().saveOrUpdate( exportcard );

	Session session = getSession();


	try{
		session.saveOrUpdate(exportcard);
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}

}

public void updateExportcard( Exportcard exportcard )
{
	Session session = getSession();


	try{
		session.saveOrUpdate(exportcard);
		session.flush();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
}


public void deleteExportcard( int id )
{

Object exportcard = getHibernateTemplate().get( Exportcard.class, Integer.valueOf(id) );
getHibernateTemplate().delete( exportcard );
}

public Exportcard getExportcard( int id )
{
	Session session = getSession();

	
	Exportcard exportcard = new Exportcard();
	
	try
	{
		exportcard = (Exportcard)session.get(Exportcard.class, Integer.valueOf(id));
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	return exportcard;
}

public Collection<Exportcard> getAllExportcards()
{
	Session session = getSession();

	
	Collection<Exportcard> exportcards = new ArrayList<Exportcard>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Exportcard.class);
		
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		exportcards = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return exportcards;

}

public Collection<Exportcard> filter(String typehead)
{
	Session session = getSession();

	
	Collection<Exportcard> exportcards = new ArrayList<Exportcard>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Exportcard.class);
		
		criteria.add(Expression.like("node", typehead + "%"));
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		exportcards = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return exportcards;
}

public Collection<Exportcard> filterAll(String typehead)
{
	return getHibernateTemplate().find( "from Exportcard c where c.date like ? or c.user like ? or c.warehouse like ? or c.node like ? or c.code like ? or c.towarehouse like ?  order by id desc ",    new Object[]{ typehead, typehead, typehead, typehead, typehead, typehead });
}

public Collection<Exportcard> filterByCon(String con, String typehead)
{
	Session session = getSession();

	
	Collection<Exportcard> exportcards = new ArrayList<Exportcard>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Exportcard.class);
		
		criteria.add(Expression.like(con, typehead));
		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		exportcards = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return exportcards;
}


public String genCode(String formula)
{

	List l = getHibernateTemplate().find("select max(c.id) from Exportcard c");
	
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
	

	
public Collection<Exportcard> filterByDateWarehouse( Date date, Warehouse warehouse )
	{
	Session session = getSession();

	
	Collection<Exportcard> exportcards = new ArrayList<Exportcard>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(Exportcard.class);
		
		
		criteria.add(Expression.eq("date", date)); 
	
	
		criteria.add(Expression.eq("warehouse", warehouse)); 
	
	;		
		
		criteria.addOrder(Order.desc("id"));

		criteria.setMaxResults(50); criteria.addOrder(Order.desc("id"));
		
		exportcards = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return exportcards;

}
	
	;
	
	

}
