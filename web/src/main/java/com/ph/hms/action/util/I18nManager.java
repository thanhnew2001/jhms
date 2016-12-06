package com.ph.hms.action.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.opensymphony.xwork.ActionContext;

public class I18nManager {

	public Hashtable<String, String> geti18n()
	{
		
		Hashtable i18n = new Hashtable();
		  
		Map session = ActionContext.getContext().getSession();
		
		String selectedlang = (String)session.get("selectedlang");
		
		if (selectedlang == null) selectedlang = "vi";
		
		Locale  currentLocale = new Locale(selectedlang, selectedlang.toUpperCase());		
		   
		ResourceBundle rb = ResourceBundle.getBundle("com.ph.hms.i18n",
		                currentLocale);
		
		 ArrayList<String> aList = Collections.list(rb.getKeys());
		   
		 for(int i=0;i < aList.size(); i++)
		 {	  			   
			 i18n.put(aList.get(i), rb.getString(aList.get(i)));
			   
			   //System.out.println(i18n.get(aList.get(i)));
		 }		

		return i18n;		
	}
}
