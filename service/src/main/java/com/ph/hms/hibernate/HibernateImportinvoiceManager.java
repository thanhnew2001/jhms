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

import com.ph.hms.Importinvoice;
import com.ph.hms.Warehouse;
import com.ph.hms.manager.ImportinvoiceManager;


public class HibernateImportinvoiceManager extends HibernateDaoSupport
		implements ImportinvoiceManager {
	public void addImportinvoice(Importinvoice importinvoice) {
		getHibernateTemplate().saveOrUpdate(importinvoice);

		Session session = getSession();

		try {
			session.saveOrUpdate(importinvoice);
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateImportinvoice(Importinvoice importinvoice) {
		Session session = getSession();

		try {
			session.saveOrUpdate(importinvoice);
			session.flush();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteImportinvoice(int id) {

		Object importinvoice = getHibernateTemplate().get(Importinvoice.class,
				Integer.valueOf(id));
		getHibernateTemplate().delete(importinvoice);
	}

	public Importinvoice getImportinvoice(int id) {
		Session session = getSession();

		Importinvoice importinvoice = new Importinvoice();

		try {
			importinvoice = (Importinvoice) session.get(Importinvoice.class,
					Integer.valueOf(id));
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return importinvoice;
	}

	public Collection<Importinvoice> getAllImportinvoices() {
		Session session = getSession();

		Collection<Importinvoice> importinvoices = new ArrayList<Importinvoice>();

		try {

			Criteria criteria = session.createCriteria(Importinvoice.class);

			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			importinvoices = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return importinvoices;

	}

	public Collection<Importinvoice> filter(String typehead) {
		Session session = getSession();

		Collection<Importinvoice> importinvoices = new ArrayList<Importinvoice>();

		try {

			Criteria criteria = session.createCriteria(Importinvoice.class);

			criteria.add(Expression.like("node", typehead + "%"));
			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			importinvoices = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return importinvoices;
	}

	public Collection<Importinvoice> filterAll(String typehead) {
		return getHibernateTemplate()
				.find(
						"from Importinvoice c where c.type like ? or c.totalaftertax like ? or c.vat like ? or c.provider like ? or c.remain like ? or c.totalexport like ? or c.fromwarehouse like ? or c.node like ? or c.user like ? or c.total like ? or c.warehouse like ? or c.code like ? or c.date like ?  order by id desc ",
						new Object[] { typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead });
	}

	public Collection<Importinvoice> filterByCon(String con, String typehead) {
		Session session = getSession();

		Collection<Importinvoice> importinvoices = new ArrayList<Importinvoice>();

		try {

			Criteria criteria = session.createCriteria(Importinvoice.class);

			criteria.add(Expression.like(con, typehead));
			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			importinvoices = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return importinvoices;
	}

	public String genCode(String formula) {

		List l = getHibernateTemplate().find(
				"select max(c.id) from Importinvoice c");

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

	public Collection<Importinvoice> filterByWarehouseDateType(
			Warehouse warehouse, Date date, String type) {
		Session session = getSession();

		Collection<Importinvoice> importinvoices = new ArrayList<Importinvoice>();

		try {

			Criteria criteria = session.createCriteria(Importinvoice.class);

			criteria.add(Expression.eq("warehouse", warehouse));

			criteria.add(Expression.eq("date", date));

			criteria.add(Expression.eq("type", type));

			criteria.setMaxResults(50);

			criteria.addOrder(Order.desc("id"));

			importinvoices = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return importinvoices;

	}

	public Collection<Importinvoice> getImportinvoiceWithTax(String tax,
			Warehouse warehouse, Date date, String type) {
		// this method get all drug invoice with and without tax
		// tax = Y or N, warehouse = null or not null, date = null or not null,
		// type = NB or HB

		Session session = getSession();

		Collection<Importinvoice> druginvoices = new ArrayList<Importinvoice>();

		try {

			Criteria criteria = session.createCriteria(Importinvoice.class);

			if (tax != null)
				criteria.add(Expression.eq("tax", tax));

			if (warehouse != null)
				criteria.add(Expression.eq("warehouse", warehouse));

			if (date != null)
				criteria.add(Expression.eq("date", date));

			if (type != null)
				criteria.add(Expression.eq("type", type));

			criteria.addOrder(Order.desc("id"));

			// criteria.setMaxResults(50);

			druginvoices = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return druginvoices;

	}

	public Collection<Importinvoice> getImportinvoiceByMonthWithTax(
			String month, String year, String tax, Warehouse warehouse) {

		// this method get all drug invoice with and without tax
		// tax = Y or N, warehouse = null or not null, date = null or not null,
		// type = NB or HB

		Session session = getSession();

		Collection<Importinvoice> importinvoices = new ArrayList<Importinvoice>();

		String q = "";

		if (tax.equalsIgnoreCase(""))
			q = "from Importinvoice d where month(date)=" + month
					+ " and year(date)=" + year;
		else
			q = "from Importinvoice d where month(date)=" + month
					+ " and year(date)=" + year + " and tax='" + tax + "'";

		if(warehouse!=null)
			q+=" and d.warehouse.id="+warehouse.getId();

		return  getHibernateTemplate().find(q);


	}

}
