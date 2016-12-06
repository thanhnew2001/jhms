package com.ph.hms.action;

import java.util.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.sql.ResultSet;
import java.text.*;

import com.opensymphony.xwork.*;

public class EncounterNotPaidDrugListAction extends ActionSupport {
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

	public void setPrescriptiontemplateManager(
			PrescriptiontemplateManager prescriptiontemplateManager) {
		this.prescriptiontemplateManager = prescriptiontemplateManager;
	}

	private Collection<Prescriptiontemplate> prescriptiontemplates;

	public Collection<Prescriptiontemplate> getPrescriptiontemplates() {
		return prescriptiontemplates;
	}

	public void setPrescriptiontemplates(
			Collection<Prescriptiontemplate> prescriptiontemplates) {
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

	private HMSDataManager hmsDataManager;
	
	
	
	public  HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public  void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}
	
	private String name;
	private String birthday;
	private String phone;
	private String email;
	private String encountercode;	

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

	public  String getBirthday() {
		return birthday;
	}

	public  void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public  String getPhone() {
		return phone;
	}

	public  void setPhone(String phone) {
		this.phone = phone;
	}

	public  String getEmail() {
		return email;
	}

	public  void setEmail(String email) {
		this.email = email;
	}

	public  String getEncountercode() {
		return encountercode;
	}

	public  void setEncountercode(String encountercode) {
		this.encountercode = encountercode;
	}

	private Date filterDate;

	
	public Date getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(Date filterDate) {
		this.filterDate = filterDate;
	}

	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String execute() throws Exception {
		try {
			i18n = i18nManager.geti18n();

			DefaultSecurity ds = new DefaultSecurity();

			boolean matched = ds.checkRight(fname, aname);

			if (matched == false)
				return ERROR;

			Map session = ActionContext.getContext().getSession();

			Room room = (Room) session.get("selectedroom");

//			String sql = "select id from encounter where id not in (select if(encounter is null, 0, encounter) from druginvoice) " +
//					" and  id in (select encounter from prescriptiondetail) ";
//			
//			
//			if (encountercode !=null) sql+= " and (id in (select id from encounter where code = '"+encountercode+"') " +
//				" or id in (select e.id as encounterid from encounter e inner join client c on e.client=c.id where c.code = '"+encountercode+"') ) ";
//			
//			
//			if (name !=null) sql+= " and id in (select e.id as encounterid from encounter e inner join client c on e.client=c.id where c.node like  '%"+name+"%')   ";
//			if (phone !=null) sql+= " and id in (select e.id as encounterid from encounter e inner join client c on e.client=c.id where c.phone like '%"+phone+"%') ";
//			if (email !=null) sql+= " and id in (select e.id as encounterid from encounter e inner join client c on e.client=c.id where c.email like '%"+email+"%') ";
//		
			
			/*
			String sql = " select distinct encounter from vw_prescriptiondetail where encounter not in (select if(encounter is null, 0, encounter) from druginvoice) ";
			
			if (encountercode !=null && !encountercode.equalsIgnoreCase("")) 
			{
				sql+= " and (encountercode = '"+encountercode+"' or code='"+encountercode+"')";
				System.out.println("encountercode: " + encountercode);
			}
			else
			{
				System.out.println("encountercode: NULL");
			}
				
			if (name !=null && !name.equalsIgnoreCase("")  ) 
			{
				sql+= " and node like  '%"+name+"%'   ";
				System.out.println("name: " + name);
			}
			else
			{
				System.out.println("name: NULL");
				
			}
			
			if (phone !=null && !phone.equalsIgnoreCase("")  ) 
			{
				sql+= " and phone like '%"+phone+"%' ";
				System.out.println("phone: " + phone);
			}
			else
			{
				System.out.println("phone: NULL");
			}
			
			if (email !=null && !email.equalsIgnoreCase("") ) 
			{
				sql+= " and email like '%"+email+"%' ";
				System.out.println("email: " + email);
			}
			else
			{
				System.out.println("email: NULL");
			}
		
			
			ResultSet rs = hmsDataManager.getResultset(sql);
			
			encounters = new Vector<Encounter>();
			encounters.clear();
	
			int i = 0;
			if(rs !=null)
			{
				while(rs.next())
				{
					i++;
					if (rs.getInt("encounter") >0 )
						encounters.add(encounterManager.getEncounter(rs.getInt("encounter")));		
				}
			}
			
			System.out.println(encounters.size()+" - " +i);
			
			System.out.println(sql);
			
			*/
			
			encounters = encounterManager.searchEncounterForDrug(encountercode, filterDate); 
			
			Date d = new Date();
			
			DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
			today = sdf.format(d).toString();
		
			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}

	}
}
