package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class EncounterFormAction extends ActionSupport
{	
	public String fname = "encounter";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Encounter encounter;
	
	private int id;	
		
   
	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String now;

	public String getNow() {
		return now;
	}

	public void setNow(String now) {
		this.now = now;
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
	
	private ClientManager clientManager;
	
	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}	
	
	private Collection<Client> clients;
	
	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}	
	
	private IcdManager icdManager;
	
	public IcdManager getIcdManager() {
		return icdManager;
	}

	public void setIcdManager(IcdManager icdManager) {
		this.icdManager = icdManager;
	}	
	
	private Collection<Icd> icds;
	
	public Collection<Icd> getIcds() {
		return icds;
	}

	public void setIcds(Collection<Icd> icds) {
		this.icds = icds;
	}	
	
	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}	
	
	private Collection<User> users;
	
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}	
	
	private PrescriptiontemplateManager prescriptiontemplateManager;
	
	public PrescriptiontemplateManager getPrescriptiontemplateManager() {
		return prescriptiontemplateManager;
	}

	public void setPrescriptiontemplateManager(PrescriptiontemplateManager prescriptiontemplateManager) {
		this.prescriptiontemplateManager = prescriptiontemplateManager;
	}	
	
	private Collection<Prescriptiontemplate> prescriptiontemplates;
	
	public Collection<Prescriptiontemplate> getPrescriptiontemplates() {
		return prescriptiontemplates;
	}

	public void setPrescriptiontemplates(Collection<Prescriptiontemplate> prescriptiontemplates) {
		this.prescriptiontemplates = prescriptiontemplates;
	}	
	
	private RoomManager roomManager;
	
	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}	
	
	private Collection<Room> rooms;
	
	public Collection<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
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
	
	private HospitalManager hospitalManager;
	
	public HospitalManager getHospitalManager() {
		return hospitalManager;
	}

	public void setHospitalManager(HospitalManager hospitalManager) {
		this.hospitalManager = hospitalManager;
	}	
	
	private Collection<Hospital> hospitals;
	
	public Collection<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(Collection<Hospital> hospitals) {
		this.hospitals = hospitals;
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

	private Collection<Servicegroup> serviceGroups;	
	

	public Collection<Servicegroup> getServiceGroups() {
		return serviceGroups;
	}

	public void setServiceGroups(Collection<Servicegroup> serviceGroups) {
		this.serviceGroups = serviceGroups;
	}

	private ServicegroupManager servicegroupManager;
	
	
	
	public ServicegroupManager getServicegroupManager() {
		return servicegroupManager;
	}

	public void setServicegroupManager(ServicegroupManager servicegroupManager) {
		this.servicegroupManager = servicegroupManager;
	}
	
	private HMSDataManager hmsDataManager;
	

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}
	
	private String flag;
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
		
	
	icds = (Collection<Icd>)icdManager.getAllIcds();
	
	
	users = (Collection<User>)userManager.getAllUsers();
	
	
	prescriptiontemplates = (Collection<Prescriptiontemplate>)prescriptiontemplateManager.getAllPrescriptiontemplates();
	
	
	rooms = (Collection<Room>)roomManager.getAllRooms();
	
	
	solvings = (Collection<Solving>)solvingManager.getAllSolvings();
	
	
	hospitals = (Collection<Hospital>)hospitalManager.getAllHospitals();
	
	if ( id == 0){
		
		boolean matched = ds.checkRight(fname, anameAdd);

		if (matched == false) return "noprivilege";
		
		code = encounterManager.genCode("PK");

		Date d = new Date();
		
		DateFormat df = new SimpleDateFormat("dd/M/yyyy");
		
		DateFormat tf = new SimpleDateFormat("HH:mm");
		
		today = df.format(d).toString();
		
		now = tf.format(d).toString();
	
		return SUCCESS;
	} 
	else 
	{
		
		boolean matched = ds.checkRight(fname,anameEdit);

		if (matched == false) return "noprivilege";
	
		ResultSet rs = hmsDataManager.getResultset("select * from servicegroup where id<20");
		
		serviceGroups = new ArrayList<Servicegroup>();
		
		while(rs.next())
		{
			servicegroupManager.getServicegroup(rs.getInt("id"));
			serviceGroups.add(servicegroupManager.getServicegroup(rs.getInt("id")));
		}	
	
	        	encounter = encounterManager.getEncounter(id);
	        	
	        	if(flag != null && flag.equalsIgnoreCase("XNEdit"))
	        	{
	        		for(Indicationdetail i : encounter.getIndicationdetails())
	        		{
	        			String r = i.getResult();
	        			if(r!=null)
	        			{
			    			r = r.trim();
			    			r = r.replaceAll("<br>", "&#13;&#10;");
			    			i.setResult(r);
	        			}
	        		}
	        	}
	        	
	        	if(flag != null && flag.equalsIgnoreCase("XNView"))
	        	{
	        		for(Indicationdetail i : encounter.getIndicationdetails())
	        		{
	        			String r = i.getResult();
	        			if(r!=null)
	        			{
			    			r = r.trim();
			    			r = r.replaceAll("&#13;&#10;", "<br>");
			    			i.setResult(r);
	        			}
	        		}
	        	}
	        	
	           	
	        	return SUCCESS;
		}

    } catch(Exception e){
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
