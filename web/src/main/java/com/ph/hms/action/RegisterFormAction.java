package com.ph.hms.action;
import com.opensymphony.xwork.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import java.text.*;

public class RegisterFormAction extends ActionSupport
{
	public String fname = "client";
	public String aname = "add";
	
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
	
	private RoomManager roomManager;
	
	private Collection<Room> rooms;
	
	
	
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

	private String time;	
	
	public synchronized String getTime() {
		return time;
	}

	public synchronized void setTime(String time) {
		this.time = time;
	}

	private String flag;	
	
	public  String getFlag() {
		return flag;
	}

	public  void setFlag(String flag) {
		this.flag = flag;
	}

	private String sex;
	
	private int age;
	
	private int room;
	
	private String node;
	
	
	
	public  String getSex() {
		return sex;
	}

	public  void setSex(String sex) {
		this.sex = sex;
	}

	public  int getAge() {
		return age;
	}

	public  void setAge(int age) {
		this.age = age;
	}

	public  int getRoom() {
		return room;
	}

	public  void setRoom(int room) {
		this.room = room;
	}

	public  String getNode() {
		return node;
	}

	public  void setNode(String node) {
		this.node = node;
	}

	//for encounter
	private String date;
	
	private String phone;
	
	private String email;
		
	
	public  String getDate() {
		return date;
	}

	public  void setDate(String date) {
		this.date = date;
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

	private EncounterManager encounterManager;	
	
	public  EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public  void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}
	
	private Encounter encounter;
	
	

	public  Encounter getEncounter() {
		return encounter;
	}

	public  void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public  String getRandomString(int length) {
		 final String charset = "!0123456789abcdefghijklmnopqrstuvwxyz";
		 
        Random rand = new Random(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= length; i++) {
            int pos = rand.nextInt(charset.length());
            sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }

	
	public String execute() throws Exception
	{ 
	
	try{		
		   i18n = i18nManager.geti18n();	

		   
		   rooms = (Collection<Room>)roomManager.getAllRooms();
		
			Date d = new Date();
		
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
			DateFormat sdf2 = new SimpleDateFormat("hh:mm");
		
			today = sdf.format(d).toString();			
			time = sdf2.format(d).toString();			
		   
			return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }
       
    }

	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}

	public Collection<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
	}

	
}
