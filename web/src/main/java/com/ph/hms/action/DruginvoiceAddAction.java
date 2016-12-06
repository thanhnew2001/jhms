package com.ph.hms.action;

import java.util.*;
import java.sql.ResultSet;
import java.text.*;
import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class DruginvoiceAddAction extends ActionSupport {

	public String fname = "druginvoice";
	public String aname = "add";
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private DruginvoiceManager druginvoiceManager;

	public DruginvoiceManager getDruginvoiceManager() {
		return druginvoiceManager;
	}

	public void setDruginvoiceManager(DruginvoiceManager druginvoiceManager) {
		this.druginvoiceManager = druginvoiceManager;
	}

	private Collection<Druginvoice> druginvoices;

	public Collection<Druginvoice> getDruginvoices() {
		return druginvoices;
	}

	public void setDruginvoices(Collection<Druginvoice> druginvoices) {
		this.druginvoices = druginvoices;
	}

	private PaymenttypeManager paymenttypeManager;

	public PaymenttypeManager getPaymenttypeManager() {
		return paymenttypeManager;
	}

	public void setPaymenttypeManager(PaymenttypeManager paymenttypeManager) {
		this.paymenttypeManager = paymenttypeManager;
	}

	private Collection<Paymenttype> paymenttypes;

	public Collection<Paymenttype> getPaymenttypes() {
		return paymenttypes;
	}

	public void setPaymenttypes(Collection<Paymenttype> paymenttypes) {
		this.paymenttypes = paymenttypes;
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

	private WarehouseManager warehouseManager;

	public WarehouseManager getWarehouseManager() {
		return warehouseManager;
	}

	public void setWarehouseManager(WarehouseManager warehouseManager) {
		this.warehouseManager = warehouseManager;
	}

	private Collection<Warehouse> warehouses;

	public Collection<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(Collection<Warehouse> warehouses) {
		this.warehouses = warehouses;
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

	private String node;

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	private double totalaftertax;

	public double getTotalaftertax() {
		return totalaftertax;
	}

	public void setTotalaftertax(double totalaftertax) {
		this.totalaftertax = totalaftertax;
	}

	private double vat;

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	private int warehouse;

	public int getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(int warehouse) {
		this.warehouse = warehouse;
	}

	private String identity;

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private int user;

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	private int paymenttype;

	public int getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(int paymenttype) {
		this.paymenttype = paymenttype;
	}

	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private String insurancenumber;

	public String getInsurancenumber() {
		return insurancenumber;
	}

	public void setInsurancenumber(String insurancenumber) {
		this.insurancenumber = insurancenumber;
	}

	private Date expireddate;

	public Date getExpireddate() {
		return expireddate;
	}

	public void setExpireddate(Date expireddate) {
		this.expireddate = expireddate;
	}

	private String inpatient;

	public String getInpatient() {
		return inpatient;
	}

	public void setInpatient(String inpatient) {
		this.inpatient = inpatient;
	}

	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String doctor;

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private int encounter;

	public int getEncounter() {
		return encounter;
	}

	public void setEncounter(int encounter) {
		this.encounter = encounter;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private int towarehouse;

	public int getTowarehouse() {
		return towarehouse;
	}

	public void setTowarehouse(int towarehouse) {
		this.towarehouse = towarehouse;
	}

	private int druginvoice;		
		
	private DruginvoicedetailManager druginvoicedetailManager;
	
	private Batchnumber batchnumber;	
	

	public  Batchnumber getBatchnumber() {
		return batchnumber;
	}

	public  void setBatchnumber(Batchnumber batchnumber) {
		this.batchnumber = batchnumber;
	}

	private Prescriptiondetail prescriptionDetail;
	
	

	public  Prescriptiondetail getPrescriptionDetail() {
		return prescriptionDetail;
	}

	public  void setPrescriptionDetail(
			Prescriptiondetail prescriptionDetail) {
		this.prescriptionDetail = prescriptionDetail;
	}
	
	private ProviderManager providerManager;
	
	private int provider;
	
	public ProviderManager getProviderManager() {
		return providerManager;
	}

	public void setProviderManager(ProviderManager providerManager) {
		this.providerManager = providerManager;
	}

	public int getProvider() {
		return provider;
	}

	public void setProvider(int provider) {
		this.provider = provider;
	}
	
	private String paymentMethod;
	
	
	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	private String tax;
	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}
	private Collection<Prescriptiondetail> prescriptiondetails;
	
	
	

	public Collection<Prescriptiondetail> getPrescriptiondetails() {
		return prescriptiondetails;
	}

	public void setPrescriptiondetails(
			Collection<Prescriptiondetail> prescriptiondetails) {
		this.prescriptiondetails = prescriptiondetails;
	}

	public String execute() throws Exception {
		try {
			
     	   DefaultSecurity ds = new DefaultSecurity();
       	   
       	   boolean matched = ds.checkRight(fname, aname);  
       	     
       	   if (matched == false) return "noprivilege";
       	   
			String code = druginvoiceManager.genCode("PX");

			Druginvoice druginvoice = new Druginvoice();

			druginvoice.setNode(node);

			druginvoice.setTotalaftertax(totalaftertax);

			druginvoice.setVat(vat);

			druginvoice.setWarehouse(warehouseManager.getWarehouse(warehouse));

			druginvoice.setIdentity(identity);

			druginvoice.setDate(date);

		
			druginvoice.setPaymenttype(paymenttypeManager
					.getPaymenttype(paymenttype));

			druginvoice.setTotal(total);

			druginvoice.setInsurancenumber(insurancenumber);

			druginvoice.setExpireddate(expireddate);

			druginvoice.setInpatient(inpatient);

			druginvoice.setCode(code);

			druginvoice.setDoctor(doctor);

			druginvoice.setAddress(address);

			druginvoice.setEncounter(encounterManager.getEncounter(encounter));

			druginvoice.setType(type);

			druginvoice.setTowarehouse(warehouseManager
					.getWarehouse(towarehouse));
			
			druginvoice.setProvider(providerManager.getProvider(provider));
			
			druginvoice.setUser(userManager.getUser(user));
			
			druginvoice.setPaymentMethod(paymentMethod);
			
			druginvoice.setTax(tax);
			

			if (paymentMethod.equalsIgnoreCase("TU"))
			{
				druginvoice.setPrepaidCard(druginvoice.getEncounter().getPrepaidCard());
			}	
		
			//this case auto insert
			int flag = 0;

			if (encounterManager.getEncounter(encounter) != null)
			{
				flag = 1;
			}
				
			if (flag == 1) {
				druginvoice.setNode(encounterManager.getEncounter(encounter)
						.getClient().getNode());

				druginvoice.setAddress(encounterManager.getEncounter(encounter)
						.getClient().getAddress());

				//druginvoice.setDate(new Date());
			}

			//System.out.println("di="+druginvoice);
			druginvoiceManager.addDruginvoice(druginvoice);

			//also add detail
			if (flag == 1) {
				Collection<Prescriptiondetail> pds = encounterManager.getEncounter(encounter).getPrescriptiondetails();
				
				prescriptiondetails = new ArrayList<Prescriptiondetail>();
				
		   		for(Prescriptiondetail psd: encounterManager.getEncounter(encounter).getPrescriptiondetails())
		   		{
		   			prescriptiondetails.add(psd);
		   		}
		   		
		   		Collections.sort((List<Prescriptiondetail>) prescriptiondetails);

				for (Prescriptiondetail pd : prescriptiondetails) 
				{
					System.out.println("id druginvoicedetail " + pd.getId() + "node" + pd);
					//System.out.println("truoc if price > 0: price = " + pd.getDrug().getPrice());
					if(pd.getDrug().getPrice() > 0)
					{
						//System.out.println("price = " + pd.getDrug().getPrice());
						//System.out.println("drug id  = " + pd.getDrug().getId());
						int quantity = pd.getQuantity();
						
						while(quantity > 0){
							Druginvoicedetail dd = new Druginvoicedetail();
						
							int remain = quantity;
							int take = 0;
							int balance = 0;
							int i=0;
							
							//System.out.println("new drug invoice detail");
							
							dd.setDrug(pd.getDrug());
							dd.setQuantity(quantity);
							dd.setPrice(pd.getPrice());
							dd.setDruginvoice(druginvoice);
							dd.setSubtotal(pd.getPrice() * quantity);
							dd.setDruginvoice(druginvoice);
							
							total += dd.getSubtotal();
	
							//add batch number
							String sql = " select  batchnumber, expireddate, expiredmonth, " +
							" if(sum(quantity) is null, 0, sum(quantity)) as nhap ," +
							"   (select if(sum(quantity) is null, 0, sum(quantity)) " +
							"   from druginvoicedetail dd inner join druginvoice di on dd.druginvoice=di.id " +
							"   where dd.drug=d.drug and dd.batchnumber=d.batchnumber and di.warehouse="+warehouse+") as xuat ,  " +
							" if( sum(quantity) is null, 0,sum(quantity) ) -  " +
							"   (select if(sum(quantity) is null, 0, sum(quantity)) " +
							"   from druginvoicedetail dd inner join druginvoice di on dd.druginvoice=di.id " +
							"   where dd.drug=d.drug and dd.batchnumber=d.batchnumber and di.warehouse="+warehouse+") as ton " +
							" from importinvoicedetail d inner join importinvoice i on i.id=d.importinvoice " +
							" where warehouse = "+warehouse+" and drug="+ dd.getDrug().getId() +
							" group by  batchnumber, expireddate, expiredmonth order by expireddate";
			
							ResultSet rs = druginvoicedetailManager.getResultset(sql);

							List<Batchnumber> batchnumbers = new ArrayList<Batchnumber>();
	
							while (rs.next()) 
							{
								if (rs.getInt("ton") > 0)
								{
									Batchnumber bn = new Batchnumber();
									bn.setBatchnumber(rs.getString("batchnumber"));
									bn.setExpireddate(rs.getDate("expireddate"));
									bn.setExpiredmonth(rs.getString("expiredmonth"));
									bn.setRemain(rs.getInt("ton"));
									batchnumbers.add(bn);
									break;
								}				
							}//while
							
							//System.out.println("batchnumber.size = " + batchnumbers.size());
							if(batchnumbers.size()>0)
							{
								while(remain>0 && i<batchnumbers.size())
								{
									Batchnumber bn = batchnumbers.get(i);
									take = remain;							
									remain = bn.getRemain() - remain;
									if(remain<0)
									{
										take = bn.getRemain(); //get all of remaining drugs of this batch
										remain = -1*remain;
										quantity = remain;
									} else {
										quantity = 0;
									}
				
									dd.setBatchnumber(bn.getBatchnumber());
									dd.setExpireddate(bn.getExpireddate());
									dd.setExpiredmonth(bn.getExpiredmonth());
									dd.setQuantity(take);
									dd.setPrice(pd.getPrice());
									dd.setSubtotal(dd.getPrice()*dd.getQuantity());
									druginvoicedetailManager.addDruginvoicedetail(dd); //only add if in-stock
									
									i++;
								}
							}else//batchnumbers.size<=0		
							{
					
								break;
							}
							//System.out.println("trong while");
					}//while(quantity > 0 )
					}//(if price > 0)
					//System.out.println("end while");
				}//for
			}//if
	
			
			id = druginvoice.getId();	
			Druginvoice di = druginvoiceManager.getDruginvoice(id);
			di.setTotal(total);
			totalaftertax = total*(100+vat)/100;
			di.setTotalaftertax(totalaftertax);
			druginvoiceManager.updateDruginvoice(di);
			
			//System.out.println(di.getDruginvoicedetails());
						
			return SUCCESS;

		} catch (Exception e) {
			System.out.println("Error DruginvoiceAddAction");
			e.printStackTrace();
			return ERROR;
		}
	}

	public DruginvoicedetailManager getDruginvoicedetailManager() {
		return druginvoicedetailManager;
	}

	public void setDruginvoicedetailManager(
			DruginvoicedetailManager druginvoicedetailManager) {
		this.druginvoicedetailManager = druginvoicedetailManager;
	}


}