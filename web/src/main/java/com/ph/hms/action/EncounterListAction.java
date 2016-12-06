package com.ph.hms.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Client;
import com.ph.hms.Encounter;
import com.ph.hms.Hospital;
import com.ph.hms.Icd;
import com.ph.hms.Prescriptiontemplate;
import com.ph.hms.Room;
import com.ph.hms.Solving;
import com.ph.hms.User;
import com.ph.hms.action.util.DefaultSecurity;
import com.ph.hms.action.util.I18nManager;
import com.ph.hms.manager.ClientManager;
import com.ph.hms.manager.EncounterManager;
import com.ph.hms.manager.UserManager;

public class EncounterListAction extends ActionSupport {
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
	
	public String promotionCode;
	

	public String execute() throws Exception {
		try {
			i18n = i18nManager.geti18n();
			
			if (promotionCode!="" && promotionCode !=null)
			{				
				encounters = encounterManager.getEncountersByPromotionCode(promotionCode);
				return "promotion";
			}

			DefaultSecurity ds = new DefaultSecurity();

			boolean matched = ds.checkRight(fname, aname);
			
			if (matched == false)
				return "noprivilege";

			Map session = ActionContext.getContext().getSession();

			Room room = (Room) session.get("selectedroom");

			if (room != null) {
				encounters = (List<Encounter>) encounterManager
				.getAllEncounters(room);
				
			} else {
				encounters = (List<Encounter>) encounterManager
						.getAllEncounters(null);
				//encounters = (List<Encounter>)encounterManager.getEncouters(1, 50);
			}

			//remove because it is not neccesary
			//clients = (Collection<Client>) clientManager.getAllClients();

			icds = (Collection<Icd>) icdManager.getAllIcds();

			users = (Collection<User>) userManager.getAllUsers();

			prescriptiontemplates = (Collection<Prescriptiontemplate>) prescriptiontemplateManager
					.getAllPrescriptiontemplates();

			rooms = (Collection<Room>) roomManager.getAllRooms();

			solvings = (Collection<Solving>) solvingManager.getAllSolvings();

			hospitals = (Collection<Hospital>) hospitalManager
					.getAllHospitals();

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
