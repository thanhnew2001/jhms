package com.ph.hms.action;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class EncounterAddUpdateAction extends ActionSupport
{
	public String fname = "encounter";
	public String aname = "update";
	
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

	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	private int client;   
		
	
	public int getClient()
	{
		return client;
	}
	
	public void setClient(int client)
	{
		this.client =  client;
	}
	
	private Date date;   
		
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date =  date;
	}
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private String initialdiagnosis;   
		
	
	public String getInitialdiagnosis()
	{
		return initialdiagnosis;
	}
	
	public void setInitialdiagnosis(String initialdiagnosis)
	{
		this.initialdiagnosis =  initialdiagnosis;
	}
	
	private int icd;   
		
	
	public int getIcd()
	{
		return icd;
	}
	
	public void setIcd(int icd)
	{
		this.icd =  icd;
	}
	
	private int solving;   
		
	
	public int getSolving()
	{
		return solving;
	}
	
	public void setSolving(int solving)
	{
		this.solving =  solving;
	}
	
	private int hospital;   
		
	
	public int getHospital()
	{
		return hospital;
	}
	
	public void setHospital(int hospital)
	{
		this.hospital =  hospital;
	}
	
	private int prescriptiontemplate;   
		
	
	public int getPrescriptiontemplate()
	{
		return prescriptiontemplate;
	}
	
	public void setPrescriptiontemplate(int prescriptiontemplate)
	{
		this.prescriptiontemplate =  prescriptiontemplate;
	}
	
	private String code;   
		
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
	}
	
	private int room;   
		
	
	public int getRoom()
	{
		return room;
	}
	
	public void setRoom(int room)
	{
		this.room =  room;
	}
	
	private String advise;   
		
	
	public String getAdvise()
	{
		return advise;
	}
	
	public void setAdvise(String advise)
	{
		this.advise =  advise;
	}
	
	private String revisit;   
		
	
	public String getRevisit()
	{
		return revisit;
	}
	
	public void setRevisit(String revisit)
	{
		this.revisit =  revisit;
	}
	
	private Date revisitdate;   
		
	
	public Date getRevisitdate()
	{
		return revisitdate;
	}
	
	public void setRevisitdate(Date revisitdate)
	{
		this.revisitdate =  revisitdate;
	}
	
	private String paid;   
		
	
	public String getPaid()
	{
		return paid;
	}
	
	public void setPaid(String paid)
	{
		this.paid =  paid;
	}
	
	private int user;   
		
	
	public int getUser()
	{
		return user;
	}
	
	public void setUser(int user)
	{
		this.user =  user;
	}
	
	private String insurancenumber;   
		
	
	public String getInsurancenumber()
	{
		return insurancenumber;
	}
	
	public void setInsurancenumber(String insurancenumber)
	{
		this.insurancenumber =  insurancenumber;
	}
	
	private Date joineddate;   
		
	
	public Date getJoineddate()
	{
		return joineddate;
	}
	
	public void setJoineddate(Date joineddate)
	{
		this.joineddate =  joineddate;
	}
	
	private Date expireddate;   
		
	
	public Date getExpireddate()
	{
		return expireddate;
	}
	
	public void setExpireddate(Date expireddate)
	{
		this.expireddate =  expireddate;
	}
	
	private double totalamount;   
		
	
	public double getTotalamount()
	{
		return totalamount;
	}
	
	public void setTotalamount(double totalamount)
	{
		this.totalamount =  totalamount;
	}
	
	private double insurancepay;   
		
	
	public double getInsurancepay()
	{
		return insurancepay;
	}
	
	public void setInsurancepay(double insurancepay)
	{
		this.insurancepay =  insurancepay;
	}
	
	private double paidamount;   
		
	
	public double getPaidamount()
	{
		return paidamount;
	}
	
	public void setPaidamount(double paidamount)
	{
		this.paidamount =  paidamount;
	}
	
	private double leftamount;   
		
	
	public double getLeftamount()
	{
		return leftamount;
	}
	
	public void setLeftamount(double leftamount)
	{
		this.leftamount =  leftamount;
	}
	
	
	
	private String reference;   
		
	
	public String getReference()
	{
		return reference;
	}
	
	public void setReference(String reference)
	{
		this.reference =  reference;
	}
	
	private String history;
	
	private String problem;
	
	private String observation;
	
	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}
	private Date revisitdateCLS;
	
	private String note;
	
	

	public Date getRevisitdateCLS() {
		return revisitdateCLS;
	}

	public void setRevisitdateCLS(Date revisitdateCLS) {
		this.revisitdateCLS = revisitdateCLS;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String execute() throws Exception
    {
        try{
        	
        	DefaultSecurity ds = new DefaultSecurity();
       	   	
       	   	Encounter encounter;
       	   	
       	   	if ( id ==0){
       	   		aname = "add";
       	   		boolean matched = ds.checkRight(fname, aname);  
   	     
       	   		if (matched == false) return "noprivilege";
       	   		
       	   		code = encounterManager.genCode("PK");
			
       	   		encounter = new Encounter();
       	   	} else {
        	   
	        	boolean matched = ds.checkRight(fname, aname);  
	        	     
	        	if (matched == false) return "noprivilege";
	        	   
	        	Map session = ActionContext.getContext().getSession();
	
	        	encounter = encounterManager.getEncounter(id);
       	   	}
      	
			encounter.setClient(clientManager.getClient(client));
			
			encounter.setInitialdiagnosis(initialdiagnosis);

			encounter.setDate(date);
	
			encounter.setNode(node);
	
			encounter.setInitialdiagnosis(initialdiagnosis);

			encounter.setIcd(icdManager.getIcd(icd));
	
			encounter.setSolving(solvingManager.getSolving(solving));
	
			encounter.setHospital(hospitalManager.getHospital(hospital));
	
			encounter.setPrescriptiontemplate(prescriptiontemplateManager.getPrescriptiontemplate(prescriptiontemplate));
	
			encounter.setCode(code);
	
			encounter.setRoom(roomManager.getRoom(room));
			
			encounter.setAdvise(advise);
			
			encounter.setRevisit(revisit);
	
			encounter.setRevisitdate(revisitdate);
	
			encounter.setPaid(paid);
	
			//now update user by selected one from the list
			encounter.setUser(userManager.getUser(user));
	
			encounter.setInsurancenumber(insurancenumber);
	
			encounter.setJoineddate(joineddate);
	
			encounter.setExpireddate(expireddate);
			
			encounter.setReference(reference);	
	
			Date d = new Date();
			
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			
			String timedone = sdf.format(d);
			
			encounter.setTimedone(timedone);
					
			//update 3 more fields
			encounter.setObservation(observation);
			
			encounter.setProblem(problem);
			
			encounter.setHistory(history);
			
			encounter.setNote(note);
			
			encounter.setRevisitdateCLS(revisitdateCLS);
			
			encounter.setTotalamount(totalamount);
			
			encounter.setInsurancepay(insurancepay);
	
			encounter.setPaidamount(paidamount);
	
			encounter.setLeftamount(leftamount);
			
			if( aname == "add"){
				encounterManager.addEncounter(encounter);
				
				id = encounter.getId();
			} else {
			
				encounterManager.updateEncounter(encounter);
				
			}
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Error EncounterAddUpdateAction");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
