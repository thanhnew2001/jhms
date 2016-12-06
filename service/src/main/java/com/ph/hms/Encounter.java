
package com.ph.hms;

import java.util.*;
import com.ph.hms.cardmanagement.*;

public class Encounter  {

	@Override
	public String toString() {
	
		String inds = "";
		for(Indicationdetail ind: this.getIndicationdetails())
		{
			inds+= ind.toString()+",";
		}
		
		return (this.getClient().getNode()+" - "+this.getDate()+" - "+inds);
	}


	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Client client;   
		
	
	public Client getClient()
	{
		return client;
	}
	
	public void setClient(Client client)
	{
		this.client =  client;
	}
	
	private Date date;   
		
	
	public Date getDate()
	{
		return date;
	}
	
	public void setDate(Date date)
	{
		this.date =  date;
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
	
	private String initialdiagnosis;   
		
	
	public String getInitialdiagnosis()
	{
		return initialdiagnosis;
	}
	
	public void setInitialdiagnosis(String initialdiagnosis)
	{
		this.initialdiagnosis =  initialdiagnosis;
	}
	
	private Icd icd;   
		
	
	public Icd getIcd()
	{
		return icd;
	}
	
	public void setIcd(Icd icd)
	{
		this.icd =  icd;
	}
	
	private Solving solving;   
		
	
	public Solving getSolving()
	{
		return solving;
	}
	
	public void setSolving(Solving solving)
	{
		this.solving =  solving;
	}
	
	private Hospital hospital;   
		
	
	public Hospital getHospital()
	{
		return hospital;
	}
	
	public void setHospital(Hospital hospital)
	{
		this.hospital =  hospital;
	}
	
	private Prescriptiontemplate prescriptiontemplate;   
		
	
	public Prescriptiontemplate getPrescriptiontemplate()
	{
		return prescriptiontemplate;
	}
	
	public void setPrescriptiontemplate(Prescriptiontemplate prescriptiontemplate)
	{
		this.prescriptiontemplate =  prescriptiontemplate;
	}
	
	private String code;   
		
	
	public String getCode()
	{
		return code;
	}
	
	public void setCode(String code)
	{
		this.code =  code;
	}
	
	private Room room;   
		
	
	public Room getRoom()
	{
		return room;
	}
	
	public void setRoom(Room room)
	{
		this.room =  room;
	}
	
	private String advise;   
		
	
	public String getAdvise()
	{
		return advise;
	}
	
	public void setAdvise(String advise)
	{
		this.advise =  advise;
	}
	
	private String revisit;   
		
	
	public String getRevisit()
	{
		return revisit;
	}
	
	public void setRevisit(String revisit)
	{
		this.revisit =  revisit;
	}
	
	private Date revisitdate;   
		
	
	public Date getRevisitdate()
	{
		return revisitdate;
	}
	
	public void setRevisitdate(Date revisitdate)
	{
		this.revisitdate =  revisitdate;
	}
	
	private String paid;   
		
	
	public String getPaid()
	{
		return paid;
	}
	
	public void setPaid(String paid)
	{
		this.paid =  paid;
	}
	
	private User user;   
		
	
	public User getUser()
	{
		return user;
	}
	
	public void setUser(User user)
	{
		this.user =  user;
	}
	
	private String insurancenumber;   
		
	
	public String getInsurancenumber()
	{
		return insurancenumber;
	}
	
	public void setInsurancenumber(String insurancenumber)
	{
		this.insurancenumber =  insurancenumber;
	}
	
	private Date joineddate;   
		
	
	public Date getJoineddate()
	{
		return joineddate;
	}
	
	public void setJoineddate(Date joineddate)
	{
		this.joineddate =  joineddate;
	}
	
	private Date expireddate;   
		
	
	public Date getExpireddate()
	{
		return expireddate;
	}
	
	public void setExpireddate(Date expireddate)
	{
		this.expireddate =  expireddate;
	}
	
	private double totalamount;   
		
	
	public double getTotalamount()
	{
		return totalamount;
	}
	
	public void setTotalamount(double totalamount)
	{
		this.totalamount =  totalamount;
	}
	
	private double insurancepay;   
		
	
	public double getInsurancepay()
	{
		return insurancepay;
	}
	
	public void setInsurancepay(double insurancepay)
	{
		this.insurancepay =  insurancepay;
	}
	
	private double paidamount;   
		
	
	public double getPaidamount()
	{
		return paidamount;
	}
	
	public void setPaidamount(double paidamount)
	{
		this.paidamount =  paidamount;
	}
	
	private double leftamount;   
		
	
	public double getLeftamount()
	{
		return leftamount;
	}
	
	public void setLeftamount(double leftamount)
	{
		this.leftamount =  leftamount;
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
	
	private String timedone;	
	
	public String getTimedone() {
		return timedone;
	}

	public void setTimedone(String timedone) {
		this.timedone = timedone;
	}


	private String reference;   
		
	
	public String getReference()
	{
		return reference;
	}
	
	public void setReference(String reference)
	{
		this.reference =  reference;
	}
	
	private Collection<Prescriptiondetail> prescriptiondetails;
	
	public Collection<Prescriptiondetail> getPrescriptiondetails() {
		return prescriptiondetails;
	}

	public void setPrescriptiondetails(
			Collection<Prescriptiondetail> prescriptiondetails) {
		this.prescriptiondetails = prescriptiondetails;
	}

	
		/*public Collection<Prescriptiondetail> getPrescriptiondetails()
		{
			List<Prescriptiondetail> pds = new ArrayList<Prescriptiondetail>();
			//Set<Prescriptiondetail> ps = new HashSet<Prescriptiondetail>();
			
			if (prescriptiondetails!=null)
			{
				for(Prescriptiondetail pd:prescriptiondetails)
				{
					pds.add(pd);
				}
				Collections.sort(pds);
				
				for(Prescriptiondetail p:pds)
				{
					ps.add(p);
				}
				
				return pds;
			}
			else return null;
			
			return this.prescriptiondetails;
		}
		
		public void setPrescriptiondetails(Collection<Prescriptiondetail> prescriptiondetails)
		{
			this.prescriptiondetails =  prescriptiondetails;
		}*/
		
		

		private Collection<Indicationdetail> indicationdetails;   
			
		
		public Collection<Indicationdetail> getIndicationdetails()
		{
			return indicationdetails;
		}
		
		public void setIndicationdetails(Collection<Indicationdetail> indicationdetails)
		{
			this.indicationdetails =  indicationdetails;
		}
		
		private Collection<Receipt> receipts;   
			
		
		public Collection<Receipt> getReceipts()
		{
			return receipts;
		}
		
		public void setReceipts(Collection<Receipt> receipts)
		{
			this.receipts =  receipts;
		}
		
		private Collection<Druginvoice> druginvoices;   
			
		
		public Collection<Druginvoice> getDruginvoices()
		{
			return druginvoices;
		}
		
		public void setDruginvoices(Collection<Druginvoice> druginvoices)
		{
			this.druginvoices =  druginvoices;
		}
		
		private Collection<Vitalsign> vitalsigns;

		public Collection<Vitalsign> getVitalsigns() {
			return vitalsigns;
		}

		public void setVitalsigns(Collection<Vitalsign> vitalsigns) {
			this.vitalsigns = vitalsigns;
		}
		
		private String file1;

		public String getFile1() {
			return file1;
		}

		public void setFile1(String file1) {
			this.file1 = file1;
		}
		
		private String promotionCode;

		public String getPromotionCode() {
			return promotionCode;
		}

		public void setPromotionCode(String promotionCode) {
			this.promotionCode = promotionCode;
		}
		
		
		private String problem;

		public String getProblem() {
			return problem;
		}

		public void setProblem(String problem) {
			this.problem = problem;
		}	
		
		private int encounterType;

		public int getEncounterType() {
			return encounterType;
		}

		public void setEncounterType(int encounterType) {
			this.encounterType = encounterType;
		}		
		
		private String history;
		
		private String observation;

		public String getHistory() {
			return history;
		}

		public void setHistory(String history) {
			this.history = history;
		}

		public String getObservation() {
			return observation;
		}

		public void setObservation(String observation) {
			this.observation = observation;
		}
		
		
		private String note;

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}
		
		private Date revisitdateCLS;

		public Date getRevisitdateCLS() {
			return revisitdateCLS;
		}

		public void setRevisitdateCLS(Date revisitdateCLS) {
			this.revisitdateCLS = revisitdateCLS;
		}
		
		private String prepaidCard;

		public String getPrepaidCard() {
			return prepaidCard;
		}

		public void setPrepaidCard(String prepaidCard) {
			this.prepaidCard = prepaidCard;
		}
		
				
		private Card card;

		public Card getCard() {
			return card;
		}

		public void setCard(Card card) {
			this.card = card;
		}
		
		private String fmPage1;
		
		private String fmPage2;

		public String getFmPage1() {
			return fmPage1;
		}

		public void setFmPage1(String fmPage1) {
			this.fmPage1 = fmPage1;
		}

		public String getFmPage2() {
			return fmPage2;
		}

		public void setFmPage2(String fmPage2) {
			this.fmPage2 = fmPage2;
		}
				
		private String fmPage3;
		
		private String fmPage4;

		public String getFmPage3() {
			return fmPage3;
		}

		public void setFmPage3(String fmPage3) {
			this.fmPage3 = fmPage3;
		}

		public String getFmPage4() {
			return fmPage4;
		}

		public void setFmPage4(String fmPage4) {
			this.fmPage4 = fmPage4;
		}
		
	
}
