package com.ph.hms.cardmanagement.hibernate;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ph.hms.Encounter;
import com.ph.hms.Service;
import com.ph.hms.Servicegroup;
import com.ph.hms.cardmanagement.Card;
import com.ph.hms.cardmanagement.CardManager;
import com.ph.hms.cardmanagement.CardType;
import com.ph.hms.cardmanagement.Privilege;
import com.ph.hms.cardmanagement.PrivilegeDetail;


public class HibernateCardManager extends HibernateDaoSupport implements CardManager {

	
	//card 
	public void updateCard(Card card) {
		getHibernateTemplate().saveOrUpdate(card);
		
	}
	
	public void addCard(Card card) {
		getHibernateTemplate().saveOrUpdate(card);		
	}

	public Collection<Card> searchCards(String con, int pageSize, int page) {
		return getHibernateTemplate().find("from Card as card where code like '%"+con+"%'");
	}
	
	public void addPrivilege(Privilege privilege) {
		getHibernateTemplate().saveOrUpdate(privilege);		
	}

	public void deleteCard(int id) {
		getHibernateTemplate().delete(getHibernateTemplate().get(Card.class, id));
		
	}

	public Card getCard(int id) {
		return (Card)getHibernateTemplate().get(Card.class, id);
	}

	
	public Card getCardByCode(String con, int pageSize, int page) {
		java.util.List<Card> cards = getHibernateTemplate().find("from Card as card where code='"+con+"'");
		if(cards.size()>0) return (Card)cards.get(0);
		else return null;
	}

	public Collection<Encounter> getEncountersByCard(Card card) {
		return getHibernateTemplate().find("from Encounter as encounter where encounter.card.id="+card.getId());
		
	}
	
	///////////////////////////////card type
	public void addCardType(CardType cardType) {
		getHibernateTemplate().saveOrUpdate(cardType);
		
	}
	public void deleteCardType(int id) {
		getHibernateTemplate().delete(getHibernateTemplate().get(CardType.class, id));
		
	}
	public CardType getCardType(int id) {
		return (CardType)getHibernateTemplate().get(CardType.class, id);
	}	

	public Collection<CardType> searchCardTypes(String con, int pageSize,
			int page) {
		return getHibernateTemplate().find("from CardType as cardtype where code like '%"+con+"%'");
	}

	public Collection<CardType> getAllCardTypes() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from CardType");
	}

	public void updateCardType(CardType cardType) {
		getHibernateTemplate().saveOrUpdate(cardType);		
	}

	////////////////////////////////privilege////////////////////////////////

	public void deletePrivilege(int id) {
		getHibernateTemplate().delete(getHibernateTemplate().get(Privilege.class, id));
		
	}

	public void updatePrivilege(Privilege privilege) {
		getHibernateTemplate().saveOrUpdate(privilege);		
	}

	public Privilege getPrivilege(int id) {
		return (Privilege)getHibernateTemplate().get(Privilege.class, id);
	}


	
	///////////////////////////////privilege details

	public void addPrivilegeDetail(PrivilegeDetail privilegeDetail) {
		getHibernateTemplate().save(privilegeDetail);		
	}

	public void deletePrivilegeDetail(int id) {		
		getHibernateTemplate().delete(getHibernateTemplate().get(PrivilegeDetail.class, id));		
	}

	public PrivilegeDetail getPrivilegeDetail(int id) {
		return (PrivilegeDetail)getHibernateTemplate().get(PrivilegeDetail.class, id);
	}

	public void updatePrivilegeDetail(PrivilegeDetail privilegeDetail) {
		Session session = getSession();
		try {
			session.saveOrUpdate(privilegeDetail);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Collection<PrivilegeDetail> getAllPrivilegeDetailsByService(Service service,
			int pageSize, int page) 
	{
		return getHibernateTemplate().find("from PrivilegeDetail as pd inner join pd.service as service where service.id = "+service.getId());
			
	}

	public Collection<PrivilegeDetail> getAllPrivilegeDetailsByServiceGroup(
			Servicegroup serviceGroup, int pageSize, int page) 
	{
		return getHibernateTemplate().find("select privilegeDetail from PrivilegeDetail as pd inner join pd.serviceGroup as serviceGroup where serviceGroup.id="+serviceGroup.getId());
		
	}

	

	
	
}
