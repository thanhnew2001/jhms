package com.ph.hms.action.util;

import java.util.*;


import com.opensymphony.xwork.ActionContext;
import com.opensymphony.xwork.ActionSupport;
import com.ph.hms.Department;
import com.ph.hms.DepartmentManager;
import com.ph.hms.Room;
import com.ph.hms.RoomManager;
import com.ph.hms.Warehouse;
import com.ph.hms.WarehouseManager;

public class SelectSettingAction extends ActionSupport {
	
	public String fname = "selectsetting";
	public String aname = "view";
	
	private Collection<Room> rooms;
	
	
	public Collection<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Collection<Room> rooms) {
		this.rooms = rooms;
	}

	private RoomManager roomManager;
	
	
	public RoomManager getRoomManager() {
		return roomManager;
	}

	public void setRoomManager(RoomManager roomManager) {
		this.roomManager = roomManager;
	}
	
	private int roomid;
	
	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	private Room selectedroom;
	

	public Room getSelectedroom() {
		return selectedroom;
	}

	public void setSelectedroom(Room selectedroom) {
		this.selectedroom = selectedroom;
	}
	
	private Collection<Department> departments;
	
	public Collection<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Collection<Department> departments) {
		this.departments = departments;
	}
	

	private Department selecteddepartment;
	
	
	public Department getSelecteddepartment() {
		return selecteddepartment;
	}

	public void setSelecteddepartment(Department selecteddepartment) {
		this.selecteddepartment = selecteddepartment;
	}
	
	private int departmentid;
	
	
	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	
	private DepartmentManager departmentManager;
	
	
	public DepartmentManager getDepartmentManager() {
		return departmentManager;
	}

	public void setDepartmentManager(DepartmentManager departmentManager) {
		this.departmentManager = departmentManager;
	}
	
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	private int warehouseid;
	
	private WarehouseManager warehouseManager;
	
	
	
	public  int getWarehouseid() {
		return warehouseid;
	}

	public  void setWarehouseid(int warehouseid) {
		this.warehouseid = warehouseid;
	}

	public  WarehouseManager getWarehouseManager() {
		return warehouseManager;
	}

	public  void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}
	
	private Warehouse selectedwarehouse;
	

	public  Warehouse getSelectedwarehouse() {
		return selectedwarehouse;
	}

	public  void setSelectedwarehouse(Warehouse selectedwarehouse) {
		this.selectedwarehouse = selectedwarehouse;
	}
	
	private Collection<Warehouse> warehouses;
	
	

	public synchronized Collection<Warehouse> getWarehouses() {
		return warehouses;
	}

	public synchronized void setWarehouses(Collection<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public String execute()
	{
		Map session = ActionContext.getContext().getSession();
		
		DefaultSecurity ds = new DefaultSecurity();
		   
		   boolean matched = ds.checkRight(fname, aname);
	  
		     
		   if (matched == false) return "noprivilege";
		
        rooms = roomManager.getAllRooms();
		
		if ( roomid > 0 )
		{
			selectedroom = roomManager.getRoom(roomid);
			
			session.put("selectedroom", selectedroom ); //assign room to session  
		}
		
		if ( roomid == 0 )
		{
			session.remove("selectedroom");
		}
		
		departments = departmentManager.getAllDepartments();
		
		if (departmentid>0)
		{
			selecteddepartment = departmentManager.getDepartment(departmentid);
			
			session.put("selecteddepartment", selecteddepartment);
		}
		if (departmentid == 0 )
		{
			session.remove("selecteddepartment");
		}

		warehouses = warehouseManager.getAllWarehouses();
		if (warehouseid>0)
		{
			selectedwarehouse = warehouseManager.getWarehouse(warehouseid);
			
			session.put("selectedwarehouse", selectedwarehouse);
		}
		if (warehouseid == 0)
		{
			session.remove("selectedwarehouse");
		}
		
		if (lang != "")
		{
			session.put("selectedlang", lang);
		}


		return SUCCESS;
		
	}




}
