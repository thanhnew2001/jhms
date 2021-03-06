package com.ph.hms.action;

import java.util.Collection;
import java.util.Hashtable;

import org.apache.commons.lang.ObjectUtils.Null;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.BodyPart;
import com.ph.hms.Indicationdetail;
import com.ph.hms.IndicationdetailManager;
import com.ph.hms.NoiSoiTMH;
import com.ph.hms.User;
import com.ph.hms.UserManager;
import com.ph.hms.action.util.I18nManager;

public class KetQuaCLSSaveAction extends ActionSupport {

	private int id;		
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	private I18nManager i18nManager;

	public I18nManager getI18nManager() {
		return i18nManager;
	}

	public void setI18nManager(I18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}
	
	private String action;
	
	
		public String getAction() {
		return action;
	}
	
	public void setAction(String action) {
		this.action = action;
	}
	
	private String msg;
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	private IndicationdetailManager indicationdetailManager;	
	
	public IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}
	
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	private Indicationdetail indicationdetail;	
	

	public Indicationdetail getIndicationdetail() {
		return indicationdetail;
	}

	public void setIndicationdetail(Indicationdetail indicationdetail) {
		this.indicationdetail = indicationdetail;
	}
	private String file1;

	private String file2;
	
	private String file3;
	
	private String file4;
	
	private String file5;

	private String file6;
	
	private String file7;
	
	private String file8;
	
	private String note1;

	private String note2;
	
	private String note3;
	
	private String note4;
	
	private String note5;

	private String note6;
	
	private String note7;
	
	private String note8;
	
	
	
	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getNote2() {
		return note2;
	}

	public void setNote2(String note2) {
		this.note2 = note2;
	}

	public String getNote3() {
		return note3;
	}

	public void setNote3(String note3) {
		this.note3 = note3;
	}

	public String getNote4() {
		return note4;
	}

	public void setNote4(String note4) {
		this.note4 = note4;
	}

	public String getNote5() {
		return note5;
	}

	public void setNote5(String note5) {
		this.note5 = note5;
	}

	public String getNote6() {
		return note6;
	}

	public void setNote6(String note6) {
		this.note6 = note6;
	}

	public String getNote7() {
		return note7;
	}

	public void setNote7(String note7) {
		this.note7 = note7;
	}

	public String getNote8() {
		return note8;
	}

	public void setNote8(String note8) {
		this.note8 = note8;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	public String getFile4() {
		return file4;
	}

	public void setFile4(String file4) {
		this.file4 = file4;
	}

	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}
	
	private String shortResult;
	
	

	public String getShortResult() {
		return shortResult;
	}

	public void setShortResult(String shortResult) {
		this.shortResult = shortResult;
	}
	private Hashtable<String, String> i18n;

	public Hashtable<String, String> getI18n() {
		return i18n;
	}

	public void setI18n(Hashtable<String, String> i18n) {
		this.i18n = i18n;
	}
	
	private String status;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private UserManager userManager;
	
	private Collection<User> users;
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	private int user;
	
	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public String execute() throws Exception
    {		
        try{

        	i18n = i18nManager.geti18n();
        	        	
        	indicationdetail = indicationdetailManager.getIndicationdetail(id);
        	
        	if(indicationdetail==null) return ERROR;
        	
			BodyPart bodyPart = indicationdetail.getService().getBodyPart();
			
			users = userManager.getAllUsers();
			
	    	if (action!=null && action.equalsIgnoreCase("save"))
        	{
         			String description = "";
        			
         			if (!result.trim().equalsIgnoreCase("") && bodyPart.getDescription().equalsIgnoreCase(""))
            		{        			
        				String[] resulttemplate = result.split("\n");
	        			for(int i=0;i<resulttemplate.length;i++)
	        			{
	        				if (resulttemplate[i].indexOf(":")>0)
	        					description += resulttemplate[i].substring(0, resulttemplate[i].indexOf(":")+1) + "\n";
	        			}
	        			
	         			bodyPart.setDescription(description);
	         			
	        			indicationdetailManager.updateBodyPart(bodyPart);   
            		}
         			
    		
        		indicationdetail.setResult(result);
        		
        		indicationdetail.setFile1(file1);
        		
        		indicationdetail.setFile2(file2);
        		
        		indicationdetail.setFile3(file3);
        		
        		indicationdetail.setFile4(file4);
        		
        		indicationdetail.setFile5(file5);
        		
        		indicationdetail.setFile6(file6);
        		
        		indicationdetail.setFile7(file7);
        		
        		indicationdetail.setFile8(file8);
        		
        		indicationdetail.setNote1(note1);
        		
        		indicationdetail.setNote2(note2);
        		
        		indicationdetail.setNote3(note3);
        		
        		indicationdetail.setNote4(note4);
        		
        		indicationdetail.setNote5(note5);
        		
        		indicationdetail.setNote6(note6);
        		
        		indicationdetail.setNote7(note7);
        		
        		indicationdetail.setNote8(note8);
        		
        		indicationdetail.setShortResult(shortResult);
        		
        		indicationdetail.setStatus(status);
        		
        		indicationdetail.setUser(userManager.getUser(user));
        		
	        	indicationdetailManager.updateIndicationdetail(indicationdetail);
	        	
	        	msg = "Luu thanh cong";
        	}  
	        else
	        {	     
	        	//load template from db
	        	if (indicationdetail.getResult().trim().equalsIgnoreCase(""))
	        	{
	        		
	        		result = indicationdetail.getService().getBodyPart().getDescription();
	        		//result = result.replaceAll("\n", "<br/>");
		        	indicationdetail.setResult(result);	  
		        
		        	indicationdetail.setUser(userManager.getUser(user));
		        	
		        	indicationdetailManager.updateIndicationdetail(indicationdetail);
		        }
	        }
        	
        	return SUCCESS;
        }

        catch(Exception e)
        {
        	e.printStackTrace();
        	return ERROR;
        }     

}

	public String getFile5() {
		return file5;
	}

	public void setFile5(String file5) {
		this.file5 = file5;
	}

	public String getFile6() {
		return file6;
	}

	public void setFile6(String file6) {
		this.file6 = file6;
	}

	public String getFile7() {
		return file7;
	}

	public void setFile7(String file7) {
		this.file7 = file7;
	}

	public String getFile8() {
		return file8;
	}

	public void setFile8(String file8) {
		this.file8 = file8;
	}
}
