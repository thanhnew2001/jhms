
package com.ph.hms;

import java.util.*;

public class Role {

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
	
		private Collection<Userrole> userroles;   
			
		
		public Collection<Userrole> getUserroles()
		{
			return userroles;
		}
		
		public void setUserroles(Collection<Userrole> userroles)
		{
			this.userroles =  userroles;
		}
		
		private Collection<Roleform> roleforms;   
			
		
		public Collection<Roleform> getRoleforms()
		{
			return roleforms;
		}
		
		public void setRoleforms(Collection<Roleform> roleforms)
		{
			this.roleforms =  roleforms;
		}
		
}
