
package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import com.opensymphony.xwork.*;
import java.util.*;
import java.text.*;

public class DoctorFormAction extends ActionSupport
{	
	public String fname = "doctor";
	public String anameAdd = "add";
	public String anameEdit = "update";
	
	private Doctor doctor;
	
	private int id;	
		
   
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
	
	private DoctorManager doctorManager;
	
	public DoctorManager getDoctorManager() {
		return doctorManager;
	}

	public void setDoctorManager(DoctorManager doctorManager) {
		this.doctorManager = doctorManager;
	}	
	
	private Collection<Doctor> doctors;
	
	public Collection<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Collection<Doctor> doctors) {
		this.doctors = doctors;
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

	public String execute() throws Exception
    {
    
	try{
	
	   i18n = i18nManager.geti18n();	
	
	   DefaultSecurity ds = new DefaultSecurity();

	   code = doctorManager.genCode("");
	   
		doctors = (Collection<Doctor>)doctorManager.getAllDoctors();
		
		if( id == 0) {
			
			boolean matched = ds.checkRight(fname, anameAdd);

			   if (matched == false) return "noprivilege";
			
			Date d = new Date();
			
			DateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		
			today = sdf.format(d).toString();
			
			return SUCCESS;
			
		} else {
			boolean matched = ds.checkRight(fname, anameEdit);

			   if (matched == false) return "noprivilege";

        	doctor = doctorManager.getDoctor(id);
        	
        	return SUCCESS;
		}

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}



	
	