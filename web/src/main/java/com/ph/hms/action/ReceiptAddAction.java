package com.ph.hms.action;
import java.util.*;
import java.sql.ResultSet;
import java.text.*;

import com.ph.hms.*;
import com.ph.hms.action.util.*;

import com.opensymphony.xwork.*;

public class ReceiptAddAction extends ActionSupport
{
	public String fname = "receipt";
	public String aname = "add";
	

	private int id;
		
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	private ReceiptManager receiptManager;
	
	public ReceiptManager getReceiptManager() {
		return receiptManager;
	}

	public void setReceiptManager(ReceiptManager receiptManager) {
		this.receiptManager = receiptManager;
	}
	
	private ReceiptdetailManager receiptdetailManager;
	
	
	
	private Collection<Receipt> receipts;
	
	public Collection<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(Collection<Receipt> receipts) {
		this.receipts = receipts;
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

	
	
	private int encounter;   
		
	
	public int getEncounter()
	{
		return encounter;
	}
	
	public void setEncounter(int encounter)
	{
		this.encounter =  encounter;
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
	
	private String node;   
		
	
	public String getNode()
	{
		return node;
	}
	
	public void setNode(String node)
	{
		this.node =  node;
	}
	
	private double total;   
		
	
	public double getTotal()
	{
		return total;
	}
	
	public void setTotal(double total)
	{
		this.total =  total;
	}
	
	private String paymentmethod;   
		
	
	public String getPaymentmethod()
	{
		return paymentmethod;
	}
	
	public void setPaymentmethod(String paymentmethod)
	{
		this.paymentmethod =  paymentmethod;
	}
	
	private double discount;   
		
	
	public double getDiscount()
	{
		return discount;
	}
	
	public void setDiscount(double discount)
	{
		this.discount =  discount;
	}
	
	private int user;   
		
	
	public int getUser()
	{
		return user;
	}
	
	public void setUser(int user)
	{
		this.user =  user;
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
	
	private String payfor;   
		
	
	public String getPayfor()
	{
		return payfor;
	}
	
	public void setPayfor(String payfor)
	{
		this.payfor =  payfor;
	}
	
	private double actualpay;   
		
	
	public double getActualpay()
	{
		return actualpay;
	}
	
	public void setActualpay(double actualpay)
	{
		this.actualpay =  actualpay;
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
	
	private int paymenttype;   
		
	
	public int getPaymenttype()
	{
		return paymenttype;
	}
	
	public void setPaymenttype(int paymenttype)
	{
		this.paymenttype =  paymenttype;
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
	
	private String address;   
		
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address =  address;
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
	
	private String phone;   
		
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone =  phone;
	}
	
	private IndicationdetailManager indicationdetailManager;

	public  IndicationdetailManager getIndicationdetailManager() {
		return indicationdetailManager;
	}

	public  void setIndicationdetailManager(
			IndicationdetailManager indicationdetailManager) {
		this.indicationdetailManager = indicationdetailManager;
	}
	private String prepaidCard;
	
	

	public String getPrepaidCard() {
		return prepaidCard;
	}

	public void setPrepaidCard(String prepaidCard) {
		this.prepaidCard = prepaidCard;
	}
	private Collection<Indicationdetail> indicationdetails;
	
	
	
	public Collection<Indicationdetail> getIndicationdetail() {
		return indicationdetails;
	}

	public void setIndicationdetail(Collection<Indicationdetail> indicationdetail) {
		this.indicationdetails = indicationdetails;
	}

	public String execute() throws Exception
    {
		
		boolean is110 = false;
		
        try{
        	
     	   i18n = i18nManager.geti18n();	

    	   DefaultSecurity ds = new DefaultSecurity();
    	   
    	   boolean matched = ds.checkRight(fname, aname);  
    	     
    	   if (matched == false) return "noprivilege";

			String code = receiptManager.genCode("PT");
			
        	Receipt receipt = new Receipt();
			
			//typical case
			receipt.setEncounter(encounterManager.getEncounter(encounter));
	
			receipt.setCode(code);
	
			receipt.setNode(node);
			
			//receipt.setTotal(total);
			
			receipt.setPaymentmethod(paymentmethod);
			
			if (paymentmethod.equalsIgnoreCase("TU"))
			{
				receipt.setPrepaidCard(receipt.getEncounter().getPrepaidCard());
			}	
				
			if (paymentmethod.equalsIgnoreCase("TT"))
			{
				receipt.setPrepaidCard(prepaidCard);
			}

			receipt.setDiscount(discount);
	
			receipt.setUser(userManager.getUser(user));
	
			receipt.setDate(date);
	
			receipt.setPayfor(payfor);
	
			receipt.setActualpay(actualpay);
	
			receipt.setInsurancepay(insurancepay);
	
			receipt.setPaymenttype(paymenttypeManager.getPaymenttype(paymenttype));
	
			receipt.setBirthday(birthday);
	
			receipt.setAddress(address);
	
			receipt.setAge(age);
	
			receipt.setPhone(phone);
			
			
			int flag =0;
			//this case auto insert
			
			if (encounterManager.getEncounter(encounter)!=null) flag =1;
			
			if (flag == 1)
			{
				receipt.setNode(encounterManager.getEncounter(encounter).getClient().getNode());
				
				receipt.setAddress(encounterManager.getEncounter(encounter).getClient().getAddress());
				
				receipt.setBirthday(encounterManager.getEncounter(encounter).getClient().getBirthday());
		
				receipt.setPaymenttype(paymenttypeManager.getPaymenttype(1));								
				
			}
			
			receiptManager.addReceipt(receipt);
			
			//also add detail
			
			total =0;
			
			
			if (flag == 1) //auto insert
			{
				indicationdetails = new ArrayList<Indicationdetail>();
				
				//Collection<Indicationdetail> ids = encounterManager.getEncounter(encounter).getIndicationdetails();
				for(Indicationdetail ids :  encounterManager.getEncounter(encounter).getIndicationdetails())
		   		{
					indicationdetails.add(ids);
		   		}
		   		
		   		Collections.sort((List<Indicationdetail>) indicationdetails);
				int i = 0;
				for (Indicationdetail id : indicationdetails)
				{
					
					//but only detail which is not paid
					System.out.println("id indicationdetail " + id.getId() + "node" + id);
					i++;
					
					if (id.getPaid().equalsIgnoreCase("N"))
					{
					Receiptdetail rd = new Receiptdetail();
					
					rd.setService(id.getService());
					rd.setQuantity(id.getQuantity());
					rd.setPrice(id.getPrice());
					
					
					String promotionCode = id.getEncounter().getPromotionCode();
					
					Promotion promotion = new Promotion();
					
					double percentDiscount = 0;
					
					if (promotionCode==null)
					{
					//	System.out.println("promotionCode == null");
					}
					
					
					if (promotionCode!=null && promotionCode.length()>2)
					{
						promotion = encounterManager.getPromotion(promotionCode.substring(0,2));

					}
					
/*
	///////////////////////chay cham////////////////////////////////////
					if (promotion!=null)
					{
						if (encounterManager.isUsed(promotionCode))
						{
							percentDiscount = promotion.getPercentDiscount();
						}
						else
						{
							percentDiscount = promotion.getFirstUseDiscount();
						}
						
						int checkupServiceGroup = Integer.parseInt(i18n.get("checkupservicegroup"));
						
						is110 = false;
						System.out.println("ServiceGroup = " + rd.getService().getServicegroup().getId());
						if (rd.getService().getServicegroup().getId() == checkupServiceGroup) //only discount for checkup
						{
							is110 = true;
							
							rd.setPercentdiscount(percentDiscount);							
						}
						else
							rd.setPercentdiscount(0);		
						
					}
	///////////////////////////////////////////////////////////////////////////////
					
*/				
//////////////////////////Viet sua////////////////////////////////////////////
					if(promotionCode == ""){
						//System.out.println("promotionCode == ");

					}
					
					if (!promotionCode.equalsIgnoreCase("") || promotionCode!=null)
					{
						String sql = "";
						
	
						sql = "select count(id) as numUsed from encounter where promotionCode = '" +
									promotionCode + "' ";
			
						
						ResultSet rset = hmsDataManager.getResultset(sql);	
						
						//System.out.println(sql);
						
						while(rset.next())
						{
							//System.out.println("numUsed =  "+ rset.getInt("numUsed"));
							if (rset.getInt("numUsed") > 1)
							{
								//System.out.println("numUsed > 1");
								percentDiscount = promotion.getPercentDiscount();
								//System.out.println("percentDiscount = " + percentDiscount);
							}
							else
							{
								//System.out.println("numUsed = 1");
								percentDiscount = promotion.getFirstUseDiscount();
								//System.out.println("percentDiscount = " + percentDiscount);
							}
															
						}
						int checkupServiceGroup = Integer.parseInt(i18n.get("checkupservicegroup"));
						
						is110 = false;
						//System.out.println("ServiceGroup = " + rd.getService().getServicegroup().getId());
						
						if (rd.getService().getServicegroup().getId() == checkupServiceGroup) //only discount for checkup
						{
							is110 = true;
							
							rd.setPercentdiscount(percentDiscount);							
						}
						else
						{
							rd.setPercentdiscount(0);	
						}
					}
///////////////////////////////////////////////////////////////////////////////////////////////	
					//Tinh khuyen mai cho tung dich vu
					
					//System.out.println("Tinh khuyen mai cho tung dich vu");
					
					Double percentdiscount = 0.0;
					Double discount = 0.0;
					
					//Checkup service
					if(is110)
					{		
						//System.out.println("is110");
						percentdiscount = percentDiscount;
					} else // not check up service
					{
					
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String encounterDate = sdf.format(receipt.getEncounter().getDate());
						
						String q =  "select percentdiscount,discount from promotionservice where (servicegroup='" +rd.getService().getServicegroup().getId()+ "' " +
									"or  service ='" + rd.getService().getId() + "')" +
									"and startdate<='" + encounterDate + "'" +
								    "and enddate>='" + encounterDate + "'";
						
						
						ResultSet rs = hmsDataManager.getResultset(q);
						//System.out.println("tinh KM dich vu khac checkup");
						
						//dich vu chi co service khuyen mai hoac serviceGroup khuyen mai
						if(rs.getRow()== 1)
						{
							if(rs.getDouble("percentdiscount") != 0){
								percentdiscount = rs.getDouble("percentdiscount");
							}else {
								discount = rs.getDouble("discount");
							}
							
						}
						//dich vu co nhieu chuong trinh khuyen mai, lay gia tri khuyen mai lon nhat
						else if (rs.getRow()> 1){
							while(rs.next())
							{
								if(rs.getDouble("percentdiscount") != 0)
								{
									if(rs.getDouble("percentdiscount") > percentdiscount)
										{
											percentdiscount = rs.getDouble("percentdiscount");
										}
								}else {
									if(rs.getDouble("discount") > discount)
									{
										discount = rs.getDouble("discount");
									}
									
								}
							}
			
						}
							
					}
					
					//System.out.println("percentDiscount = " + percentdiscount);
					//System.out.println("discount = " + discount);

					rd.setPercentdiscount(percentdiscount);
					
					if(percentdiscount != 0)
					{
						discount = rd.getQuantity()*rd.getPrice()*rd.getPercentdiscount()/100;
					}
					
					//end phan tinh khuyen mai cho tung dich vu
					
										
					rd.setSubtotal(rd.getQuantity()*rd.getPrice()*(1-rd.getPercentdiscount()/100));
					rd.setDiscount(discount);
					rd.setReceipt(receipt);
					
					total += rd.getSubtotal();
					
					receiptdetailManager.addReceiptdetail(rd);
					
					id.setPaid("Y");
					
					indicationdetailManager.updateIndicationdetail(id);
					
					
					}//for
				}				
			}       			
			
		
			id = receipt.getId();
			Receipt rpt = receiptManager.getReceipt(id);
			actualpay = total - insurancepay - discount;
			rpt.setTotal(total);
			rpt.setActualpay(actualpay);
			receiptManager.updateReceipt(rpt);

        	
        	return SUCCESS;

        }
        catch(Exception e){
            System.out.println("Loi ReceiptAddAction");
            e.printStackTrace();
            return ERROR;
        }       
    }

	public ReceiptdetailManager getReceiptdetailManager() {
		return receiptdetailManager;
	}

	public void setReceiptdetailManager(ReceiptdetailManager receiptdetailManager) {
		this.receiptdetailManager = receiptdetailManager;
	}
	
	private HMSDataManager hmsDataManager;

	public HMSDataManager getHmsDataManager() {
		return hmsDataManager;
	}

	public void setHmsDataManager(HMSDataManager hmsDataManager) {
		this.hmsDataManager = hmsDataManager;
	}
}
