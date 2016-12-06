package com.ph.hms.action;
import com.opensymphony.xwork.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import java.text.*;

public class UserroleAddFormAction extends ActionSupport
{
	public String fname = "userrole";
	public String aname = "add";
	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	private String today;
	
	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}
	
	
	private UserroleManager userroleManager;
	
	public UserroleManager getUserroleManager() {
		return userroleManager;
	}

	public void setUserroleManager(UserroleManager userroleManager) {
		this.userroleManager = userroleManager;
	}	
	
	private Collection<Userrole> userroles;
	
	public Collection<Userrole> getUserroles() {
		return userroles;
	}

	public void setUserroles(Collection<Userrole> userroles) {
		this.userroles = userroles;
	}	
	
	private UserManager userManager;
	
	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}	
	
	private Collection<User> users;
	
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}	
	
	private RoleManager roleManager;
	
	public RoleManager getRoleManager() {
		return roleManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}	
	
	private Collection<Role> roles;
	
	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
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

	
	public String execute() throws Exception
	{ 
	
	try{		
		   i18n = i18nManager.geti18n();	
		   
		   DefaultSecurity ds = new DefaultSecurity();
		   
		   boolean matched = ds.checkRight(fname, aname);
	  
			 
		   if (matched == false) return "noprivilege";
		   
		   code = userroleManager.genCode("");
		   
			
	userroles = (Collection<Userrole>)userroleManager.getAllUserroles();
	
	
	users = (Collection<User>)userManager.getAllUsers();
	
	
	roles = (Collection<Role>)roleManager.getAllRoles();
	
	
			
			Date d = new Date();
		
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
			today = sdf.format(d).toString();
		
			return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }
       
    }

	
}
