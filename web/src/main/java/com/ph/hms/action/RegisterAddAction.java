package com.ph.hms.action;

import com.opensymphony.xwork.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.util.*;
import java.text.*;

public class RegisterAddAction extends ActionSupport {
	public String fname = "client";
	public String aname = "add";

	private ClientManager clientManager;

	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}

	private PaymenttypeManager paymenttypeManager;

	public PaymenttypeManager getPaymenttypeManager() {
		return paymenttypeManager;
	}

	public void setPaymenttypeManager(PaymenttypeManager paymenttypeManager) {
		this.paymenttypeManager = paymenttypeManager;
	}

	private OccupationManager occupationManager;

	public OccupationManager getOccupationManager() {
		return occupationManager;
	}

	public void setOccupationManager(OccupationManager occupationManager) {
		this.occupationManager = occupationManager;
	}

	private WardManager wardManager;

	public WardManager getWardManager() {
		return wardManager;
	}

	public void setWardManager(WardManager wardManager) {
		this.wardManager = wardManager;
	}

	private EthnicManager ethnicManager;

	public EthnicManager getEthnicManager() {
		return ethnicManager;
	}

	public void setEthnicManager(EthnicManager ethnicManager) {
		this.ethnicManager = ethnicManager;
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

	private EncounterManager encounterManager;

	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}

	private Encounter encounter;

	public Encounter getEncounter() {
		return encounter;
	}

	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}

	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}

	private String sex;

	private int age;

	private String node;

	private String phone;

	private String email;

	//for encounter
	private String date;

	private String time;

	private int room;

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public String getRandomString(int length) {
		final String charset = "!0123456789abcdefghijklmnopqrstuvwxyz";

		Random rand = new Random(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= length; i++) {
			int pos = rand.nextInt(charset.length());
			sb.append(charset.charAt(pos));
		}
		return sb.toString();
	}

	private RegisterManager registerManager;

	public RegisterManager getRegisterManager() {
		return registerManager;
	}

	public void setRegisterManager(RegisterManager registerManager) {
		this.registerManager = registerManager;
	}

	private String confirm;

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	private int registerId;

	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private Register register;

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	public String execute() throws Exception {

		try {
			i18n = i18nManager.geti18n();
			Map session = ActionContext.getContext().getSession();

			if (confirm!=null && confirm.equalsIgnoreCase("yes") && registerId > 0) {
				register = registerManager.getRegister(registerId);

				if (register.getPassword().equals(password)) {
					register.setStatus("C");
					registerManager.updateRegister(register);
					msg = "Ban da dang ky thanh cong. Chung toi se goi cho ban";

				} else {
					msg = "Ban da dang ky khong thanh cong vi da nhap sai mat khau";
				}

				return SUCCESS;

			}
			else
			{

				String code = registerManager.genCode("R");
	
				register = new Register();
	
				register.setAge(age);
	
				register.setSex(sex);
	
				register.setName(node);
	
				Date d = new Date();
	
				register.setCode(code);
	
				register.setPassword(getRandomString(4));
	
				registerManager.addRegister(register);
	
				//and add encounter	        	
	
				register.setRoom(roomManager.getRoom(room));
	
				DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
				register.setDate(sdf.parse(date + " 12:00:00"));
	
				register.setTime(time);
	
				register.setStatus("I");
	
				registerManager.addRegister(register);
	
				//send a mail
				UtilManager utilManager = new UtilManager();
			
				String[]receivers = { "thanh.hispvietnam@gmail.com", email};
				
				if (email != "")
				{
				
				String content = ""
						+ "Kinh chao Quy khach !\n"
						+ "Ten :"
						+ register.getName()
						+ "\nMS cua quy khach la: "
						+ register.getCode()
						+ "\nMat khau :"
						+ register.getPassword()
						+ "\nQuy khach co the xem ho so benh an tai http://pkmytung.com";
				utilManager.postMail(receivers, "Dang ky kham PKDK My Tung",
						content, "admin@bacsigiadinhvietnam.org");
					System.out.println("A mail sent to " + email);
				}
				session.put("register", register);
	
				return SUCCESS;
			}//big else

		} catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace(); 
			return ERROR;
		}

	}

}
