package com.ph.hms.hibernate;

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

import com.ph.hms.Receipt;
import com.ph.hms.manager.ReceiptManager;


public class HibernateReceiptManager extends HibernateDaoSupport implements
		ReceiptManager {

	public Collection<Receipt> getReceiptByPrepaidCard(String prepaidCard) 
	{
		Query query = null;
		Collection<Receipt> receipts = new HashSet<Receipt>();
		Session session = getSession();
		
		String sql = "select receipt from Receipt as receipt where receipt.prepaidCard='"+prepaidCard+"'";
				
		try 
		{
			query = session.createQuery(sql);
			query.setMaxResults(100);
			receipts = query.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		return receipts;
	}

	public void addReceipt(Receipt receipt) 
	{		
		Session session = getSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(receipt);
			session.beginTransaction().commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateReceipt(Receipt receipt) {
		Session session = getSession();

		try {
			session.beginTransaction();
			session.saveOrUpdate(receipt);
			session.beginTransaction().commit();
			session.flush();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteReceipt(int id) {

		Object receipt = getHibernateTemplate().get(Receipt.class,
				Integer.valueOf(id));
		getHibernateTemplate().delete(receipt);
	}

	public Receipt getReceipt(int id) {
		Session session = getSession();

		Receipt receipt = new Receipt();

		try {
			receipt = (Receipt) session.get(Receipt.class, Integer.valueOf(id));
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return receipt;
	}

	public Collection<Receipt> getAllReceipts() {
		Session session = getSession();

		Collection<Receipt> receipts = new ArrayList<Receipt>();

		try {

			Criteria criteria = session.createCriteria(Receipt.class);

			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			receipts = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return receipts;

	}

	public Collection<Receipt> filter(String typehead) {
		Session session = getSession();

		Collection<Receipt> receipts = new ArrayList<Receipt>();

		try {

			Criteria criteria = session.createCriteria(Receipt.class);

			criteria.add(Expression.like("node", typehead + "%"));
			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			receipts = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return receipts;
	}

	public Collection<Receipt> filterAll(String typehead) {
		return getHibernateTemplate()
				.find(
						"from Receipt c where c.encounter like ? or c.code like ? or c.node like ? or c.total like ? or c.paymentmethod like ? or c.discount like ? or c.user like ? or c.date like ? or c.payfor like ? or c.actualpay like ? or c.insurancepay like ? or c.paymenttype like ? or c.birthday like ? or c.address like ? or c.age like ? or c.phone like ?  order by id desc ",
						new Object[] { typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead });
	}

	public Collection<Receipt> filterByCon(String con, String typehead) {
		Session session = getSession();

		Collection<Receipt> receipts = new ArrayList<Receipt>();

		try {

			Criteria criteria = session.createCriteria(Receipt.class);

			criteria.add(Expression.like(con, typehead));
			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			receipts = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return receipts;
	}

	public String genCode(String formula) {

		List l = getHibernateTemplate().find("select max(c.id) from Receipt c");

		int currentCode = 0;

		if (l != null) {
			Integer i = (Integer) l.get(0);
			if (i != null) {
				currentCode = i.intValue();
			}
		}

		currentCode++;

		String seq = "";

		if (currentCode > 0 && currentCode < 10) {
			seq = "00000" + currentCode;
		} else if (currentCode >= 10 && currentCode < 100) {
			seq = "0000" + currentCode;
		} else if (currentCode >= 100 && currentCode < 1000) {
			seq = "000" + currentCode;
		} else if (currentCode >= 1000 && currentCode < 10000) {
			seq = "00" + currentCode;
		} else if (currentCode >= 10000 && currentCode < 100000) {
			seq = "0" + currentCode;
		} else if (currentCode >= 10000 && currentCode < 100000) {
			seq = "" + currentCode;
		}

		Date date = new Date();

		String year = String.valueOf(date.getYear());

		return (formula + year + seq);
	}

	public Collection<Receipt> filterByDate(Date date) {
		Session session = getSession();

		Collection<Receipt> receipts = new ArrayList<Receipt>();

		try {

			Criteria criteria = session.createCriteria(Receipt.class);

			criteria.add(Expression.eq("date", date));

			criteria.addOrder(Order.desc("id"));

			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			receipts = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return receipts;

	}

	;

}
