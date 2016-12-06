package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class ClientFormAction extends ActionSupport
{	
	public String fname = "client";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Client client;	
   
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private int id;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
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

	private PaymenttypeManager paymenttypeManager;
	
	public PaymenttypeManager getPaymenttypeManager() {
		return paymenttypeManager;
	}

	public void setPaymenttypeManager(PaymenttypeManager paymenttypeManager) {
		this.paymenttypeManager = paymenttypeManager;
	}	
	
	private Collection<Paymenttype> paymenttypes;
	
	public Collection<Paymenttype> getPaymenttypes() {
		return paymenttypes;
	}

	public void setPaymenttypes(Collection<Paymenttype> paymenttypes) {
		this.paymenttypes = paymenttypes;
	}	
	
	private OccupationManager occupationManager;
	
	public OccupationManager getOccupationManager() {
		return occupationManager;
	}

	public void setOccupationManager(OccupationManager occupationManager) {
		this.occupationManager = occupationManager;
	}	
	
	private Collection<Occupation> occupations;
	
	public Collection<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(Collection<Occupation> occupations) {
		this.occupations = occupations;
	}	
	
	private WardManager wardManager;
	
	public WardManager getWardManager() {
		return wardManager;
	}

	public void setWardManager(WardManager wardManager) {
		this.wardManager = wardManager;
	}	
	
	private Collection<Ward> wards;
	
	public Collection<Ward> getWards() {
		return wards;
	}

	public void setWards(Collection<Ward> wards) {
		this.wards = wards;
	}	
	
	private EthnicManager ethnicManager;
	
	public EthnicManager getEthnicManager() {
		return ethnicManager;
	}

	public void setEthnicManager(EthnicManager ethnicManager) {
		this.ethnicManager = ethnicManager;
	}	
	
	private Collection<Ethnic> ethnics;
	
	public Collection<Ethnic> getEthnics() {
		return ethnics;
	}

	public void setEthnics(Collection<Ethnic> ethnics) {
		this.ethnics = ethnics;
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

	private RoomManager roomManager;
	
	private Collection<Room> rooms;
	
	

	public  RoomManager getRoomManager() {
		return roomManager;
	}

	public  void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}

	public  Collection<Room> getRooms() {
		return rooms;
	}

	public  void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
	}

private ServiceManager serviceManager;
	
	private Collection<Service> services;	
	
	
	public  ServiceManager getServiceManager() {
		return serviceManager;
	}

	public  void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}

	public  Collection<Service> getServices() {
		return services;
	}

	public  void setServices(Collection<Service> services) {
		this.services = services;
	}
	
	private HMSDataManager hmsDataManager;
	
	
	public  HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public  void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}

	private Collection<Serpackage> serpackages;

	public Collection<Serpackage> getSerpackages() {
		return serpackages;
	}

	public void setSerpackages(Collection<Serpackage> serpackages) {
		this.serpackages = serpackages;
	}

	private SerpackageManager serpackageManager;

	public SerpackageManager getSerpackageManager() {
		return serpackageManager;
	}

	public void setSerpackageManager(SerpackageManager serpackageManager) {
		this.serpackageManager = serpackageManager;
	}
	
	private Collection<Encounter> encounters;
	
	
	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
	}
	
	private EncounterManager encounterManager;
	
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}


	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
		
	paymenttypes = (Collection<Paymenttype>)paymenttypeManager.getAllPaymenttypes();
	
	
	occupations = (Collection<Occupation>)occupationManager.getAllOccupations();
	
	
	wards = (Collection<Ward>)wardManager.getAllWards();
	
	
	ethnics = (Collection<Ethnic>)ethnicManager.getAllEthnics();
	
	rooms = (Collection<Room>)roomManager.getAllRooms(); 
	
	serpackages = serpackageManager.getAllSerpackages();
	
	//get all check up service
	
	int checkupservicegroup = Integer.valueOf(i18n
			.get("checkupservicegroup").trim());
	
	String sql = "select id from service where servicegroup = "	+ checkupservicegroup;
//		String sql = "select id from service where servicegroup = 110";

	
	ResultSet rs = hmsDataManager.getResultset(sql);
	
	services = new ArrayList<Service>();
	
	while(rs.next())
	{
		services.add(serviceManager.getService(rs.getInt("id")));
	}
	
	if( id == 0){		
		boolean matched = ds.checkRight(fname, anameAdd);
		  
	    if (matched == false) return "noprivilege";
	    
	    code = clientManager.genCode("");

	
		clients = (Collection<Client>) clientManager.getAllClients();
		
		Date d = new Date();

		DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");

		today = sdf.format(d).toString();
		
		System.out.println("clientAddForm");
		System.out.println(id);
		
		return SUCCESS;
		
	} else {
		
		boolean matched = ds.checkRight(fname, anameEdit);
		  
		if (matched == false) return "noprivilege";
		
		client = clientManager.getClient(id);
		
		encounters = encounterManager.getEncounterByClientId(id);
		
		System.out.println("clientEditForm");
		System.out.println(id);
		
		return SUCCESS;

	}
      	
    

        }
        catch(Exception e){
            System.out.println("Error ClientFormAction");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
