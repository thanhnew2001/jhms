package com.ph.hms.action;

import java.util.*;
import java.io.*;
import java.text.*;
import java.text.DateFormat;

import javax.mail.internet.*;
import javax.mail.*;

import jxl.*;
import jxl.write.*;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ClientAddUpdateAction extends ActionSupport {

	public String fname = "client";
	public String aname ;
	
	
	//*****************for client property***************************/
	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	private int paymenttype;

	public int getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(int paymenttype) {
		this.paymenttype = paymenttype;
	}

	private String maritalstatus;

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private String sex;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	private String node;

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	private Date createddate;

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String insurancenumber;

	public String getInsurancenumber() {
		return insurancenumber;
	}

	public void setInsurancenumber(String insurancenumber) {
		this.insurancenumber = insurancenumber;
	}

	private Date expireddate;

	public Date getExpireddate() {
		return expireddate;
	}

	public void setExpireddate(Date expireddate) {
		this.expireddate = expireddate;
	}

	private Date joineddate;

	public Date getJoineddate() {
		return joineddate;
	}

	public void setJoineddate(Date joineddate) {
		this.joineddate = joineddate;
	}

	private String oversea;

	public String getOversea() {
		return oversea;
	}

	public void setOversea(String oversea) {
		this.oversea = oversea;
	}

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private int ward;

	public int getWard() {
		return ward;
	}

	public void setWard(int ward) {
		this.ward = ward;
	}

	private String motherfather;

	public String getMotherfather() {
		return motherfather;
	}

	public void setMotherfather(String motherfather) {
		this.motherfather = motherfather;
	}

	private int ethnic;

	public int getEthnic() {
		return ethnic;
	}

	public void setEthnic(int ethnic) {
		this.ethnic = ethnic;
	}

	private int occupation;

	public int getOccupation() {
		return occupation;
	}

	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String education;

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//extra for room

	private int room;

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	private RoomManager roomManager;

	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}

	private EncounterManager encounterManager;
	
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}

	private int encounterid;
	
	
	
	public  int getEncounterid() {
		return encounterid;
	}

	public  void setEncounterid(int encounterid) {
		this.encounterid = encounterid;
	}

	private String email;

	public  String getEmail() {
		return email;
	}

	public  void setEmail(String email) {
		this.email = email;
	}

	private int service;
	
	
	public  int getService() {
		return service;
	}

	public  void setService(int service) {
		this.service = service;
	}

	private ServiceManager serviceManager;
	
	
	public  ServiceManager getServiceManager() {
		return serviceManager;
	}

	public  void setServiceManager(ServiceManager serviceManager) {
		this.serviceManager = serviceManager;
	}
	
	private IndicationdetailManager indicationdetailManager;
	
	
	public  IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public  void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}
	
	//vital sign
	private int pulse;
	private int breath;
	private int pressurel;
	private int pressureh;
	private int temperature;

	public  int getPulse() {
		return pulse;
	}

	public  void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public  int getBreath() {
		return breath;
	}

	public  void setBreath(int breath) {
		this.breath = breath;
	}

	public  int getPressurel() {
		return pressurel;
	}

	public  void setPressurel(int pressurel) {
		this.pressurel = pressurel;
	}

	public  int getPressureh() {
		return pressureh;
	}

	public  void setPressureh(int pressureh) {
		this.pressureh = pressureh;
	}

	public  int getTemperature() {
		return temperature;
	}

	public  void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	private VitalsignManager vitalsignManager;
	
	
	
	public VitalsignManager getVitalsignManager() {
		return vitalsignManager;
	}

	public void setVitalsignManager(VitalsignManager vitalsignManager) {
		this.vitalsignManager = vitalsignManager;
	}
	
	private int serpackage;	
	

	public int getSerpackage() {
		return serpackage;
	}

	public void setSerpackage(int serpackage) {
		this.serpackage = serpackage;
	}
	
	private SerpackageManager serpackageManager;	


	public SerpackageManager getSerpackageManager() {
		return serpackageManager;
	}

	public void setSerpackageManager(SerpackageManager serpackageManager) {
		this.serpackageManager = serpackageManager;
	}
	
	private int sbo2;
	
	private int height;
	
	private int weight;
	

	public int getSbo2() {
		return sbo2;
	}

	public void setSbo2(int sbo2) {
		this.sbo2 = sbo2;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	private HistoryManager historyManager;
	

	public HistoryManager getHistoryManager() {
		return historyManager;
	}

	public void setHistoryManager(HistoryManager historyManager) {
		this.historyManager = historyManager;
	}

	private String file1;	
	
	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}
	
	private String promotionCode;	
	

	public String getPromotionCode() {
		return promotionCode;
	}

	public void setPromotionCode(String promotionCode) {
		this.promotionCode = promotionCode;
	}

	private String prepaidCard;
	
	public String getPrepaidCard() {
		return prepaidCard;
	}

	public void setPrepaidCard(String prepaidCard) {
		this.prepaidCard = prepaidCard;
	}
	private String mayhgd;
	
	

	public String getMayhgd() {
		return mayhgd;
	}

	public void setMayhgd(String mayhgd) {
		this.mayhgd = mayhgd;
	}

	public String execute() throws Exception
    {
        try{
                   
      
        	i18n = i18nManager.geti18n();	
        	System.out.println("ClientAddUpdateAction excecute... ");
			System.out.println(id);

       	   DefaultSecurity ds = new DefaultSecurity();
       	   
       	   Client client;
       	   
       	   //add action
       	   if ( id == 0){
       		   
       		   aname = "add";
       		   boolean matched = ds.checkRight(fname, aname);  
      	     
        	   if (matched == false) return "noprivilege";
        	   
        	   code = clientManager.genCode("KH");
   			
           		client = new Client();
           		
           		client.setPhoto(file1);
    			
    			PasswordGenerator pg = new PasswordGenerator();
    			
    			if (password == null) password = pg.getRandomString(5);
           	
       	   } 
       	   //update action
       	   else {
       		   aname = "update";
       		   
       		   boolean matched = ds.checkRight(fname, aname);  
   	     
       		   if (matched == false) return "noprivilege";
       		   
       		   client = clientManager.getClient(id);
       		   
       	   }
       	   
       	   //initialize client
			client.setPaymenttype(paymenttypeManager.getPaymenttype(paymenttype));
	
			client.setMaritalstatus(maritalstatus);
	
			client.setAge(age);
	
			client.setBirthday(birthday);
	
			client.setSex(sex);
	
			client.setNode(node);
	
			client.setCreateddate(createddate);
	
			client.setCode(code);
	
			client.setInsurancenumber(insurancenumber);
	
			client.setExpireddate(expireddate);
	
			client.setJoineddate(joineddate);
	
			client.setOversea(oversea);
	
			client.setAddress(address);
	
			client.setWard(wardManager.getWard(ward));
	
			client.setMotherfather(motherfather);
	
			client.setEthnic(ethnicManager.getEthnic(ethnic));
	
			client.setOccupation(occupationManager.getOccupation(occupation));
			
			client.setPassword(password);
	
			client.setEducation(education);
	
			client.setCompany(company);
	
			client.setPhone(phone);
			
			client.setEmail(email);
			
			client.setMayhgd(mayhgd);
			
			//add client
			if( aname == "add"){
	        	//add a history
	        	History history = new History();
	        	        	
	        	historyManager.addHistory(history);
	        	        	
	        	client.setHistory(history);
	        	
	        	clientManager.addClient(client);   
			} 
			//update client
			else {
				clientManager.updateClient(client);
			}
			
			id = client.getId();
        	
			//add encounter
        	if (room > 0 )
        	{

	        	Encounter encounter = new Encounter();	
	        	
	        	encounter.setClient(client);	        	
	        	encounter.setRoom(roomManager.getRoom(room));	        	
	        	encounter.setCode(encounterManager.genCode("PK"));
	        	encounter.setPromotionCode(promotionCode);
	        	encounter.setPrepaidCard(prepaidCard);
	        	
	        	Date d = new Date();				
				SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm:ss");				
				String time = sdf2.format(d);
				
				encounter.setTime(time);
				
	        	encounterManager.addEncounter(encounter);
	        	
	        	//add vital sign
				Vitalsign vitalsign = new Vitalsign();
				vitalsign.setEncounter(encounter);
				vitalsign.setBreath(breath);
				vitalsign.setPressureh(pressureh);
				vitalsign.setPressurel(pressurel);
				vitalsign.setPulse(pulse);
				vitalsign.setTemparature(temperature);			
				vitalsign.setHeight(height);
				vitalsign.setWeight(weight);
				vitalsign.setSbo2(sbo2);
				
				if(height > 0 && weight > 0)
				{
					double h = height/100;
					vitalsign.setBmi(weight/(h*h));
					
				}
				else
				{
					vitalsign.setBmi(0);
				}
				
				vitalsignManager.addVitalsign(vitalsign);		
				
				encounterid = encounter.getId();
				
				//add service
				if ( service > 0 )
				{
					Indicationdetail ind = new Indicationdetail();
					ind.setService(serviceManager.getService(service));
					ind.setPrice(ind.getService().getPrice());
					ind.setQuantity(1);
					ind.setStatus("NEW");
					ind.setPaid("N");
					
					ind.setEncounter(encounter);
					
					indicationdetailManager.addIndicationdetail(ind);			
				}
				
				else if ( serpackage > 0 )
				{
					Serpackage ser = serpackageManager.getSerpackage(serpackage);
					
					
	
					for (Packagedetail packagedetail: ser.getPackagedetails())
					{
						Indicationdetail ind = new Indicationdetail();
						ind.setService(serviceManager.getService(service));
						ind.setPrice(ind.getService().getPrice());
						ind.setQuantity(1);
						ind.setStatus("NEW");
						ind.setPaid("N");
						
						ind.setEncounter(encounter);
						
						indicationdetailManager.addIndicationdetail(ind);	
					}			
				}
     	
    		
        	}//room >0
     	
			/*
			// create file excel			
        	//String dir = System.getenv("jhms_upload");
        	String dir = i18n.get("jhmsdata");
			System.out.println(dir);
			String filename = dir + "xls/"+ client.getCode()+".xls";
			WorkbookSettings ws = new WorkbookSettings();
			ws.setLocale(new Locale("en", "EN"));
			WritableWorkbook workbook = Workbook.createWorkbook(new File(
					filename), ws);
			WritableSheet s = workbook.createSheet("Sheet1", 0);

			// Format the Font 
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.BOLD);
			WritableCellFormat cf = new WritableCellFormat(wf);
			cf.setWrap(true);

			//Creates Label and writes date to one cell of sheet 
			Label l = new Label(0, 1, client.getNode(), cf);
			s.addCell(l);
			l = new Label(0, 0, "name", cf);
			s.addCell(l);
			// Creates Label and writes date to one cell of sheet 

			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			String today ="";
			if (client.getBirthday()!=null)
			{
				today = sdf.format(client.getBirthday()).toString();
			}

			l = new Label(1, 1, today, cf);
			s.addCell(l);
			l = new Label(1, 0, "date", cf);
			s.addCell(l);
			// Creates Label and writes date to one cell of sheet 
			l = new Label(2, 1, client.getSex(), cf);
			s.addCell(l);
			l = new Label(2, 0, "sex", cf);
			s.addCell(l);
			// Creates Label and writes date to one cell of sheet 
			l = new Label(3, 1, client.getCode(), cf);
			s.addCell(l);
			l = new Label(3, 0, "code", cf);
			s.addCell(l);
			// Creates Label and writes date to one cell of sheet 

			l = new Label(4, 1, client.getWard().getDistrict().getProvince()
					.getNode(), cf);
			s.addCell(l);
			l = new Label(4, 0, "province", cf);
			s.addCell(l);

			workbook.write();
			workbook.close();            
            
            */
        	return SUCCESS;

        }
      
        catch(Exception e){
            System.out.println("Error ClientAddUpdateAction");
            e.printStackTrace();
            return ERROR;
        }
        
    }
}
