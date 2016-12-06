package com.ph.hms.action;
import java.util.*;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class HistoryAddAction extends ActionSupport
{

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	private HistoryManager historyManager;
	
	public HistoryManager getHistoryManager() {
		return historyManager;
	}

	public void setHistoryManager(HistoryManager historyManager) {
		this.historyManager = historyManager;
	}	
	
	private Collection<History> historys;
	
	public Collection<History> getHistorys() {
		return historys;
	}

	public void setHistorys(Collection<History> historys) {
		this.historys = historys;
	}	
	
	private ClientManager clientManager;
	
	public ClientManager getClientManager() {
		return clientManager;
	}

	public void setClientManager(ClientManager clientManager) {
		this.clientManager = clientManager;
	}	
	
	private Collection<Client> clients;
	
	public Collection<Client> getClients() {
		return clients;
	}

	public void setClients(Collection<Client> clients) {
		this.clients = clients;
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

	
	
	private int client;   
		
	
	public int getClient()
	{
		return client;
	}
	
	public void setClient(int client)
	{
		this.client =  client;
	}
	
	private String father;   
		
	
	public String getFather()
	{
		return father;
	}
	
	public void setFather(String father)
	{
		this.father =  father;
	}
	
	private String mother;   
		
	
	public String getMother()
	{
		return mother;
	}
	
	public void setMother(String mother)
	{
		this.mother =  mother;
	}
	
	private String sibling;   
		
	
	public String getSibling()
	{
		return sibling;
	}
	
	public void setSibling(String sibling)
	{
		this.sibling =  sibling;
	}
	
	private String partner;   
		
	
	public String getPartner()
	{
		return partner;
	}
	
	public void setPartner(String partner)
	{
		this.partner =  partner;
	}
	
	private String offspring;   
		
	
	public String getOffspring()
	{
		return offspring;
	}
	
	public void setOffspring(String offspring)
	{
		this.offspring =  offspring;
	}
	
	private String cancer;   
		
	
	public String getCancer()
	{
		return cancer;
	}
	
	public void setCancer(String cancer)
	{
		this.cancer =  cancer;
	}
	
	private String tuberculosis;   
		
	
	public String getTuberculosis()
	{
		return tuberculosis;
	}
	
	public void setTuberculosis(String tuberculosis)
	{
		this.tuberculosis =  tuberculosis;
	}
	
	private String diabetes;   
		
	
	public String getDiabetes()
	{
		return diabetes;
	}
	
	public void setDiabetes(String diabetes)
	{
		this.diabetes =  diabetes;
	}
	
	private String highbloodpressure;   
		
	
	public String getHighbloodpressure()
	{
		return highbloodpressure;
	}
	
	public void setHighbloodpressure(String highbloodpressure)
	{
		this.highbloodpressure =  highbloodpressure;
	}
	
	private String heartproblem;   
		
	
	public String getHeartproblem()
	{
		return heartproblem;
	}
	
	public void setHeartproblem(String heartproblem)
	{
		this.heartproblem =  heartproblem;
	}
	
	private String stroke;   
		
	
	public String getStroke()
	{
		return stroke;
	}
	
	public void setStroke(String stroke)
	{
		this.stroke =  stroke;
	}
	
	private String epilepsi;   
		
	
	public String getEpilepsi()
	{
		return epilepsi;
	}
	
	public void setEpilepsi(String epilepsi)
	{
		this.epilepsi =  epilepsi;
	}
	
	private String mentalillness;   
		
	
	public String getMentalillness()
	{
		return mentalillness;
	}
	
	public void setMentalillness(String mentalillness)
	{
		this.mentalillness =  mentalillness;
	}
	
	private String sucide;   
		
	
	public String getSucide()
	{
		return sucide;
	}
	
	public void setSucide(String sucide)
	{
		this.sucide =  sucide;
	}
	
	private Date breastexamdate;   
		
	
	public Date getBreastexamdate()
	{
		return breastexamdate;
	}
	
	public void setBreastexamdate(Date breastexamdate)
	{
		this.breastexamdate =  breastexamdate;
	}
	
	private String breastexamresult;   
		
	
	public String getBreastexamresult()
	{
		return breastexamresult;
	}
	
	public void setBreastexamresult(String breastexamresult)
	{
		this.breastexamresult =  breastexamresult;
	}
	
	private Date cadiacechodate;   
		
	
	public Date getCadiacechodate()
	{
		return cadiacechodate;
	}
	
	public void setCadiacechodate(Date cadiacechodate)
	{
		this.cadiacechodate =  cadiacechodate;
	}
	
	private String cadiacechoresult;   
		
	
	public String getCadiacechoresult()
	{
		return cadiacechoresult;
	}
	
	public void setCadiacechoresult(String cadiacechoresult)
	{
		this.cadiacechoresult =  cadiacechoresult;
	}
	
	private Date gynexamdate;   
		
	
	public Date getGynexamdate()
	{
		return gynexamdate;
	}
	
	public void setGynexamdate(Date gynexamdate)
	{
		this.gynexamdate =  gynexamdate;
	}
	
	private String gynexamresult;   
		
	
	public String getGynexamresult()
	{
		return gynexamresult;
	}
	
	public void setGynexamresult(String gynexamresult)
	{
		this.gynexamresult =  gynexamresult;
	}
	
	private Date prostateexamdate;   
		
	
	public Date getProstateexamdate()
	{
		return prostateexamdate;
	}
	
	public void setProstateexamdate(Date prostateexamdate)
	{
		this.prostateexamdate =  prostateexamdate;
	}
	
	private String prostateexamresult;   
		
	
	public String getProstateexamresult()
	{
		return prostateexamresult;
	}
	
	public void setProstateexamresult(String prostateexamresult)
	{
		this.prostateexamresult =  prostateexamresult;
	}
	
	private Date rectalexamdate;   
		
	
	public Date getRectalexamdate()
	{
		return rectalexamdate;
	}
	
	public void setRectalexamdate(Date rectalexamdate)
	{
		this.rectalexamdate =  rectalexamdate;
	}
	
	private String rectalexamresult;   
		
	
	public String getRectalexamresult()
	{
		return rectalexamresult;
	}
	
	public void setRectalexamresult(String rectalexamresult)
	{
		this.rectalexamresult =  rectalexamresult;
	}
	
	private Date sigmoiddate;   
		
	
	public Date getSigmoiddate()
	{
		return sigmoiddate;
	}
	
	public void setSigmoiddate(Date sigmoiddate)
	{
		this.sigmoiddate =  sigmoiddate;
	}
	
	private String sigmoidresult;   
		
	
	public String getSigmoidresult()
	{
		return sigmoidresult;
	}
	
	public void setSigmoidresult(String sigmoidresult)
	{
		this.sigmoidresult =  sigmoidresult;
	}
	

	public String execute() throws Exception
    {
        try{

			String code = historyManager.genCode("");
			
        	History history = new History();
			
			
			history.setClient(clientManager.getClient(client));
	
			history.setFather(father);
	
			history.setMother(mother);
	
			history.setSibling(sibling);
	
			history.setPartner(partner);
	
			history.setOffspring(offspring);
	
			history.setCancer(cancer);
	
			history.setTuberculosis(tuberculosis);
	
			history.setDiabetes(diabetes);
	
			history.setHighbloodpressure(highbloodpressure);
	
			history.setHeartproblem(heartproblem);
	
			history.setStroke(stroke);
	
			history.setEpilepsi(epilepsi);
	
			history.setMentalillness(mentalillness);
	
			history.setSucide(sucide);
	
			history.setBreastexamdate(breastexamdate);
	
			history.setBreastexamresult(breastexamresult);
	
			history.setCadiacechodate(cadiacechodate);
	
			history.setCadiacechoresult(cadiacechoresult);
	
			history.setGynexamdate(gynexamdate);
	
			history.setGynexamresult(gynexamresult);
	
			history.setProstateexamdate(prostateexamdate);
	
			history.setProstateexamresult(prostateexamresult);
	
			history.setRectalexamdate(rectalexamdate);
	
			history.setRectalexamresult(rectalexamresult);
	
			history.setSigmoiddate(sigmoiddate);
	
			history.setSigmoidresult(sigmoidresult);
	
			
        	historyManager.addHistory(history);
			
			id = history.getId();
        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi gi gi do");
            e.printStackTrace();
            return ERROR;
        }       
    }	
}
