package com.ph.hms.cardmanagement.action;

import java.util.Collection;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Service;
import com.ph.hms.ServiceManager;
import com.ph.hms.ServiceParam;
import com.ph.hms.Servicegroup;
import com.ph.hms.ServicegroupManager;
import com.ph.hms.cardmanagement.CardManager;
import com.ph.hms.cardmanagement.CardType;

public class CardTypeAction extends ActionSupport {

	//property of manager
	private CardManager cardManager;
	
	
	public CardManager getCardManager() {
		return cardManager;
	}

	public void setCardManager(CardManager cardManager) {
		this.cardManager = cardManager;
	}

	//property of a param
	private int id;
	
	private String code;
	
	private String name;
	
	private int maxPoint;		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxPoint() {
		return maxPoint;
	}

	public void setMaxPoint(int maxPoint) {
		this.maxPoint = maxPoint;
	}

	private String action;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	//object to transfer
	private CardType cardType;
			
	
	public Collection<CardType> getCardTypes() {
		return cardTypes;
	}

	//list of object to be shown
	private Collection<CardType> cardTypes;


	public CardType getCardType() {
		return cardType;
	}

	public String execute()
	{
		
		if(action==null) action = "";

		cardType = cardManager.getCardType(id);
		if (cardType==null)
			cardType = new CardType();
				
		if(action.equalsIgnoreCase("save"))
		{	
			//setting property
			cardType.setCode(code);
			cardType.setName(name);
			cardType.setMaxPoint(maxPoint);			
			
			if(id>0)
			{
				cardManager.updateCardType(cardType);				
			}
			else
			{
				cardManager.addCardType(cardType);
			}
		}
		
		if(action.equalsIgnoreCase("delete"))
		{
			cardManager.deleteCardType(id);
		}
		
		//reload a list of card type
		cardTypes = cardManager.getAllCardTypes();
		

		return SUCCESS;	}
	
}
