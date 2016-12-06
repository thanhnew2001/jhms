package com.ph.hms.action.util;

import java.util.*;


import com.opensymphony.xwork.ActionContext;
import com.ph.hms.*;

public class DefaultSecurity {
	
public boolean checkRight(String fname, String aname)
{
	boolean matched = false; 
	Map session = ActionContext.getContext().getSession();
	   
	User user = (User)session.get("user");

	if (user.getNode().equalsIgnoreCase("admin")){ matched =true; return matched;}
	
	System.out.println(user.getNode());
	   
	if (user != null)
	{
		Collection<Userrole> userroles = user.getUserroles();
		  
		   for(int k=0; k<userroles.size(); k++)
		   {
			   Userrole userrole = (Userrole)userroles.iterator().next();

			   if (userrole != null)
			   {				    
				   Iterator<Roleform> roleforms  = userrole.getRole().getRoleforms().iterator();
				   
				  while (roleforms.hasNext())
				   {					  			  				  
		
					  Roleform roleform = (Roleform)roleforms.next();
					  if (roleform != null)
					  {
						  
						  String form = roleform.getForm();
		
						  if (form.equalsIgnoreCase(fname))
						  {
							  String list = roleform.getListable();				  
							  String add = roleform.getAddable();				  
							  String update = roleform.getUpdatable();				  
							  String delete = roleform.getDeletable();  
							  if ( aname.equalsIgnoreCase("list") && list.equalsIgnoreCase("Yes")){ matched = true;}
							  if ( aname.equalsIgnoreCase("add") && add.equalsIgnoreCase("Yes")) {matched = true;}
							  if ( aname.equalsIgnoreCase("update") && update.equalsIgnoreCase("Yes")){ matched = true;}
							  if ( aname.equalsIgnoreCase("delete") && delete.equalsIgnoreCase("Yes")) { matched = true;}

				
						  }		
					  }				  
				   }//for		   
			   }//if			   
		   }//for	
	}//if user != null
	   return matched;
	   
}
}
