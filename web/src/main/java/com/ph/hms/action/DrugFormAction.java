package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import com.opensymphony.xwork.*;
import java.text.*;

public class DrugFormAction extends ActionSupport
{	
	public String fname = "drug";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	
	
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
	private Collection<DrugGroup> drugGroups = new ArrayList<DrugGroup>();
	
	public Collection<DrugGroup> getDrugGroups() {
		return drugGroups;
	}

	public void setDrugGroups(Collection<DrugGroup> drugGroups) {
		this.drugGroups = drugGroups;
	}
	
	private Drug drug;
	
	private int id;	
		
   
	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String execute() throws Exception
    {
    
	try{
		  i18n = i18nManager.geti18n();	
		   
		   DefaultSecurity ds = new DefaultSecurity();

		   drugs = (Collection<Drug>)drugManager.getAllDrugs();
	
		   drugGroups = (Collection<DrugGroup>)drugManager.getAllDrugGroups();
			if( id == 0) {
				
				boolean matched = ds.checkRight(fname, anameAdd);

				if (matched == false) return "noprivilege";
				   
				code = drugManager.genCode("");
			
				Date d = new Date();
			
				DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
				today = sdf.format(d).toString();
				
			} else {
			
				boolean matched = ds.checkRight(fname, anameEdit);

				if (matched == false) return "noprivilege";
	
				drug = drugManager.getDrug(id);
        	
			}
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}


