package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class RoomUpdateAction extends ActionSupport
{
	
	
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
	
	private DepartmentManager departmentManager;
	
	public DepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}	
	
	private Collection<Department> departments;
	
	public Collection<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Collection<Department> departments) {
		this.departments = departments;
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
	
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private int department;   
		
	
	public int getDepartment()
	{
		return department;
	}
	
	public void setDepartment(int department)
	{
		this.department =  department;
	}
	
	private String doctor;   
		
	
	public String getDoctor()
	{
		return doctor;
	}
	
	public void setDoctor(String doctor)
	{
		this.doctor =  doctor;
	}
	
	
	public String execute() throws Exception
    {
        try{

        	Room room = roomManager.getRoom(id);
			
			
			room.setNode(node);
	
			room.setDepartment(departmentManager.getDepartment(department));
	
			room.setDoctor(doctor);
	
			room.setNode(node);
	
			room.setDepartment(departmentManager.getDepartment(department));
	
			room.setDoctor(doctor);
	
			
        	roomManager.updateRoom(room);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
