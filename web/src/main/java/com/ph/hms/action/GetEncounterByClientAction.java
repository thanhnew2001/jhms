package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class GetEncounterByClientAction extends ActionSupport
{
	
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
		
	
	private EncounterManager encounterManager;
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
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

	
	private Collection<Encounter> encounters;
	
	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
	}	
	
	private int id;
	
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
   
	   Map session = ActionContext.getContext().getSession();
	   
	   session.put("client_id", id);
	   
	   Client client = clientManager.getClient(id);
	   
	   
		clients = (Collection<Client>)clientManager.getAllClients();		
		
		icds = (Collection<Icd>)icdManager.getAllIcds();		
		
		users = (Collection<User>)userManager.getAllUsers();		
		
		prescriptiontemplates = (Collection<Prescriptiontemplate>)prescriptiontemplateManager.getAllPrescriptiontemplates();		
		
		rooms = (Collection<Room>)roomManager.getAllRooms();		
		
		solvings = (Collection<Solving>)solvingManager.getAllSolvings();		
		
		hospitals = (Collection<Hospital>)hospitalManager.getAllHospitals();		
		
	   
	   if (client != null)
	   {
	   		session.put("client_node", clientManager.getClient(id).getNode());
			encounters = encounterManager.getEncounterByClientId(client.getId());
	   }
	   else
	   {
		    encounters = (Collection<Encounter>)encounterManager.getAllEncounters(null);
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
