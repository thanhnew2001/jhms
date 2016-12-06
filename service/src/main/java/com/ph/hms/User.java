
package com.ph.hms;

import java.util.*;

public class User {

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
	
		private Collection<Userrole> userroles;   
			
		
		public Collection<Userrole> getUserroles()
		{
			return userroles;
		}
		
		public void setUserroles(Collection<Userrole> userroles)
		{
			this.userroles =  userroles;
		}
		
		private Room room;
		
		private Department department;
		
		private Warehouse warehouse;

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Warehouse getWarehouse() {
			return warehouse;
		}

		public void setWarehouse(Warehouse warehouse) {
			this.warehouse = warehouse;
		}
		
		
		
}
