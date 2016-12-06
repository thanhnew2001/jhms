package com.ph.hms.action;
import java.util.*;
import java.sql.ResultSet;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetDrugByTypeHeadAction extends ActionSupport
{
	
	private DrugManager drugManager;
	
	public DrugManager getDrugManager() {
		return drugManager;
	}

	public void setDrugManager(DrugManager drugManager) {
		this.drugManager = drugManager;
	}	
	
	private Collection<Drug> drugs;
	
	public Collection<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Collection<Drug> drugs) {
		this.drugs = drugs;
	}	
	
	private Hashtable<String, String> i18n;			
		
	public Hashtable<String, String> getI18n() {			  		   
		return i18n;
	}
		
	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}
		
	private I18nManager i18nManager;			
		
	public I18nManager getI18nManager() {
		return i18nManager;
	}
		
	public void setI18nManager(I18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}

	
	private String typehead;	

	public String getTypehead() {
		return typehead;
	}

	public void setTypehead(String typehead) {
		this.typehead = typehead;
	}
	
	private String con;	
	
	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	private int druggroup = 0;
	private HMSDataManager hmsDataManager;
	
	
	
public String execute() throws Exception
{
   try{
   	   i18n = i18nManager.geti18n();	
	   
	   if (flag!=null && flag.equalsIgnoreCase("filter")) {
			
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");					
						
				
				return SUCCESS;
		}

		if (con != null)
		{
			if (con.equalsIgnoreCase("") )
			{
				drugs = (Collection<Drug>)drugManager.filter(typehead);
			}
	
			else if (con.equalsIgnoreCase("All"))
			{
				drugs = (Collection<Drug>)drugManager.filterAll(typehead);
			}
			else
			{
				drugs = (Collection<Drug>)drugManager.filterByCon(con, typehead);
			}
		}
		else
		{
			if(druggroup != 0)
			{
				
				String q = "Select id, node, forprescription, ingredient from drug where druggroup = " + druggroup +
						" and (node like '%" + typehead + "%' " 
						+ " or ingredient like '%" + typehead + "%') ";
				
				
				
				ResultSet rs = hmsDataManager.getResultset(q);
				drugs = new ArrayList<Drug>();
				while(rs.next())
				{
					
					Drug d = new Drug();
					d.setId(rs.getInt("id"));
					d.setNode(rs.getString("node"));
					d.setForprescription(rs.getString("forprescription"));
					d.setIngredient(rs.getString("ingredient"));
					drugs.add(d);
				}
				return SUCCESS;
			}
			
			drugs = (Collection<Drug>)drugManager.filter(typehead);
			
		}

        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
      }
       
}

public int getDruggroup() {
	return druggroup;
}

public void setDruggroup(int druggroup) {
	this.druggroup = druggroup;
}

public HMSDataManager getHmsDataManager() {
	return hmsDataManager;
}

public void setHmsDataManager(HMSDataManager hmsDataManager) {
	this.hmsDataManager = hmsDataManager;
}


}
