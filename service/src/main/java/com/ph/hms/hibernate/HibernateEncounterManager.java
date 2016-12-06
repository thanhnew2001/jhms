package com.ph.hms.hibernate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ph.hms.Department;
import com.ph.hms.Druginvoice;
import com.ph.hms.DruginvoiceManager;
import com.ph.hms.Encounter;
import com.ph.hms.Promotion;
import com.ph.hms.Receipt;
import com.ph.hms.Room;
import com.ph.hms.Solving;
import com.ph.hms.manager.EncounterManager;
import com.ph.hms.manager.ReceiptManager;

public class HibernateEncounterManager extends HibernateDaoSupport implements
		EncounterManager 
{
	

	public void addEncounter(Encounter encounter) {
		getHibernateTemplate().saveOrUpdate(encounter);

		Session session = getSession();

		try {
			session.saveOrUpdate(encounter);
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public double getTotalPaidOfPrepaidCard(String prepaidCard) {
	
		Query query = null;
		Collection<Receipt> receipts = new HashSet<Receipt>();
		Session session = getSession();
		
		String sql = "select receipt from Receipt as receipt where receipt.prepaidCard='"+prepaidCard+"'";
				
		try 
		{
			query = session.createQuery(sql);			
			receipts = query.list();			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		Collection<Druginvoice> druginvoices = new HashSet<Druginvoice>();
		
		sql = "select druginvoice from Druginvoice as druginvoice where druginvoice.prepaidCard='"+prepaidCard+"'";
				
		try 
		{
			query = session.createQuery(sql);
			druginvoices = query.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		double spent = 0;
				
		for (Receipt receipt:receipts)
		{
			spent+= receipt.getActualpay();
		}
		
		for (Druginvoice druginvoice:druginvoices)
		{
			spent+= druginvoice.getTotalaftertax();
		}
				
		return  spent;
	
	}


	public Collection<Encounter> getEncounterByType(int encounterType) {
		
			
			Session session = getSession();
			String sql = "from Encounter e where e.encounterType = "+encounterType;
			
			Collection<Encounter> encounters = null;
			Query query = null;
			try 
			{
				query = session.createQuery(sql);				
				query.setMaxResults(100);
				encounters = query.list();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}			
		
		return encounters;
	}




	public void updateEncounter(Encounter encounter) {

		getHibernateTemplate().saveOrUpdate(encounter);
	}

	public void deleteEncounter(int id) {

		Object encounter = getHibernateTemplate().get(Encounter.class,
				Integer.valueOf(id));
		getHibernateTemplate().delete(encounter);
	}

	public Encounter getEncounter(int id) {
		Session session = getSession();


		Encounter encounter = new Encounter();

		try {
			encounter = (Encounter) session.get(Encounter.class, Integer
					.valueOf(id));
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return encounter;
	}

	public Collection<Encounter> getAllEncounters(Room room) {
		Session session = getSession();


		Collection<Encounter> encounters = new HashSet<Encounter>();

		try {

			Criteria criteria = session.createCriteria(Encounter.class);

			if (room != null) {
				criteria.add(Expression.eq("room", room));
			}

			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			encounters = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return encounters;

	}

	public Collection<Encounter> filter(String typehead, Room room) {
		Session session = getSession();
		
		Collection<Encounter> encounters = new HashSet<Encounter>();

		try {

			Criteria criteria = session.createCriteria(Encounter.class);

			criteria.add(Expression.like("node", typehead + "%"));
			//criteria.add(Expression.or(Expression.like("node", typehead + "%"), Expression.like("client.code", typehead + "%")));
	
			if (room != null)
				criteria.add(Expression.eq("room", room));

			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			encounters = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return encounters;
	}

	public Collection<Encounter> filterAll(String typehead) {
		return getHibernateTemplate()
				.find(
						"from Encounter c where c.client like ? or c.date like ? or c.node like ? or c.initialdiagnosis like ? or c.icd like ? or c.solving like ? or c.hospital like ? or c.prescriptiontemplate like ? or c.code like ? or c.room like ? or c.advise like ? or c.revisit like ? or c.revisitdate like ? or c.paid like ? or c.user like ? or c.insurancenumber like ? or c.joineddate like ? or c.expireddate like ? or c.totalamount like ? or c.insurancepay like ? or c.paidamount like ? or c.leftamount like ? or c.time like ? or c.reference like ? or c.client.code like ? order by id desc ",
						new Object[] { typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead,
								typehead, typehead, typehead, typehead, typehead });
	}

	public Collection<Encounter> filterByCon(String con, String typehead,
			Room room) {
		Session session = getSession();


		Collection<Encounter> encounters = new HashSet<Encounter>();

		try {

			Criteria criteria = session.createCriteria(Encounter.class);

			criteria.add(Expression.like(con, typehead));

			if (room != null)
				criteria.add(Expression.eq("room", room));

			criteria.setMaxResults(50);
			criteria.addOrder(Order.desc("id"));

			encounters = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return encounters;
	}

	public String genCode(String formula) {

		List l = getHibernateTemplate().find(
				"select max(c.id) from Encounter c");

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

	public Collection<Encounter> filterByDateSolving(Date date,
			Solving solving, Room room) {
		Session session = getSession();


		Collection<Encounter> encounters = new HashSet<Encounter>();

		try {

			Criteria criteria = session.createCriteria(Encounter.class);

			criteria.add(Expression.eq("date", date));

			if (solving != null)	criteria.add(Expression.eq("solving", solving));

			if (room != null)		criteria.add(Expression.eq("room", room));

			//criteria.setMaxResults(50);
			criteria.addOrder(Order.asc("time"));

			encounters = criteria.list();

			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return encounters;

	}

	
	public void addPromotion(Promotion promotion) {
		getHibernateTemplate().saveOrUpdate(promotion);
		
	}

	
	public void deletePromotion(int id) {
		getHibernateTemplate().delete(getPromotion(id));
		
	}

	
	public Collection<Promotion> getAllPromotions(Room room) {
		return getHibernateTemplate().find("from Promotion");
		
	}

	
	public Promotion getPromotion(int id) {
		return (Promotion)getHibernateTemplate().get(Promotion.class, id);
	}

	
	public Promotion getPromotion(String node) {
		
		Session session = getSession();


		List<Promotion> promotions = new ArrayList<Promotion>();

		try {

			Criteria criteria = session.createCriteria(Promotion.class);

			if (node != null) {
				criteria.add(Expression.eq("node", node));
			}

			promotions = criteria.list();

			session.close();
			
			System.out.println(promotions);
			
			if (promotions.size()>0) {
				Promotion p = (Promotion) promotions.get(0);
				if (p!= null) {
					return p;
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}


		return null;
	 
	}

	
	public void updatePromotion(Promotion promotion) {
		getHibernateTemplate().saveOrUpdate(promotion);
		
	}

	public boolean isUsed(String promotionCode) {
		Session session = getSession();


		Set<Encounter> encounters = new HashSet<Encounter>();

		try {

			Criteria criteria = session.createCriteria(Encounter.class);

			if (promotionCode != null) {
				criteria.add(Expression.eq("promotionCode", promotionCode));
			}
			
			encounters = (HashSet<Encounter>)criteria.list();
			
			System.out.println(encounters);

			session.close();
			
			if (encounters.size() < 2) //not used before
				return false;
			else
				return true;

		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		
	 
	}
	
	public Collection<Encounter> getEncountersByPromotionCode(String promotionCode)
	{
		Session session = getSession();


		Collection<Encounter>encounters = new HashSet<Encounter>();

		try {

			Criteria criteria = session.createCriteria(Encounter.class);

			if (promotionCode != null) {
				criteria.add(Expression.eq("promotionCode", promotionCode));
			}
			
			encounters = (HashSet<Encounter>)criteria.list();
			
			System.out.println(encounters);

			session.close();
		
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return encounters;
	}

	public Collection<Encounter> searchEncounterForIndicationdetail(String clientCode, String clientName, String misc) 
	{
		Session session = getSession();
		
		Query query = null;
		Collection<Encounter> encounters = new HashSet<Encounter>();
		
		String sql = "select distinct encounter from Encounter as encounter left join encounter.client as client" +
				" inner join encounter.indicationdetails as indicationdetail " +
				" where indicationdetail.paid in ('Y')";
			
		if (clientCode!=null)
		{
			if(!(clientCode.equals("")))
			{
			sql += " and (encounter.client.code like '%"+clientCode+"%'";
			sql += " or encounter.code like '%"+clientCode+"%')";
			}
		}
		
		if (clientName!=null)
		{
			if(!(clientName.equals("")))
			{
			sql += " and encounter.client.node like '%"+clientName+"%'";
			
			}
		}		
		
		if (misc!=null)
		{
			if(!(misc.equals("")))
			{
			sql += " and (encounter.client.phone like '%"+misc+"%'";
			sql += " or encounter.client.email like '%"+misc+"%')";
			}
		}
		System.out.println(sql);

		try 
		{
			query = session.createQuery(sql);
			query.setMaxResults(100);
			encounters = query.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		return encounters;		
		
		
	}
	
	public Collection<Encounter> searchEncounterForIndicationdetail(String con, Date d) {
		
		Session session = getSession();
		
		Query query = null;
		Collection<Encounter> encounters = new HashSet<Encounter>();
		
		String sql = "select distinct encounter from Encounter as encounter left join encounter.client as client" +
				" inner join encounter.indicationdetails as indicationdetail " +
				" where indicationdetail.paid in ('N')";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if(d!=null)
		{
			sql += " and (encounter.date = '"+df.format(d).toString()+"')";
			
		}
		else
		{
			if (con!=null)
			{
				if(!(con.equals("")))
				{
				sql += " and (encounter.code like '%"+con+"%'" +
						" or encounter.client.code like '%"+con+"%'" +
						" or encounter.client.node like '%"+con+"%'" +
						" or encounter.client.email like '%"+con+"%'" +
						" or encounter.client.phone like '%"+con+"%'" +
								")";
				}
			}
		}
		System.out.println(sql);

		try 
		{
			query = session.createQuery(sql);
			query.setMaxResults(100);
			encounters = query.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		return encounters;	
	}
	

	public Collection<Encounter> searchEncounterForDrug(String con, Date d) {
		Session session = getSession();
		
		Query query = null;
		Collection<Encounter> encounters = new HashSet<Encounter>();
		
		String sql = "select distinct encounter from Encounter as encounter left join encounter.client as client" +
				" where encounter not in (select druginvoice.encounter from Druginvoice as druginvoice where druginvoice.encounter is not null)";
		
			
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if(d!=null)
		{
			sql += " and (encounter.date = '"+df.format(d).toString()+"')";
			
		}
		else
		{
		
			if (con!=null)
			{
				if(!(con.equals("")))
				{
				sql += " and (encounter.code like '%"+con+"%'" +
						" or encounter.client.code like '%"+con+"%'" +
						" or encounter.client.node like '%"+con+"%'" +
						" or encounter.client.email like '%"+con+"%'" +
						" or encounter.client.phone like '%"+con+"%'" +
								")";
				}
				
			}
		}
		
		try 
		{
			query = session.createQuery(sql);
			query.setMaxResults(100);
		
			Collection<Encounter> tmpEncounters = query.list(); 
			
			for(Encounter encounter:tmpEncounters)
			{
				if(encounter.getPrescriptiondetails()!=null)
				{
					if(encounter.getPrescriptiondetails().size() > 0)
					{
						encounters.add(encounter);
									
					}
				}
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		return encounters;	
	}

	public Collection<Encounter> getEncounterByClientId(int id) {
		Query query = null;
		Collection<Encounter> encounters = new HashSet<Encounter>();
		Session session = getSession();
		
		String sql = "select encounter from Encounter as encounter inner join encounter.client as client " +
				" where client.id = "+id;
		try 
		{
			query = session.createQuery(sql);
			query.setMaxResults(100);
			encounters = query.list();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		
		return encounters;	
	}

	
	public Collection<Encounter> searchEncounterForIndicationdetail(Department department, Date d, String status, String con)
	{
		
		Session session = getSession();
		
		Query query = null;
		
		String sql = "select distinct encounter from Encounter as encounter left join encounter.client as client" +
				" inner join encounter.indicationdetails as indicationdetail inner join indicationdetail.service as service " +
				" where 1=1";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if(d!=null)
		{
			sql += " and (encounter.date = '"+df.format(d).toString()+"')";
			
		}
		if (con!=null)
		{
				if(!(con.equals("")))
				{
				sql += " and (encounter.code like '%"+con+"%'" +
						" or encounter.client.code like '%"+con+"%'" +
						" or encounter.client.node like '%"+con+"%'" +
						" or encounter.client.email like '%"+con+"%'" +
						" or encounter.client.phone like '%"+con+"%'" +
								")";
				}
		}
		
		if(department!=null)
		{
			sql += " and (service.department.id = "+department.getId()+")";			
		}
		
		if(status!=null)
		{
			if(!status.equals(""))
				sql += " and (indicationdetail.status = '"+status+"')";			
		}
		
		//System.out.println(sql);
		
		try 
		{
			query = session.createQuery(sql);
			return  query.list();
		} 
		catch (Exception e) 		
		{
			e.printStackTrace();
		}

		return null;
}
	
	
public Collection<Encounter> searchEncounterForEncounter(Room room, Date d, Solving solving, String con)
{
		
		Session session = getSession();
		
		Query query = null;
		
		String sql = "select distinct encounter from Encounter as encounter left join encounter.client as client" +
					" where 1=1";
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if(d!=null)
		{
			sql += " and (encounter.date = '"+df.format(d).toString()+"')";
			
		}
		if (con!=null)
		{
				if(!(con.equals("")))
				{
				sql += " and (encounter.code like '%"+con+"%'" +
						" or encounter.client.code like '%"+con+"%'" +
						" or encounter.client.node like '%"+con+"%'" +
						" or encounter.client.email like '%"+con+"%'" +
						" or encounter.client.phone like '%"+con+"%'" +
								")";
				}
		}
		
		if(room!=null)
		{
			sql += " and (encounter.room.id = "+room.getId()+")";			
		}
		
		if(solving!=null)
		{
				sql += " and (encounter.solving.id = '"+solving.getId()+"')";			
		}
		
		//System.out.println(sql);		
		try 
		{
			query = session.createQuery(sql);
			return  query.list();
		} 
		catch (Exception e) 		
		{
			e.printStackTrace();
		}

		return null;
}
	
}

	

