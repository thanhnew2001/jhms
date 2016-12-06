
package com.ph.hms.manager;

import java.util.*;

import com.ph.hms.Roleform;

public interface RoleformManager {

	String ID = RoleformManager.class.getName();
	
	public void addRoleform(Roleform roleform);
	
	public void updateRoleform(Roleform roleform);
	
	public void deleteRoleform(int id);
	
	public Roleform getRoleform(int id);
	
	public Collection<Roleform> getAllRoleforms();
	
	public Collection<Roleform> filter(String typehead);
	
	public Collection<Roleform> filterAll(String typehead);
	
	public Collection<Roleform> filterByCon(String con, String typehead);
	
	
	
	public String genCode(String formula);
	
	

}
