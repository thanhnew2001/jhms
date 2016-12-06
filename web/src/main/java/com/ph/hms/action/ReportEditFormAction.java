package com.ph.hms.action;
import com.ph.hms.*;
import com.ph.hms.action.util.*;
import java.util.*;
import com.opensymphony.xwork.*;

public class ReportEditFormAction extends ActionSupport
{	
	public String fname = "report";
	public String aname = "update";
	
	private Report report;
	
	private int id;	
		
   
	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
	
	private ReportManager reportManager;
	
	public ReportManager getReportManager() {
		return reportManager;
	}

	public void setReportManager(ReportManager reportManager) {
		this.reportManager = reportManager;
	}	
	
	private Collection<Report> reports;
	
	public Collection<Report> getReports() {
		return reports;
	}

	public void setReports(Collection<Report> reports) {
		this.reports = reports;
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

			
	reports = (Collection<Report>)reportManager.getAllReports();
	
	
        	report = reportManager.getReport(id);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
