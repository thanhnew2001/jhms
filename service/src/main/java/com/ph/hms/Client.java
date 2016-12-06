
package com.ph.hms;

import java.util.*;

public class Client {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	private Paymenttype paymenttype;   
		
	
	public Paymenttype getPaymenttype()
	{
		return paymenttype;
	}
	
	public void setPaymenttype(Paymenttype paymenttype)
	{
		this.paymenttype =  paymenttype;
	}
	
	private String maritalstatus;   
		
	
	public String getMaritalstatus()
	{
		return maritalstatus;
	}
	
	public void setMaritalstatus(String maritalstatus)
	{
		this.maritalstatus =  maritalstatus;
	}
	
	private int age;   
		
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age =  age;
	}
	
	private Date birthday;   
		
	
	public Date getBirthday()
	{
		return birthday;
	}
	
	public void setBirthday(Date birthday)
	{
		this.birthday =  birthday;
	}
	
	private String sex;   
		
	
	public String getSex()
	{
		return sex;
	}
	
	public void setSex(String sex)
	{
		this.sex =  sex;
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
	
	private Date createddate;   
		
	
	public Date getCreateddate()
	{
		return createddate;
	}
	
	public void setCreateddate(Date createddate)
	{
		this.createddate =  createddate;
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
	
	private String insurancenumber;   
		
	
	public String getInsurancenumber()
	{
		return insurancenumber;
	}
	
	public void setInsurancenumber(String insurancenumber)
	{
		this.insurancenumber =  insurancenumber;
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
	
	private Date joineddate;   
		
	
	public Date getJoineddate()
	{
		return joineddate;
	}
	
	public void setJoineddate(Date joineddate)
	{
		this.joineddate =  joineddate;
	}
	
	private String oversea;   
		
	
	public String getOversea()
	{
		return oversea;
	}
	
	public void setOversea(String oversea)
	{
		this.oversea =  oversea;
	}
	
	private String address;   
		
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address =  address;
	}
	
	private Ward ward;   
		
	
	public Ward getWard()
	{
		return ward;
	}
	
	public void setWard(Ward ward)
	{
		this.ward =  ward;
	}
	
	private String motherfather;   
		
	
	public String getMotherfather()
	{
		return motherfather;
	}
	
	public void setMotherfather(String motherfather)
	{
		this.motherfather =  motherfather;
	}
	
	private Ethnic ethnic;   
		
	
	public Ethnic getEthnic()
	{
		return ethnic;
	}
	
	public void setEthnic(Ethnic ethnic)
	{
		this.ethnic =  ethnic;
	}
	
	private Occupation occupation;   
		
	
	public Occupation getOccupation()
	{
		return occupation;
	}
	
	public void setOccupation(Occupation occupation)
	{
		this.occupation =  occupation;
	}
	
	private String password;   
		
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password =  password;
	}
	
	private String education;   
		
	
	public String getEducation()
	{
		return education;
	}
	
	public void setEducation(String education)
	{
		this.education =  education;
	}
	
	private String company;   
		
	
	public String getCompany()
	{
		return company;
	}
	
	public void setCompany(String company)
	{
		this.company =  company;
	}
	
	private String phone;   
		
	
	public String getPhone()
	{
		return phone;
	}
	
	private String email;	
	
	public  String getEmail() {
		return email;
	}

	public  void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone)
	{
		this.phone =  phone;
	}
	
	private History history;
	
	
	public History getHistory() {
		return history;
	}

	public void setHistory(History history) {
		this.history = history;
	}

/*	private Collection<Encounter> encounters;   
			
		
		public Collection<Encounter> getEncounters()
		{
			return encounters;
		}
		
		public void setEncounters(Collection<Encounter> encounters)
		{
			this.encounters =  encounters;
		}*/
		
		private Collection<Druginvoice> druginvoices;   
			
		
		public Collection<Druginvoice> getDruginvoices()
		{
			return druginvoices;
		}
		
		public void setDruginvoices(Collection<Druginvoice> druginvoices)
		{
			this.druginvoices =  druginvoices;
		}
		
		private Collection<FamilyMember> familyMembers;

		public Collection<FamilyMember> getFamilyMembers() {
			return familyMembers;
		}

		public void setFamilyMembers(Collection<FamilyMember> familyMembers) {
			this.familyMembers = familyMembers;
		}
		
		private String photo;

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}
		
		private float lon;
		
		private float lat;

		public float getLon() {
			return lon;
		}

		public void setLon(float lon) {
			this.lon = lon;
		}

		public float getLat() {
			return lat;
		}

		public void setLat(float lat) {
			this.lat = lat;
		}

		private String mayhgd;

		public String getMayhgd() {
			return mayhgd;
		}

		public void setMayhgd(String mayhgd) {
			this.mayhgd = mayhgd;
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
		
		
		
}
