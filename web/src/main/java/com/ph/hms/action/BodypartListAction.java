package com.ph.hms.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.BodyPart;
import com.ph.hms.BodyPartManager;
import com.ph.hms.HMSDataManager;
import com.ph.hms.action.util.DefaultSecurity;
import com.ph.hms.action.util.I18nManager;

public class BodypartListAction extends ActionSupport {

	public String fname = "bodypart";
	public String aname = "list";

	private BodyPartManager bodyPartManager;

	private int id;

	private BodyPart bodypart;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String node;

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	private String description;

	private Collection<BodyPart> bodyparts;

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

	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public BodyPartManager getBodyPartManager() {
		return bodyPartManager;
	}

	public void setBodyPartManager(BodyPartManager bodyPartManager) {
		this.bodyPartManager = bodyPartManager;
	}

	public Collection<BodyPart> getBodyparts() {
		return bodyparts;
	}

	public void setBodyparts(Collection<BodyPart> bodyparts) {
		this.bodyparts = bodyparts;
	}

	public BodyPart getBodypart() {
		return bodypart;
	}

	public void setBodypart(BodyPart bodypart) {
		this.bodypart = bodypart;
	}
	
	private HMSDataManager hmsDataManager;
	

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}
	
	
	public String execute() {
		i18n = i18nManager.geti18n();

		DefaultSecurity ds = new DefaultSecurity();

		boolean matched = ds.checkRight(fname, aname);

		if (matched == false)
			return "noprivilege";
		
		bodyparts = bodyPartManager.getAllBodyParts();

		if (action != null && action.equalsIgnoreCase("savebodypart")) {
			
			if (id>0)
			{
				bodypart = 	bodyPartManager.getBodyPart(id);
				bodypart.setNode(node);
				bodypart.setDescription(description);
				bodyPartManager.updateBodyPart(bodypart);
				
			}
			else
			{
				BodyPart bp = new BodyPart();

				bp.setNode(node);
				bp.setDescription(description);

				bodyPartManager.addBodyPart(bp);
				
				System.out.println(bp);
			}
		}
		
		if (action != null && action.equalsIgnoreCase("editbodypart")) {
			
			bodypart = bodyPartManager.getBodyPart(id);

		}

		if (action != null && action.equalsIgnoreCase("deletebodypart")) {
			bodyPartManager.deleteBodyPart(id);
			
		}
		
		if (action != null && action.equalsIgnoreCase("searchbodypart"))
		{
			try
			{
				String q = "select * from bodypart where node like '%" + keyword + "%'";
				ResultSet rs = hmsDataManager.getResultset(q);
				
				bodyparts = new ArrayList<BodyPart>();
				
				while(rs.next())
				{
					BodyPart b = new BodyPart();
					b.setId(rs.getInt("id"));
					b.setNode(rs.getString("node"));
					b.setDescription(rs.getString("description"));
					bodyparts.add(b);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return ERROR;
			}
			
		}

		//bodyparts = bodyPartManager.getAllBodyParts();	
		return SUCCESS;
	}

	

}
