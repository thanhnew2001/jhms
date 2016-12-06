
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Role;

public interface RoleManager {

	String ID = RoleManager.class.getName();
	
	public void addRole(Role role);
	
	public void updateRole(Role role);
	
	public void deleteRole(int id);
	
	public Role getRole(int id);
	
	public Collection<Role> getAllRoles();
	
	public Collection<Role> filter(String typehead);
	
	public Collection<Role> filterAll(String typehead);
	
	public Collection<Role> filterByCon(String con, String typehead);
	
	
	
	public String genCode(String formula);
	
	

}
