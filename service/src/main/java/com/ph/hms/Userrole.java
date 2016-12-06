
package com.ph.hms;

import java.util.*;

public class Userrole {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private User user;   
		
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user =  user;
	}
	
	private Role role;   
		
	
	public Role getRole()
	{
		return role;
	}
	
	public void setRole(Role role)
	{
		this.role =  role;
	}
	
}
