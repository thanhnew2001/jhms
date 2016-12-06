package com.ph.hms.hibernate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ph.hms.manager.HMSDataManager;

public class HibernateHMSDataManager extends HibernateDaoSupport implements HMSDataManager {

	public ResultSet getResultset(String sql) {
		
		
		Session session = getSession();

		
		try
		{
		Connection con = session.connection();
		
		 Statement stmt = con.createStatement(
	             ResultSet.TYPE_SCROLL_INSENSITIVE,
	             ResultSet.CONCUR_UPDATABLE);
		 ResultSet rs = stmt.executeQuery(sql);
		
		return rs;
		}
		catch(Exception e)
		{
			System.out.println("Loi khi lay resultset ");
			e.printStackTrace();
			return null;
		}
	}

}
