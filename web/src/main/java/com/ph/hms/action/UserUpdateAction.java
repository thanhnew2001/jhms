package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class UserUpdateAction extends ActionSupport
{
	
	
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
	
	
	private String password;   
		
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password =  password;
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
	
	private String position;   
		
	
	public String getPosition()
	{
		return position;
	}
	
	public void setPosition(String position)
	{
		this.position =  position;
	}
	
	private String fullname;   
		
	
	public String getFullname()
	{
		return fullname;
	}
	
	public void setFullname(String fullname)
	{
		this.fullname =  fullname;
	}
	
	private String phone;   
		
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone =  phone;
	}
	
	private String cellphone;   
		
	
	public String getCellphone()
	{
		return cellphone;
	}
	
	public void setCellphone(String cellphone)
	{
		this.cellphone =  cellphone;
	}
	
	private String email;   
		
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email =  email;
	}
	
private RoomManager roomManager;
	
	private DepartmentManager departmentManager;
	
	private WarehouseManager warehouseManager;	
	
	
	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}

	public DepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}

	public WarehouseManager getWarehouseManager() {
		return warehouseManager;
	}

	public void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}
	
	private int room;
	
	private int warehouse;
	
	private int department;
	
	

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(int warehouse) {
		this.warehouse = warehouse;
	}

	public int getdepartment() {
		return department;
	}

	public void setdepartment(int department) {
		this.department = department;
	}
	
	public String execute() throws Exception
    {
        try{

        	User user = userManager.getUser(id);
			
			
			user.setPassword(password);
	
			user.setNode(node);
	
			user.setPosition(position);
	
			user.setFullname(fullname);
	
			user.setPhone(phone);
	
			user.setCellphone(cellphone);
	
			user.setEmail(email);
	
			user.setPassword(password);
	
			user.setNode(node);
	
			user.setPosition(position);
	
			user.setFullname(fullname);
	
			user.setPhone(phone);
	
			user.setCellphone(cellphone);
	
			user.setEmail(email);
			
			user.setRoom(roomManager.getRoom(room));
			user.setDepartment(departmentManager.getDepartment(department));
			user.setWarehouse(warehouseManager.getWarehouse(warehouse));			
	
	
			
        	userManager.updateUser(user);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
