package com.ph.hms.smarthealth.hibernate;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ph.hms.smarthealth.GenericDao;

public  class HibernateGenericDao<T> extends HibernateDaoSupport
    implements GenericDao<T>
{
   
    private Class<T> clazz;

    /**
     * Could be overridden programmatically.
     */
    protected Class<T> getClazz()
    {
        return clazz;
    }

    /**
     * Could be injected through container.
     */
    public void setClazz( Class<T> clazz )
    {
        this.clazz = clazz;
    }
    
    // -------------------------------------------------------------------------
    // Convenience methods
    // -------------------------------------------------------------------------

    /**
     * Creates a Query.
     * 
     * @param hql the hql query.
     * @return a Query instance.
     * @throws IllegalStateException 
     * @throws HibernateException 
     * @throws DataAccessResourceFailureException 
     */
    protected final Query getQuery( String hql ) throws DataAccessResourceFailureException, HibernateException, IllegalStateException
    {
        return getSession().createQuery( hql );
    }
    
    /**
     * Creates a Critera for the implementation Class type.
     * 
     * @return a Criteria instance.
     */
    protected final Criteria getCriteria(Class clazz)
    {
        return getSession().createCriteria( clazz );
    }
    
    /**
     * Creates a Criteria for the implementation Class type restricted by the
     * given Criterions.
     * 
     * @param expressions the Criterions for the Criteria.
     * @return a Criteria instance.
     */
    protected final Criteria getCriteria( Criterion... expressions )
    {
        Criteria criteria = getSession().createCriteria( getClazz() );
        
        for ( Criterion expression : expressions )
        {
            criteria.add( expression );
        }
        
        return criteria;
    }
    
    /**
     * Retrieves an object based on the given Criterions.
     * 
     * @param expressions the Criterions for the Criteria.
     * @return an object of the implementation Class type.
     * @throws HibernateException 
     */
    @SuppressWarnings( "unchecked" )
    protected final T getObject( Criterion... expressions ) throws HibernateException
    {
		return (T) getCriteria( expressions ).uniqueResult();
	
    }
    
    /**
     * Retrieves a List based on the given Criterions.
     * 
     * @param expressions the Criterions for the Criteria.
     * @return a List with objects of the implementation Class type.
     * @throws HibernateException 
     */
    @SuppressWarnings( "unchecked" )
    protected final List<T> getList( Criterion... expressions ) throws HibernateException
    {
        return getCriteria(expressions).list();
    }

    // -------------------------------------------------------------------------
    // GenericDao implementation
    // -------------------------------------------------------------------------

    public final int save( T object )
    {
        try {
			return (Integer) getSession().save( object );
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
    }
    
    public final void update( T object )
    {
        getHibernateTemplate().update( object );
    }
    
    public final void saveOrUpdate( T object )
    {
    	getHibernateTemplate().saveOrUpdate( object );
    }
    
    @SuppressWarnings( "unchecked" )
    public final T get(Class claz, int id )
    {
        return (T) getHibernateTemplate().get( claz, id );
    }

    @SuppressWarnings( "unchecked" )
    public final T load( Class claz, int id )
    {
        return (T) getHibernateTemplate().load( claz, id );
    }
    
    @SuppressWarnings( "unchecked" )
    public final Collection<T> getAll(Class claz)
    {
        try {
			return getCriteria(claz).list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    public final void delete( T object )
    {
        getHibernateTemplate().delete( object );
    }

	public Collection<T> search(Class claz, String col, String con, int pageSize, int page) {
		String sql ="from "+claz.getName() + " where "+col+" like '%"+con+"%'";
		
		try {
			return getSession().createQuery(sql).setFirstResult(pageSize*(page-1)).setMaxResults(pageSize).list();
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
    
	
    
}
