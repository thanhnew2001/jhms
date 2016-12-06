
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

import com.ph.hms.User;
import com.ph.hms.manager.UserManager;


public class HibernateUserManager extends HibernateDaoSupport implements UserManager
{
public void addUser( User user )
{
getHibernateTemplate().saveOrUpdate( user );

	Session session = getSession();


	try{
		session.saveOrUpdate(user);
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}

}

public void updateUser( User user )
{
	Session session = getSession();


	try{
		session.saveOrUpdate(user);
		session.flush();
		session.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
}


public void deleteUser( int id )
{

Object user = getHibernateTemplate().get( User.class, Integer.valueOf(id) );
getHibernateTemplate().delete( user );
}

public User getUser( int id )
{
	Session session = getSession();

	
	User user = new User();
	
	try
	{
		user = (User)session.get(User.class, Integer.valueOf(id));
		session.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	
	return user;
}

public Collection<User> getAllUsers()
{
	Session session = getSession();

	
	Collection<User> users = new ArrayList<User>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(User.class);
		
		//criteria.setMaxResults(50); 
		
		criteria.addOrder(Order.desc("id"));
		
		users = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return users;

}

public Collection<User> filter(String typehead)
{
	Session session = getSession();

	
	Collection<User> users = new ArrayList<User>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(User.class);
		
		criteria.add(Expression.like("node", typehead + "%"));
		//criteria.setMaxResults(50); 
		
		criteria.addOrder(Order.desc("id"));
		
		users = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return users;
}

public Collection<User> filterAll(String typehead)
{
	return getHibernateTemplate().find( "from User c where c.password like ? or c.node like ? or c.position like ? or c.fullname like ? or c.phone like ? or c.cellphone like ? or c.email like ?  order by id desc ",    new Object[]{ typehead, typehead, typehead, typehead, typehead, typehead, typehead });
}

public Collection<User> filterByCon(String con, String typehead)
{
	Session session = getSession();

	
	Collection<User> users = new ArrayList<User>();
	
	try
	{
		
		Criteria criteria =  session.createCriteria(User.class);
		
		criteria.add(Expression.like(con, typehead));
		//criteria.setMaxResults(50); 
		
		criteria.addOrder(Order.desc("id"));
		
		users = criteria.list();
		
		session.close();
		 
	}
	catch(Exception e)
	{
		e.printStackTrace();		
	}
	return users;
}


public String genCode(String formula)
{

	List l = getHibernateTemplate().find("select max(c.id) from User c");
	
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
	
;
	
	

public User getUserByUsernameAndPassword(String username, String password)
{
	
	List users = getHibernateTemplate().find("from User c where c.node = ? and c.password = ?", new Object[]{username, password});
	
	if (users.size()>0) return (User)users.get(0);
	else return null;
}

}
