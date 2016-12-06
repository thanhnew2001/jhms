package com.ph.hms.action.util;

import java.sql.ResultSet;
import java.util.*;

import org.springframework.context.ApplicationContext;

import com.ph.hms.*;

import com.opensymphony.xwork.*;

public class GetBatchnumberAction extends ActionSupport {

	private int drugid;

	public int getDrugid() {
		return drugid;
	}

	public void setDrugid(int drugid) {
		this.drugid = drugid;
	}

	private int warehouseid;
	
	

	private DruginvoicedetailManager druginvoicedetailManager;

	public DruginvoicedetailManager getDruginvoicedetailManager() {
		return druginvoicedetailManager;
	}

	public void setDruginvoicedetailManager(
			DruginvoicedetailManager druginvoicedetailManager) {
		this.druginvoicedetailManager = druginvoicedetailManager;
	}

	private Collection<Batchnumber> batchnumbers;
	
	
	public Collection<Batchnumber> getBatchnumbers() {
		return batchnumbers;
	}

	public void setBatchnumbers(Collection<Batchnumber> batchnumbers) {
		this.batchnumbers = batchnumbers;
	}
	
	private int requestQuantity;
	
	
	public int getRequestQuantity() {
		return requestQuantity;
	}

	public void setRequestQuantity(int requestQuantity) {
		this.requestQuantity = requestQuantity;
	}
	


	public String execute() throws Exception {
		try {

			String sql = " select  batchnumber, expireddate, expiredmonth, d.price, " +
			" if(sum(quantity) is null, 0, sum(quantity)) as nhap ," +
			"   (select if(sum(quantity) is null, 0, sum(quantity)) " +
			"   from druginvoicedetail dd inner join druginvoice di on dd.druginvoice=di.id " +
			"   where dd.drug=d.drug and dd.batchnumber=d.batchnumber and di.warehouse="+warehouseid+") as xuat ,  " +
			" if( sum(quantity) is null, 0,sum(quantity) ) -  " +
			"   (select if(sum(quantity) is null, 0, sum(quantity)) " +
			"   from druginvoicedetail dd inner join druginvoice di on dd.druginvoice=di.id " +
			"   where dd.drug=d.drug and dd.batchnumber=d.batchnumber and di.warehouse="+warehouseid+") as ton " +
			" from importinvoicedetail d inner join importinvoice i on i.id=d.importinvoice " +
			" where warehouse = "+warehouseid+" and drug="+drugid +
			" group by  batchnumber, expireddate, expiredmonth order by expireddate";
			
	//		System.out.println(sql);
			ResultSet rs = druginvoicedetailManager.getResultset(sql);
			
			batchnumbers = new ArrayList<Batchnumber>();

			while (rs.next()) {

				Batchnumber bn = new Batchnumber();
				
				bn.setBatchnumber(rs.getString("batchnumber"));
				bn.setExpireddate(rs.getDate("expireddate"));
				bn.setExpiredmonth(rs.getString("expiredmonth"));
				bn.setRemain(rs.getInt("ton"));
				bn.setPrice(rs.getInt("price"));
				
				//if(bn.getRemain() > 0)
				batchnumbers.add(bn);
				
			}
			
			System.out.println(rs);
			return SUCCESS;

		} 
		
		catch (Exception e) {
			System.out.println("Loi gi gi do");
			e.printStackTrace();
			return ERROR;
		}

	}

	public int getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(int warehouseid) {
		this.warehouseid = warehouseid;
	}
}
