package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.opensymphony.xwork.*;

public class UserFormAction extends ActionSupport
{	
	public String fname = "user";
	public String aname = "update";
	
	private User user;
	   
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
	
	private Collection<Room> rooms;
	
	private Collection<Department> departments;
	
	private Collection<Warehouse> warehouses;
	
	

	public Collection<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
	}

	public Collection<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Collection<Department> departments) {
		this.departments = departments;
	}

	public Collection<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Collection<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();
	   
	   boolean matched = ds.checkRight(fname, aname);
  
	     
	   if (matched == false) return "noprivilege";

			
	   users = (Collection<User>)userManager.getAllUsers();
	
	   rooms = roomManager.getAllRooms();
	   departments = departmentManager.getAllDepartments();
	   warehouses = warehouseManager.getAllWarehouses();
	   
	//   code = userManager.genCode("");
	   
	   Date d = new Date();
		
		DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
	
		today = sdf.format(d).toString();
	
        user = userManager.getUser(id);
        
        System.out.println("User Form Action");
        	
        return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
