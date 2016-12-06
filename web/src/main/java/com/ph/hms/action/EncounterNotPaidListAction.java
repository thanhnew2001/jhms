package com.ph.hms.action;

import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.sql.ResultSet;
import java.text.*;

import com.opensymphony.xwork.*;

public class EncounterNotPaidListAction extends ActionSupport {
	public String fname = "encounter";
	public String aname = "list";

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

	private EncounterManager encounterManager;

	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}

	private Collection<Encounter> encounters;

	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
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

	private HMSDataManager hmsDataManager;
	
	
	
	public  HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public  void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}
	
	private SolvingManager solvingManager;

	public SolvingManager getSolvingManager() {
		return solvingManager;
	}

	public void setSolvingManager(SolvingManager solvingManager) {
		this.solvingManager = solvingManager;
	}

	private Collection<Solving> solvings;

	public Collection<Solving> getSolvings() {
		return solvings;
	}

	public void setSolvings(Collection<Solving> solvings) {
		this.solvings = solvings;
	}

	private String con;
	
	private String typehead;
	
	
	
	public  String getCon() {
		return con;
	}

	public  void setCon(String con) {
		this.con = con;
	}

	public  String getTypehead() {
		return typehead;
	}

	public  void setTypehead(String typehead) {
		this.typehead = typehead;
	}

	public String execute() throws Exception {
		try {

			i18n = i18nManager.geti18n();

			DefaultSecurity ds = new DefaultSecurity();

			boolean matched = ds.checkRight(fname, aname);

			if (matched == false)
				return "noprivilege";

			Map session = ActionContext.getContext().getSession();

			Room room = (Room) session.get("selectedroom");
			
			String sql = "";
			
			if (con == null)
				sql = "select id as encounter from encounter where id not in (select if(encounter is null, 0, encounter) from druginvoice) " +
					" and  id in (select encounter from prescriptiondetail)" +
					" union " +
					" select distinct encounter  from indicationdetail where paid ='N' ";
			
			else if (con != "client")
				 sql = "select id as encounter from encounter where " + con + " = '" + typehead + "'";
			else
				 sql = "select id as encounter from encounter where client in (select id from client where code = '" + typehead + "')";
				
			
			ResultSet rs = hmsDataManager.getResultset(sql);
			
			encounters = new ArrayList<Encounter>();

			encounters.clear();
			
			while(rs.next())
			{
				if (rs.getInt("encounter") > 0 )
				{
					Encounter encounter = encounterManager.getEncounter(rs.getInt("encounter"));
					
					if (encounter != null)	
					{
						//System.out.println("adding "+ encounter.getCode());
							encounters.add(encounter);
					}
				}
								
			}
			
			Date d = new Date();

			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			today = sdf.format(d).toString();
			
			solvings = (Collection<Solving>) solvingManager.getAllSolvings();
			
			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}

	}
}
