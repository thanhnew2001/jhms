package com.ph.hms.action;
import java.util.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class VitalsignUpdateAction extends ActionSupport
{
	
	
	private VitalsignManager vitalsignManager;
	
	public VitalsignManager getVitalsignManager() {
		return vitalsignManager;
	}

	public void setVitalsignManager(VitalsignManager vitalsignManager) {
		this.vitalsignManager = vitalsignManager;
	}	
	
	private Collection<Vitalsign> vitalsigns;
	
	public Collection<Vitalsign> getVitalsigns() {
		return vitalsigns;
	}

	public void setVitalsigns(Collection<Vitalsign> vitalsigns) {
		this.vitalsigns = vitalsigns;
	}	
	
	private EncounterManager encounterManager;
	
	public EncounterManager getEncounterManager() {
		return encounterManager;
	}

	public void setEncounterManager(EncounterManager encounterManager) {
		this.encounterManager = encounterManager;
	}	
	
	private Collection<Encounter> encounters;
	
	public Collection<Encounter> getEncounters() {
		return encounters;
	}

	public void setEncounters(Collection<Encounter> encounters) {
		this.encounters = encounters;
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

	
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	private int encounter;   
		
	
	public int getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(int encounter)
	{
		this.encounter =  encounter;
	}
	
	private String time;   
		
	
	public String getTime()
	{
		return time;
	}
	
	public void setTime(String time)
	{
		this.time =  time;
	}
	
	private int pulse;   
		
	
	public int getPulse()
	{
		return pulse;
	}
	
	public void setPulse(int pulse)
	{
		this.pulse =  pulse;
	}
	
	private int pressureh;   
		
	
	public int getPressureh()
	{
		return pressureh;
	}
	
	public void setPressureh(int pressureh)
	{
		this.pressureh =  pressureh;
	}
	
	private int pressurel;   
		
	
	public int getPressurel()
	{
		return pressurel;
	}
	
	public void setPressurel(int pressurel)
	{
		this.pressurel =  pressurel;
	}
	
	private double temparature;   
		
	
	public double getTemparature()
	{
		return temparature;
	}
	
	public void setTemparature(double temparature)
	{
		this.temparature =  temparature;
	}
	
	private int breath;   
		
	
	public int getBreath()
	{
		return breath;
	}
	
	public void setBreath(int breath)
	{
		this.breath =  breath;
	}
	
	
	public String execute() throws Exception
    {
        try{

        	Vitalsign vitalsign = vitalsignManager.getVitalsign(id);
			
			
			vitalsign.setEncounter(encounterManager.getEncounter(encounter));
	
			vitalsign.setTime(time);
	
			vitalsign.setPulse(pulse);
	
			vitalsign.setPressureh(pressureh);
	
			vitalsign.setPressurel(pressurel);
	
			vitalsign.setTemparature(temparature);
	
			vitalsign.setBreath(breath);
	
			vitalsign.setEncounter(encounterManager.getEncounter(encounter));
	
			vitalsign.setTime(time);
	
			vitalsign.setPulse(pulse);
	
			vitalsign.setPressureh(pressureh);
	
			vitalsign.setPressurel(pressurel);
	
			vitalsign.setTemparature(temparature);
	
			vitalsign.setBreath(breath);
	
			
        	vitalsignManager.updateVitalsign(vitalsign);
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
