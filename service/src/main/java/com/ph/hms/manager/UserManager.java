
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.User;

public interface UserManager {

	String ID = UserManager.class.getName();
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUser(int id);
	
	public User getUser(int id);
	
	public Collection<User> getAllUsers();
	
	public Collection<User> filter(String typehead);
	
	public Collection<User> filterAll(String typehead);
	
	public Collection<User> filterByCon(String con, String typehead);
	
	
	
	public String genCode(String formula);
	
	

	public User getUserByUsernameAndPassword(String username, String password);

}
